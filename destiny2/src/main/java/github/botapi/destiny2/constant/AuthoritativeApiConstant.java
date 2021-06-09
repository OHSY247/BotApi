package github.botapi.destiny2.constant;

import java.util.Map;

/**
 * @author straycamel
 * @date 2021/6/8
 */
public class AuthoritativeApiConstant {
    /**
     * @author straycamel
     * @date 2021/6/9
     * destiny2 官方接口基础api常量定义
     */
    public static String ROOT = "https://www.bungie.net";
    public static String BASE = ROOT+"/Platform/";
    public static String MANIFEST = BASE + "/Destiny2/Manifest/";
    public static String TEST_URL = ROOT+"/common/destiny2_content/sqlite/zh-chs/world_sql_content_8e7a4415b88b2a066d1d8f8267feced8.content";
    public static Map<String, String> HEADERS;
    public static String HEADER_AUTH_KEY = "X-API-Key";
    public static String SUCCESS_MSG ="Ok";

    /**
     * @author straycamel
     * @date 2021/6/9
     * 命运2版本号存储在本地的key值
     */
    public static String VERSION_FLAG= "DESTINY2_MAIFEST_VERSION";
}
