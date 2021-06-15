package github.botapi.destiny2.service.impl;

import com.alibaba.fastjson.JSON;
import github.botapi.destiny2.constant.AuthoritativeApiConstant;
import github.botapi.destiny2.dto.SearchDestinyPlayerDTO;
import github.botapi.destiny2.enums.MembershipType;
import github.botapi.destiny2.service.D2ApiService;
import github.botapi.steam.service.constant.SteamDevConstant;
import github.botapi.steam.service.dto.GetPlayerSummariesDTO;
import github.botapi.util.service.HttpRequestService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private HttpRequestService httpRequestService;

    private Map<String, String> D2Headers = AuthoritativeApiConstant.getAPIKey();


    public Long getSteamIDByD2(String name) {
        SearchDestinyPlayerDTO responseDto = SearchDestinyPlayer(name);
        if (MembershipType.Steam.getTypeID().equals(responseDto.getResponse().get(0).getMembershipType())) {
            return parseSteamID(Long.valueOf(responseDto.getResponse().get(0).getMembershipId()));
        }
        System.out.println("玩家不是steam平台用户，无法查询steamid");
        return null;
    }

    public Long parseSteamID(Long membershipId) {
        try {
            Document doc = Jsoup.connect(AuthoritativeApiConstant.getProfileUrl(membershipId)).get();
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

    public SearchDestinyPlayerDTO SearchDestinyPlayer(String name) {
        String res = httpRequestService.Get(AuthoritativeApiConstant.getSEARCHDESTINYPLAYER(name, -1), D2Headers);
        SearchDestinyPlayerDTO responseDto = JSON.parseObject(res, SearchDestinyPlayerDTO.class);
        System.out.println("responseDto = " + responseDto);
        return responseDto;
    }

    public SearchDestinyPlayerDTO SearchDestinyPlayer(Long steamID) {
        String res = httpRequestService.Get(SteamDevConstant.STEAM_WEB_URL_GETPLAYERSUMMARIES, String.format("key=%s&steamids=%d", SteamDevConstant.STEAM_WEB_API_KEY, steamID));
        System.out.println("res = " + res);
        GetPlayerSummariesDTO responseDto = JSON.parseObject(res, GetPlayerSummariesDTO.class);
        System.out.println("responseDto = " + responseDto);
        return SearchDestinyPlayer("娃哈哈店长");
    }
}
