package github.botapi.game.server;

import lombok.Data;

/**
 * eg: "startLoad:1658170842858","navigationStart:1658170842673","fetchStart:1658170842676","responseEnd:1658170843049","domContentLoadedEventStart:1658170843656","loadEventStart:1658170843657","loadEventEnd:1658170843665","finishLoad:1658170843687","T1:1658170844285"
 * ats 默认的数据结构
 *
 * @author straycamel
 * @date 2022/7/20
 */
@Data
public class AtsCheckPerformanceDetailDTO {
    private Long startLoad;
    private Long navigationStart;
    private Long fetchStart;
    private Long responseEnd;
    private Long domContentLoadedEventStart;
    private Long loadEventStart;
    private Long loadEventEnd;
    private Long finishLoad;
    private Long T1;
}
