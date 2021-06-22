package github.botapi.destiny2.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author straycamel
 * @date 2021/6/8
 */
public class D2ApiConstant {
    /**
     * destiny2 官方接口基础api常量定义
     */
    public static String ROOT = "https://www.bungie.net";
    public static String BASE = ROOT + "/Platform/";
    public static String MANIFEST = BASE + "/Destiny2/Manifest/";
    public static Map<String, String> HEADERS;
    public static String HEADER_AUTH_KEY = "X-API-Key";
    public static String SUCCESS_MSG = "Ok";
    /**
     * 命运2版本号存储在本地的key值
     */
    public static String VERSION_FLAG = "DESTINY2_MANIFEST_VERSION";
    /**
     * https://www.bungie.net/Platform/Destiny2/SearchDestinyPlayer/-1/娃哈哈店长/
     * 通过名字获取玩家基本信息
     */
    private static final String SEARCHDESTINYPLAYER = BASE + "/Destiny2/SearchDestinyPlayer";
    /**
     * https://www.bungie.net/Platform/User/GetMembershipsById/4611686018490704250/-1/
     * 获取玩家的信息
     */
    private static final String GETMEMBERSHIPSBYID = BASE + "/User/GetMembershipsById";
    /**
     * 获取玩家steamid的数据--用于解析html纪念性获取
     */
    private static String ProfileUrl = ROOT + "/en/Profile";
    /**
     * 获取玩家数据
     * https://www.bungie.net/Platform/Destiny2/-1/Profile/4611686018490704250/LinkedProfiles/
     */
    private static final String LinkedProfilesUrl = BASE+"/Destiny2/&d/Profile/&d/LinkedProfiles/";

    /**
     *
     */
    private static final String mergedDeletedCharactersUrl = BASE+"/Destiny2/%d/Account/%d/Stats/";
    public static String getMergedDeletedCharactersUrl(Long membershipType, Long membershipId) {
        return String.format(LinkedProfilesUrl, membershipType, membershipId);
    }
    public static String getLinkedProfilesUrl(Long membershipType, Long membershipId) {
        return String.format(LinkedProfilesUrl, membershipType, membershipId);
    }

    public static String getProfileUrl(Long membershipId) {
        return String.format(ProfileUrl + "/%d", membershipId);
    }

    public static String getGETMEMBERSHIPSBYID(Long membershipId, int membershipType) {
        return String.format(GETMEMBERSHIPSBYID + "/%d/%d", membershipId, membershipType);
    }

    public static String getSEARCHDESTINYPLAYER(String name, int membershipType) {
        return String.format(SEARCHDESTINYPLAYER + "/%d/%s", membershipType, name);
    }

    public static Map<String, String> getAPIKey() {
        Map<String, String> Headers;
        Headers = new HashMap<>();
        Headers.put(D2ApiConstant.HEADER_AUTH_KEY, "09ab307be6e34bf1b80f403d4e20a9fc");
        return Headers;
    }
}
