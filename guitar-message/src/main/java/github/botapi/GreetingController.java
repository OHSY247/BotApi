package github.botapi;

import org.springframework.stereotype.Controller;

/**
 * @author 317292
 * @date 2024/7/2
 */
@Controller //使用Controller注解来标识这是一个控制器类
public class GreetingController {

    @MessageMapping("/hello") //使用MessageMapping注解来标识所有发送到“/hello”这个destination的消息，都会被路由到这个方法进行处理.
    @SendTo("/topic/greetings") //使用SendTo注解来标识这个方法返回的结果，都会被发送到它指定的destination，“/topic/greetings”.
    //传入的参数HelloMessage为客户端发送过来的消息，是自动绑定的。
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // 模拟处理延时
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!"); //根据传入的信息，返回一个欢迎消息.
    }

}
