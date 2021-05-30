package github.botapi.destiny2.controller;

import github.botapi.destiny2.handler.DataHandler;
import github.botapi.destiny2.handler.LightGGBO;
import github.botapi.destiny2.model.DestinySeasonDefinitionDO;
import github.botapi.destiny2.service.ItemService;
import github.botapi.destiny2.service.ZhChsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author straycamel
 */
@RestController
@RequestMapping("/Destiny2")
public class Destiny2Controller {

    private ZhChsService zhChsService;

    private ItemService itemService;

    public Destiny2Controller(){
        System.out.println("每次启动时-进行所有的数据更新-可能耗时有点久，但是数据为项目所需");
        Thread t = new Thread(() -> {
            System.out.println("start new thread!");
            start();
        });
        t.start();
    }
    @Autowired
    public Destiny2Controller(ZhChsService zhChsService,ItemService itemService) {
        this.zhChsService = zhChsService;
        this.itemService = itemService;
    }

    /**
     * @return JSON 字符串
     * @ResponseBody 如果返回的是对象 会自动转为json字符串，如果返回的是String 则返回该字符串
     */
    @GetMapping("/item")
    @ResponseBody
    public long getIdByName(@RequestParam("name") String name) {
        return itemService.selectIdByName(name);
    }
    /**
     * @return JSON 字符串
     * @ResponseBody 如果返回的是对象 会自动转为json字符串，如果返回的是String 则返回该字符串
     */
    @GetMapping("/seasons")
    @ResponseBody
    public List<DestinySeasonDefinitionDO> allDemo() {
        return zhChsService.selectAll();
    }

    /**
     * 启动模块所需要加载的方法
     */
    public void start(){
        DataHandler.dailyRefresh();
        DataHandler.weeklyRefresh();
    }
    /**
     * 测试接口
     * @author
     * @date
     */
    @RequestMapping("/test")
    public String test(){
        DataHandler.test();
        return "destiny2 test";
    }
    /**
     * xiu 位置信息
     * @author
     * @date
     */
    @RequestMapping("/xiu")
    public String xiu(){
        return "destiny2 xiu";
    }
    /**
     * 周报 图片生成
     * @author
     * @date
     */
    @RequestMapping("/weekly")
    public String weekly(){
        return "destiny2 weekly";
    }
    /**
     * 日报 图片生成
     * @author
     * @date
     */
    @RequestMapping("/daily")
    public String daily(){
        //System.out.println(1/0);
        return "destiny2 daily";
    }
    /**
     * 光尘 赛季光尘图片生成
     * @author
     * @date
     */
    @RequestMapping("/lightDust")
    public String lightDust(){
        return "destiny2 lightDust";
    }
    /**
     * LightGG 物品名查询并生成截图
     * @author
     * @date
     * @params item 支持对itemId和itemName匹配查询
     */
    @RequestMapping("/lightGGItem")
    public String lightGG(String item){
        return LightGGBO.generateImgPath(item);
    }
    /**
     * LightGG 查询物故事/npc等文本介绍信息
     * @author
     * @date
     */
    @RequestMapping("/itemInfo")
    public String itemInfo(){ return "destiny2 itemInfo test";}
    /**
     * 玩家角色信息查新
     * @author
     * @date
     * @params id 用户的steam id 不只是steam id，其他的id种类也进行支持
     * @params nickname 用户昵称
     * @params platformType 平台种类 通过没举止区分，默认全部
     * @params type {all, pvp, pve, raid...} 通过枚举值查询不同给的信息
     */
    @RequestMapping("/userInfo")
    public String userInfo(){ return "destiny2 userInfo test";}
}

