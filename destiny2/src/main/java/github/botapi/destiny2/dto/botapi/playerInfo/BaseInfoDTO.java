package github.botapi.destiny2.dto.botapi.playerInfo;

import lombok.Data;

import java.sql.Date;

/**
 * @author straycamel
 * @date 2021/6/15
 * 信息基类
 */
@Data
public abstract class BaseInfoDTO {
    private String Name;
    private Date LastAccess;
    private Date FirstAccess;
    private Long totalOnlineMin;
    private PveInfoDTO pve;
    private PvpInfoDTO pvp;
}
