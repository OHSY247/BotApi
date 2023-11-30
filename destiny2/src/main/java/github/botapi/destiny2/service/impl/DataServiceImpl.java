package github.botapi.destiny2.service.impl;

import github.botapi.destiny2.constant.D2ApiConstant;
import github.botapi.destiny2.service.D2ApiService;
import github.botapi.destiny2.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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
@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private D2ApiService d2ApiService;

    @Override
    @Scheduled(cron = "0 15 1 * * ?")
    public void dailyRefresh() {
        System.out.println("日任务-任务执行时间：" + LocalDateTime.now());
        checkManifest();
        // todo 代码检查，auApi对象的属性会被销毁吗，这里可能是个坑/bug
        System.out.println("代码检查，auApi对象的属性会被销毁吗，" + System.getenv(D2ApiConstant.VERSION_FLAG));
    }

    @Override
    public void checkManifest() {
        Map<String, String> content = d2ApiService.getLastManifestContent();
        if (content == null) {
            return;
        } else {
            /*FileHandler.clearDir(new File(DOWNLOAD_MANIFEST_DIR));
            FileHandler.clearDir(new File(DATA_MANIFEST_DIR));*/
            System.out.println("Manifest文件夹清空-数据进行重新下载；version：" + System.getenv(D2ApiConstant.VERSION_FLAG));
            Iterator<Map.Entry<String, String>> iterator = content.entrySet().iterator();
//            if (iterator != null) {
//                // todo: 并行多线程执行
//                while (iterator.hasNext()) {
//                    Map.Entry<String, String> tmp = iterator.next();
//                    d2ApiService.downloadManifest(D2ApiConstant.ROOT + tmp.getValue(), DataConstant.DOWNLOAD_MANIFEST_DIR + DataConstant.SEPARATOR + tmp.getKey(), DataConstant.DATA_MANIFEST_DIR + DataConstant.SEPARATOR + tmp.getKey());
//                }
//            }
        }
    }

    @Override
    @Scheduled(cron = "0 15 1 ? * WED")
    public void weeklyRefresh() {
        System.out.println("周任务-任务执行时间：" + LocalDateTime.now());
    }
}
