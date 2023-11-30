package github.botapi.steam.service;

/**
 * @author straycamel
 * @date 2021/6/13
 * 提供steam id和玩家名称的相互查询
 * steam id基本的key-value--这里拿我自己的账号举例：nickname-娃哈哈店长
 * 文档/代码中的对应的描述以key值为准
 * Vanity URL    Stray_Camel--https://steamcommunity.com/id/Stray_Camel/
 * AccountID    379094934
 * SteamID    76561198339360662
 * Steam2 ID    STEAM_1:0:189547467
 * Steam3 ID    [U:1:379094934]
 * Invite URL    s.team/p/cjnm-mknj
 * CS:GO Friend    AUXVJ-JUGL
 * FiveM    steam:110000116988796
 */
public interface SteamIDService {
    /**
     * @author straycamel
     * @date 2021/6/13
     * 通过SteamID获取玩家名称-或者其他数据
     * https://partner.steamgames.com/doc/webapi/ISteamUser#GetPlayerSummaries
     */
    String GetPlayerSummaries();
}
