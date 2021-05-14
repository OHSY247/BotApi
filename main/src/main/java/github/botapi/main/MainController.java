package github.botapi.main;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author straycamel
 */
@RestController
@RequestMapping("/")
class MainController {
    @RequestMapping("start")
    public String showAll(){
        return "start success";
    }
}
