package github.botapi.destiny2.handler;

import github.botapi.util.handler.BackEndHttpRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;

/**
 * @author straycamel
 * @date 2021/5/21
 * https://github.com/OHSY247/BotApi/issues/3
 * 拉取更新sqlite数据文件
 * 参考文章
 */
@Component
public class DataHandler extends BackEndHttpRequest {
    public static String DOWNLOAD_MANIFEST_DIR = System.getProperty("user.dir")+"/data/downloadManifest";
    public static String DATA_MANIFEST_DIR = System.getProperty("user.dir")+"/data/destiny2Manifest";
    public static AuthoritativeApi authApi=new AuthoritativeApi();
    public static String DEFAULT_LANGUAGE = "zh-chs";
    /**
     * fixedRate 是 long 类型，表示任务执行的间隔毫秒数，以上代码中的定时任务每 3 秒执行一次。
     * @Scheduled(fixedRate = 3000)
     * public void scheduledTask() {
     *     System.out.println("任务执行时间：" + LocalDateTime.now());
     * }
     * */
    public static void test() {
        System.out.println("任务执行时间：" + LocalDateTime.now());
        dailyRefresh();
    }


    /**
     * 每天凌晨一点十五开始执行
     * - 每天凌晨一点十五尝试刷新数据库，保持每天的
     */
    @Scheduled(cron="0 15 1 * * ?")
    public static void dailyRefresh() {
        System.out.println("日任务-任务执行时间：" + LocalDateTime.now());
        checkManifest();
        // todo 代码检查，authApi对象的属性会被销毁吗，这里可能是个坑/bug
        System.out.println("代码检查，authApi对象的属性会被销毁吗，"+authApi.Version);
    }
    /**
     * 检查manifest数据
     * 若数据需要更新，删除DOWNLOAD_MANIFEST_DIR/DATA_MANIFEST_DIR
     */
    public static void checkManifest(){
        Map<String,String> content = authApi.getLastManifestContent();
        if (content==null){
            return;
        } else {
            /*FileHandler.clearDir(new File(DOWNLOAD_MANIFEST_DIR));
            FileHandler.clearDir(new File(DATA_MANIFEST_DIR));*/
            System.out.println("Manifest文件夹清空-数据进行重新下载；version："+authApi.Version);
            Iterator<Map.Entry<String,String>> iterator = content.entrySet().iterator();
            if (iterator !=null){
                // todo: 并行多线程执行
                while (iterator.hasNext()) {
                    Map.Entry<String, String> tmp = iterator.next();
                    authApi.downloadManifest(authApi.ROOT+tmp.getValue(),DOWNLOAD_MANIFEST_DIR+SEPARATOR+tmp.getKey(),DATA_MANIFEST_DIR+SEPARATOR+tmp.getKey());
                }
            }
        }
    }

    /**
     * - 每周三凌晨一点十五开始刷新数据库
     */
    @Scheduled(cron="0 15 1 ? * WED")
    public static void weeklyRefresh() {
        System.out.println("周任务-任务执行时间：" + LocalDateTime.now());
    }
}
