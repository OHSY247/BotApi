package github.botapi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author straycamel
 * 扫描单个子模块控制器：@SpringBootApplication(scanBasePackages = {"github.botapi.destiny2"})
 * 扫描父包下所有的控制器：@ComponentScan({"github.botapi"})
 * 开启定时任务：@EnableScheduling
 * 定时任务类通过 Spring IOC 加载，使用 @Component 注解，定时方法使用 @Scheduled 注解。
 */

@SpringBootApplication(scanBasePackages = {"github.botapi"})
@EnableScheduling
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
