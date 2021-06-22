package github.botapi.destiny2.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import github.botapi.destiny2.constant.D2ApiConstant;
import github.botapi.destiny2.dto.d2api.playerInfo.MergedDeletedCharactersDTO;
import github.botapi.destiny2.dto.d2api.playerInfo.SearchDestinyPlayerDTO;
import github.botapi.destiny2.enums.MembershipType;
import github.botapi.destiny2.service.D2ApiService;
import github.botapi.steam.service.constant.SteamDevConstant;
import github.botapi.steam.service.dto.GetPlayerSummariesDTO;
import github.botapi.util.handler.BackEndHttpRequest;
import github.botapi.util.handler.FileHandler;
import github.botapi.util.service.HttpRequestService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author straycamel
 * @date 2021/6/15
 */
@Service
public class D2ApiServiceImpl implements D2ApiService {
    private Map<String, String> Headers = D2ApiConstant.getAPIKey();

    @Override
    public Long getSteamIDByD2(String name) {
        SearchDestinyPlayerDTO responseDto = SearchDestinyPlayer(name);
        if (MembershipType.Steam.getTypeID().equals(responseDto.getResponse().get(0).getMembershipType())) {
            return parseSteamID(Long.valueOf(responseDto.getResponse().get(0).getMembershipId()));
        }
        System.out.println("玩家不是steam平台用户，无法查询steamid");
        return null;
    }

    @Override
    public Long parseSteamID(Long membershipId) {
        try {
            Document doc = Jsoup.connect(D2ApiConstant.getProfileUrl(membershipId)).get();
            Elements divs = doc.select("#profile-container .inner-text-content div");
            System.out.println(divs);
            for (Element e : divs) {
                System.out.println(e);
                if (e.attr("class").equals("title")) {
                    String pattern = "7656[0-9]{13}";
                    Pattern r = Pattern.compile(pattern);
                    Matcher m = r.matcher(e.text());
                    if (m.find()) {
                        String res = m.group(0);
                        return Long.valueOf(res);
                    } else {
                        System.out.println("NO MATCH");
                    }
                    return null;
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SearchDestinyPlayerDTO SearchDestinyPlayer(String name) {
        String res = httpRequestService.get(D2ApiConstant.getSEARCHDESTINYPLAYER(name, -1), D2Headers);
        SearchDestinyPlayerDTO responseDto = JSON.parseObject(res, SearchDestinyPlayerDTO.class);
        System.out.println("responseDto = " + responseDto);
        return responseDto;
    }

    @Override
    public SearchDestinyPlayerDTO SearchDestinyPlayer(Long steamID) {
        String res = httpRequestService.get(SteamDevConstant.STEAM_WEB_URL_GETPLAYERSUMMARIES, String.format("key=%s&steamids=%d", SteamDevConstant.STEAM_WEB_API_KEY, steamID));
        GetPlayerSummariesDTO responseDto = JSON.parseObject(res, GetPlayerSummariesDTO.class);
        System.out.println("responseDto = " + responseDto);
        return SearchDestinyPlayer(responseDto.getResponse().getPlayers().get(0).getPersonaname());
    }

    public MergedDeletedCharactersDTO getMergedDeletedCharacters(Long membershipType, Long membershipId) {
        String res = BackEndHttpRequest.sendGet(D2ApiConstant.getMergedDeletedCharactersUrl(membershipType, membershipId), Headers);
        MergedDeletedCharactersDTO resDTO = JSON.parseObject(res, MergedDeletedCharactersDTO.class);
        return resDTO;
    }

    @Override
    public String getManifest() {
        return BackEndHttpRequest.sendGet(D2ApiConstant.MANIFEST, Headers);
    }

    @Override
    public Map<String, String> getLastManifestContent() {
        JSONObject object = JSONObject.parseObject(getManifest());
        if (object.getString("Message").equals(D2ApiConstant.SUCCESS_MSG)) {
            String Version = System.getenv(D2ApiConstant.VERSION_FLAG);
            JSONObject response = object.getJSONObject("Response");
            String lastVersion = (String) response.get("version");
            System.out.printf("Manifest 数据检查-当前version：%s，最新version：%s\n", Version, lastVersion);

            if (Version != null && Version.equals(lastVersion)) {
                System.out.println("manifest 数据已为最新");
            } else {
                Map<String, String> mobileWorldContentPaths = JSONObject.toJavaObject(response.getJSONObject("mobileWorldContentPaths"), Map.class);
                System.setProperty(D2ApiConstant.VERSION_FLAG, lastVersion);
                return mobileWorldContentPaths;
            }

        } else {
            System.out.println("manifest 数据获取错误; Message: " + object.get("Message"));
        }
        return null;
    }

    @Override
    public void downloadManifest(String url, String downloadDir, String dataDir) {
        try {
            String filePath = BackEndHttpRequest.downloadFromUrl(url, downloadDir);
            FileHandler.unZip(new File(filePath), dataDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private HttpRequestService httpRequestService;

    private Map<String, String> D2Headers = D2ApiConstant.getAPIKey();


}
