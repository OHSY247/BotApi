package github.botapi.destiny2.handler;

import github.botapi.util.handler.BackEndHttpRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author straycamel
 * @date 2021/5/24
 * 根据官方api[https://bungie-net.github.io/]设定
 * 请求接口时加上header参数X-API-Key，key申请地址在[https://www.bungie.net/en/Application]
 */
public class AuthoritativeApi extends BackEndHttpRequest {
    /**
     * org.springframework.web.util[https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/util/package-summary.html]
     */
    public String BASE = "https://www.bungie.net/Platform/";
    public String MANIFEST = BASE + "Destiny2/Manifest/";
    // todo: 定义时初始化？
    public Map<String, String> HEADERS;
    public AuthoritativeApi(){
        System.out.println("初始化对象");
        HEADERS = new HashMap<String, String>();
        HEADERS.put("X-API-Key","09ab307be6e34bf1b80f403d4e20a9fc");
    }
    public String getMANIFESTContent(){
        return sendGet(MANIFEST, HEADERS);
    };
}
