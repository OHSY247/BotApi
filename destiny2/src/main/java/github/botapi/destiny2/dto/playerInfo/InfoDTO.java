package github.botapi.destiny2.dto.playerInfo;

import lombok.Data;

/**
 * @author straycamel
 * @date 2021/6/15
 * 玩家基本信息
 */
@Data
public class InfoDTO {
    private Long SteamID;
    private String Name;
    private String Platform;
    private PveInfoDTO pve;
    private PvpInfoDTO pvp;
}
