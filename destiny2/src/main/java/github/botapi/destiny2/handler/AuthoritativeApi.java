package github.botapi.destiny2.handler;

import com.alibaba.fastjson.JSONObject;
import github.botapi.util.handler.BackEndHttpRequest;
import github.botapi.util.handler.FileHandler;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
/**
 * @author straycamel
 * @date 2021/5/24
 * 根据官方api[https://bungie-net.github.io/]设定
 * 请求接口时加上header参数X-API-Key，key申请地址在[https://www.bungie.net/en/Application]
 * 定义官方接口的接口url；数据的下载解压
 */
public class AuthoritativeApi extends BackEndHttpRequest {
    /**
     * org.springframework.web.util[https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/util/package-summary.html]
     */
    public String ROOT = "https://www.bungie.net";
    public String BASE = ROOT+"/Platform/";
    public String MANIFEST = BASE + "/Destiny2/Manifest/";
    public String TEST_URL = ROOT+"/common/destiny2_content/sqlite/zh-chs/world_sql_content_8e7a4415b88b2a066d1d8f8267feced8.content";
    public Map<String, String> HEADERS;
    public String SUCCESS_MSG ="Ok";
    public String Version = "default";
    public AuthoritativeApi(String version){
        Version = version;
        loadXAPIKey();
    }
    public AuthoritativeApi(){
        loadXAPIKey();
    }
    public void loadXAPIKey(){
         HEADERS = new HashMap<>();
         HEADERS.put("X-API-Key","09ab307be6e34bf1b80f403d4e20a9fc");
    }
    public String getManifest(){
        return sendGet(MANIFEST, HEADERS);
    }

    /**
     * 对manifest数据进行检查
     * - 若最新版本为当前版本，则不用更新；
     * - 若最新版本不为当前版本，则返回最新的sql文件url
     * @return Map，key为language，value为sql文件url
     */
    public Map<String,String> getLastManifestContent() {
        JSONObject object = JSONObject.parseObject(getManifest());
        if (object.getString("Message").equals(SUCCESS_MSG)){
            JSONObject response = object.getJSONObject("Response");
            String lastVersion = (String) response.get("version");
            System.out.printf("Manifest 数据检查-当前version：%s，最新version：%s\n",Version,lastVersion);
            if(!Version.equals(lastVersion)){
                Map<String,String> mobileWorldContentPaths = JSONObject.toJavaObject(response.getJSONObject("mobileWorldContentPaths"),Map.class);
                Version = lastVersion;
                return mobileWorldContentPaths;
            } else {
                System.out.println("manifest 数据已为最新");
            }
        }else{
            System.out.println("manifest 数据获取错误; Message: "+object.get("Message"));
        }
        return null;
    }
    /**
     * 数据批量下载并自动解压manifest所有数据
     * @param url 下载的url
     * @param downloadDir 下载存放的路径
     * @param dataDir 解压后的文件路径
     */
    public void downloadManifest(String url,String downloadDir, String dataDir){
        String filePath = downloadFromUrl(url,downloadDir);
        FileHandler.unZip(new File(filePath),dataDir);
    }
}
