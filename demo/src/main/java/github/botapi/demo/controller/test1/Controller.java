package github.botapi.demo.controller.test1;

import github.botapi.demo.model.DemoDO;
import github.botapi.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author straycamel
 * @date 2021/5/28
 */
@RestController
@RequestMapping("/demo")
public class Controller {
    private DemoService demoService;
    @Autowired
    public Controller(DemoService demoService2){
        demoService = demoService2;
    }
    @GetMapping("/test")
    public List<DemoDO> test1(){

        return demoService.selectAll();
    }
}