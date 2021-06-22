package github.botapi.destiny2.service;

import github.botapi.destiny2.dto.botapi.playerInfo.InfoDTO;

/**
 * @author straycamel
 * @date 2021/6/15
 */
public interface PlayerInfoService {
    /**
     * @author straycamel
     * @date 2021/6/15
     */
    InfoDTO getPlayerInfo(String name);

}
