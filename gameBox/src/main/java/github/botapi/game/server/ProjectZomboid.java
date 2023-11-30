package github.botapi.game.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 云服务器SDK：https://next.api.aliyun.com/api-tools/sdk/Ecs?version=2014-05-26&language=java-tea
 *
 * @author straycamel
 * @date 2023/11/30
 */
@Slf4j
@Component
public class ProjectZomboid {
    /**
     * 查询服务器列表
     */
    void listServer() {

    }

    /**
     * 查询服务器信息
     */
    void getServerInfo() {

    }

    /**
     * 开启服务器
     * 开机实例、启动服务器
     */
    void startServer() {

    }

    /**
     * 暂时关闭服务器
     * 指：进入省钱关机模式
     */
    void pauseServer() {

    }

    /**
     * 定时扫描-每半个小时查询ProjectZomboid Server状态
     * 每N毫秒执行一次，通过端口、日志打印状态判断server活跃状态
     * 若不活跃，触发服务器暂停
     */
    @Scheduled(fixedDelay = 1000 * 60 * 30L)
    void ServerActivityScan() {
        log.info("ServerActivityScan test");
    }
}
