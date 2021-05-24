package github.botapi.destiny2.handler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author straycamel
 * @date 2021/5/21
 * https://github.com/OHSY247/BotApi/issues/3
 * 命运2数据拉取更新sqlite数据文件
 * 参考文章
 * https://www.cnblogs.com/wupeixuan/p/11689580.html
 */
@Component
public class DataHandler {
    /**
     * fixedRate 是 long 类型，表示任务执行的间隔毫秒数，以上代码中的定时任务每 3 秒执行一次。
     * @Scheduled(fixedRate = 3000)
     * public void scheduledTask() {
     *     System.out.println("任务执行时间：" + LocalDateTime.now());
     * }
     * */

    public static void test() {
        System.out.println("任务执行时间：" + LocalDateTime.now());
        AuthoritativeApi authoritativeApi=new AuthoritativeApi();
        System.out.println(authoritativeApi.getMANIFESTContent());
    }
    /**
     * 每天凌晨一点十五开始执行
     * - 每天凌晨一点十五尝试刷新数据库，保持每天的
     */
    @Scheduled(cron="0 15 1 * * ?")
    public void dailyRefresh() {
        System.out.println("任务执行时间：" + LocalDateTime.now());
    }

    /**
     * - 每周三凌晨一点十五开始刷新数据库
     */
    @Scheduled(cron="0 15 1 ? * WED")
    public void weeklyRefresh() {
        System.out.println("任务执行时间：" + LocalDateTime.now());
    }
}
