package github.botapi.steam.service.impl;

import github.botapi.util.service.HttpRequestService;

import static github.botapi.steam.service.constant.SteamDevConstant.STEAM_WEB_URL_GETPLAYERSUMMARIES;

/**
 * @author straycamel
 * @date 2021/6/13
 */
public class SteamIDServiceImpl {
    private HttpRequestService httpRequestService;

    public String GetPlayerSummaries(Long SteamID) {
        String res = httpRequestService.get(STEAM_WEB_URL_GETPLAYERSUMMARIES, "key=F4D9D4AC46C90E2E0F4D3D41E688DE8E&steamids=76561198339360662");
        return "";
    }
}
