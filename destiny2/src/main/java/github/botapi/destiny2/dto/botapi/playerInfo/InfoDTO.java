package github.botapi.destiny2.dto.botapi.playerInfo;

import lombok.Data;

/**
 * @author straycamel
 * @date 2021/6/15
 * 玩家基本信息
 */
@Data
public class InfoDTO extends BaseInfoDTO {
    public InfoDTO(){
        super();
    }
    private Long steamID;
    private Long MembershipId;
    private String Platform;
}
