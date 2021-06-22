package github.botapi.destiny2.dto.botapi.playerInfo;

import lombok.Data;

import java.util.Map;

@Data
class BasePvPVO{
    private Long kill;
    private Long death;
    private Long assistant;
    private Long totalOnlineMin;
    private Long totalRound;
}

/**
 * @author straycamel
 * @date 2021/6/15
 * 玩家pvp信息
 */
@Data
public class PvpInfoDTO {
    private BasePvPVO all;
    private Map<String, BasePvPVO> detail;
}
