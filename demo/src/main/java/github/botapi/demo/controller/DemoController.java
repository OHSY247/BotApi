package github.botapi.demo.controller;

import github.botapi.demo.model.DemoDO;
import github.botapi.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final DemoService service;

    @Autowired
    public DemoController(DemoService service) {
        this.service = service;
        System.out.println("demo starting");
    }


    /**
     * 接口测试
     *
     * @return JSON 字符串
     * @ResponseBody 如果返回的是对象 会自动转为json字符串，如果返回的是String 则返回该字符串
     */
    @GetMapping("/demos")
    @ResponseBody
    public List<DemoDO> allDemo() {
        return service.selectAll();
    }

    @RequestMapping("/start")
    public String showAll() {
        return "start success";
    }
}