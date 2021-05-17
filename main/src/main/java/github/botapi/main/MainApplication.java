package github.botapi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author straycamel
 * 扫描单个子模块控制器：@SpringBootApplication(scanBasePackages = {"github.botapi.destiny2"})
 * 扫描父包下所有的控制器：@ComponentScan({"github.botapi"})
 */
@ComponentScan({"github.botapi"})
@SpringBootApplication
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
