package github.botapi.game.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author straycamel
 * @date 2021/5/27
 */
@Slf4j
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

    public static void main(String[] args) {

    }
    private static void testhandler(Integer... a){
        System.out.println(a);
    }
}

