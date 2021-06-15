package github.botapi.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author straycamel
 * @date 2021/5/27
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 测试接口
     *
     * @author
     * @date
     */
    @RequestMapping("/test")
    public String test() {
        return "destiny2 test";
    }

}

