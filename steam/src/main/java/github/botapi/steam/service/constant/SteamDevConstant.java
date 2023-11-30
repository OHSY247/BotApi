package github.botapi.steam.service.constant;

import github.botapi.util.constant.NetworkConstant;

/**
 * @author straycamel
 * @date 2021/6/15
 */
public class SteamDevConstant {
    public static final String STEAM_WEB_API_KEY = "F4D9D4AC46C90E2E0F4D3D41E688DE8E";
    public static final String STEAM_WEB_URL_ROOT = "https://api.steampowered.com";
    public static final String STEAM_WEB_URL_GETPLAYERSUMMARIES = new StringBuffer().append(STEAM_WEB_URL_ROOT).append(NetworkConstant.SEPARATOR).append("ISteamUser/GetPlayerSummaries/v2/").toString();

}
