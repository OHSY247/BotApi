package github.botapi.destiny2.service;

import github.botapi.destiny2.dto.SearchDestinyPlayerDTO;

/**
 * @author straycamel
 * @date 2021/6/15
 */
public interface D2ApiService {
    /**
     * @author straycamel
     * @date 2021/6/15
     * 通过用户名称查找steamid
     */
    Long getSteamIDByD2(String name);

    /**
     * @author straycamel
     * @date 2021/6/15
     * 解析html，解析出steamid
     */
    Long parseSteamID(Long membershipId);

    /**
     * @return
     * @author straycamel
     * @date 2021/6/15
     * 通过命运玩家的名字获取基本数据
     */
    SearchDestinyPlayerDTO SearchDestinyPlayer(String name);

    /**
     * @return
     * @author straycamel
     * @date 2021/6/15
     * 通过steamid
     */
    SearchDestinyPlayerDTO SearchDestinyPlayer(Long Id);
}
