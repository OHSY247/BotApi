package github.botapi.destiny2.constant;

import java.util.HashMap;
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
    public static String BASE = ROOT + "/Platform/";
    public static String MANIFEST = BASE + "/Destiny2/Manifest/";
    public static Map<String, String> HEADERS;
    public static String HEADER_AUTH_KEY = "X-API-Key";
    public static String SUCCESS_MSG = "Ok";
    /**
     * @author straycamel
     * @date 2021/6/9
     * 命运2版本号存储在本地的key值
     */
    public static String VERSION_FLAG = "DESTINY2_MAIFEST_VERSION";
    /**
     * @author straycamel
     * @date 2021/6/15
     * https://www.bungie.net/Platform/Destiny2/SearchDestinyPlayer/-1/娃哈哈店长/
     * 通过名字获取玩家基本信息
     */
    private static String SEARCHDESTINYPLAYER = BASE + "/Destiny2/SearchDestinyPlayer";
    /**
     * @author straycamel
     * @date 2021/6/15https://www.bungie.net/Platform/User/GetMembershipsById/4611686018490704250/-1/
     * 获取玩家的信息
     */
    private static String GETMEMBERSHIPSBYID = BASE + "/User/GetMembershipsById";
    /**
     * @author straycamel
     * @date 2021/6/15
     * 获取玩家steamid的数据
     */
    private static String ProfileUrl = ROOT + "/en/Profile";

    public static Map<String, String> getAPIKey() {
        Map<String, String> Headers;
        Headers = new HashMap<>();
        Headers.put(AuthoritativeApiConstant.HEADER_AUTH_KEY, "09ab307be6e34bf1b80f403d4e20a9fc");
        return Headers;
    }

    public static String getSEARCHDESTINYPLAYER(String name, int typeFlag) {
        return String.format(SEARCHDESTINYPLAYER + "/%d/%s", typeFlag, name);
    }

    public static String getGETMEMBERSHIPSBYID(Long D2Id, int typeFlag) {
        return String.format(GETMEMBERSHIPSBYID + "/%d/%d", D2Id, typeFlag);
    }

    public static String getProfileUrl(Long membershipId) {
        return String.format(ProfileUrl + "/%d", membershipId);
    }
}
