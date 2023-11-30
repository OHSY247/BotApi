package github.botapi.destiny2.dto.botapi.playerInfo;


import lombok.Data;

import java.util.Map;

@Data
class BasePvEVO {
    private Long kill;
    private Long death;
    private Long assistant;

    private Long totalRound;
}

/**
 * @author straycamel
 * @date 2021/6/15
 * 玩家pve信息
 */
@Data
public class PveInfoDTO {
    private BasePvEVO all;
    private Map<String, BasePvEVO> detail;
}
