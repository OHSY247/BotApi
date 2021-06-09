package github.botapi.destiny2.service.impl;

import com.alibaba.fastjson.JSONObject;
import github.botapi.destiny2.constant.AuthoritativeApiConstant;
import github.botapi.destiny2.service.AuthoritativeApiService;
import github.botapi.util.handler.BackEndHttpRequest;
import github.botapi.util.handler.FileHandler;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
/**
 * @author straycamel
 * @date 2021/6/8
 */
@Service
public class AuthoritativeApiServiceImpl implements AuthoritativeApiService {

    private Map<String, String> Headers;

    public AuthoritativeApiServiceImpl(){
        setAPIKey();
    }
    
    public void setAPIKey(){
         Headers = new HashMap<>();
         Headers.put(AuthoritativeApiConstant.HEADER_AUTH_KEY,"09ab307be6e34bf1b80f403d4e20a9fc");
    }
    
    public String getManifest(){
        return BackEndHttpRequest.sendGet(AuthoritativeApiConstant.MANIFEST, Headers);
    }
    
    public Map<String,String> getLastManifestContent() {
        JSONObject object = JSONObject.parseObject(getManifest());
        if (object.getString("Message").equals(AuthoritativeApiConstant.SUCCESS_MSG)){
            String Version = System.getenv(AuthoritativeApiConstant.VERSION_FLAG);
            JSONObject response = object.getJSONObject("Response");
            String lastVersion = (String) response.get("version");
            System.out.printf("Manifest 数据检查-当前version：%s，最新version：%s\n",Version,lastVersion);

            if (Version!=null&&Version.equals(lastVersion)){
                System.out.println("manifest 数据已为最新");
            } else {
                Map<String,String> mobileWorldContentPaths = JSONObject.toJavaObject(response.getJSONObject("mobileWorldContentPaths"),Map.class);
                System.setProperty(AuthoritativeApiConstant.VERSION_FLAG,lastVersion);
                return mobileWorldContentPaths;
            }

        }else{
            System.out.println("manifest 数据获取错误; Message: "+object.get("Message"));
        }
        return null;
    }
    public void downloadManifest(String url,String downloadDir, String dataDir){
        try {
            String filePath = BackEndHttpRequest.downloadFromUrl(url,downloadDir);
            FileHandler.unZip(new File(filePath),dataDir);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
