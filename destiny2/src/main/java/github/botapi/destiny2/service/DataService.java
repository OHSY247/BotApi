package github.botapi.destiny2.service;

/**
 * @author straycamel
 * @date 2021/6/8
 */
public interface DataService {

    /**
     * fixedRate 是 long 类型，表示任务执行的间隔毫秒数，以上代码中的定时任务每 3 秒执行一次。
     *
     * @Scheduled(fixedRate = 3000)
     * public void scheduledTask() {
     * System.out.println("任务执行时间：" + LocalDateTime.now());
     * }
     * 每天凌晨一点十五开始执行
     * - 每天凌晨一点十五尝试刷新数据库，保持每天的
     */
    void dailyRefresh();

    /**
     * 检查manifest数据
     * 若数据需要更新，删除DOWNLOAD_MANIFEST_DIR/DATA_MANIFEST_DIR
     */
    void checkManifest();

    /**
     * - 每周三凌晨一点十五开始刷新数据库
     */
    void weeklyRefresh();
}
