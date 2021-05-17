package github.botapi.destiny2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author straycamel
 */
@RestController
@RequestMapping("/Destiny2")
public class Destiny2Controller {
    /**
     * 测试接口
     * @author
     * @date
     */
    @RequestMapping("/test")
    public String test(){
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
     */
    @RequestMapping("/lightGGItem")
    public String lightGG(){ return "destiny2 lightGG test";}
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

