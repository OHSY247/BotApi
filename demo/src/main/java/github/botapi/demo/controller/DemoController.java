package github.botapi.demo.controller;

import github.botapi.demo.model.DemoModel;
import github.botapi.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DemoController {

    private final DemoService service;

    @Autowired
    public DemoController(DemoService service) {
        this.service = service;
    }


    /**
     * 接口测试
     * @return JSON 字符串
     */
    @GetMapping("/demos")
    @ResponseBody
    public List<DemoModel> allDemo() {
        return service.selectAll();
    }
    // @ResponseBody 如果返回的是对象 会自动转为json字符串，如果返回的是String 则返回该字符串
}