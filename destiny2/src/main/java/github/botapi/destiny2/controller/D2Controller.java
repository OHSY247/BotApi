package github.botapi.destiny2.controller;

import github.botapi.destiny2.dto.d2api.playerInfo.SearchDestinyPlayerDTO;
import github.botapi.destiny2.dto.botapi.playerInfo.InfoDTO;
import github.botapi.destiny2.model.DestinySeasonDefinitionDO;
import github.botapi.destiny2.service.*;
import github.botapi.util.dto.response.SuccessResponseDTO;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author straycamel
 */
@RestController
@RequestMapping("/Destiny2")
public class D2Controller {
    @Autowired
    private ZhChsService zhChsService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private DataService dataService;
    @Autowired
    private LightGGService lightGGService;
    @Autowired
    private D2ApiService d2ApiService;
    @Autowired
    private PlayerInfoService playInfoService;
    private String DEFAULT_IMG = "tmp/tmp.jpg";

    public D2Controller() {
        System.out.println("每次启动时-进行所有的数据更新-可能耗时有点久，但是数据为项目所需");
        /*Thread t = new Thread(() -> {
            System.out.println("start new thread!");
            start();
        });
        t.start();*/
    }

    /**
     * 查询物品返回lightgg网站截图
     *
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/item", produces = MediaType.IMAGE_JPEG_VALUE, params = {"name", "type"})
    @ResponseBody
    public ResponseEntity<byte[]> getItemByName2(@RequestParam("name") String name, @RequestParam("type") String type) throws IOException {
        // 读取磁盘本地图片
        File file = new File(itemService.screenshotLightGG(name));
        InputStream in = new FileInputStream(file);
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers,
                    HttpStatus.OK);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }

    /**
     * @return JSON 字符串
     * @ResponseBody 如果返回的是对象 会自动转为json字符串，如果返回的是String 则返回该字符串
     */
    @GetMapping(value = "/item", produces = MediaType.APPLICATION_JSON_VALUE, params = {"name"})
    @ResponseBody
    public long getItemByName(@RequestParam("name") String name) {
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
    public void start() {
        dataService.dailyRefresh();
        dataService.weeklyRefresh();
    }

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

    /**
     * xiu 位置信息
     *
     * @author
     * @date
     */
    @RequestMapping("/xiu")
    public String xiu() {
        return "destiny2 xiu";
    }

    /**
     * 周报 图片生成
     *
     * @author
     * @date
     */
    @RequestMapping("/weekly")
    public String weekly() {
        return "destiny2 weekly";
    }

    /**
     * 日报 图片生成
     *
     * @author
     * @date
     */
    @RequestMapping("/daily")
    public String daily() {
        return "destiny2 daily";
    }

    /**
     * 光尘 赛季光尘图片生成
     *
     * @author
     * @date
     */
    @RequestMapping("/lightDust")
    public String lightDust() {
        return "destiny2 lightDust";
    }

    /**
     * LightGG 物品名查询并生成截图
     *
     * @author
     * @date
     * @params item 支持对itemId和itemName匹配查询
     */
    @RequestMapping("/lightGGItem")
    public String lightGG(long item) {
        return lightGGService.generateImgPathByUrl(item);
    }

    /**
     * LightGG 查询物故事/npc等文本介绍信息
     *
     * @author
     * @date
     */
    @RequestMapping("/itemInfo")
    public String itemInfo() {
        return "destiny2 itemInfo test";
    }

    /**
     * 玩家角色信息查新
     *
     * @author
     * @date
     * @params id 用户的steam id 不只是steam id，其他的id种类也进行支持
     * @params nickname 用户昵称
     * @params platformType 平台种类 通过没举止区分，默认全部
     * @params type {all, pvp, pve, raid...} 通过枚举值查询不同给的信息
     */
    @RequestMapping("/playerInfo")
    public Object userInfo(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "platformType", required = false) String platformType,
            @RequestParam(value = "platform", required = false) String platform,
            @RequestParam(value = "steamID", required = false) Long steamID
    ) {
        if (steamID != null) {
            SearchDestinyPlayerDTO res = d2ApiService.SearchDestinyPlayer(steamID);
            return new SuccessResponseDTO<>("destiny2 userInfo test", res);
        }
        InfoDTO res = playInfoService.getPlayerInfo("娃哈哈店长");
        return new SuccessResponseDTO("destiny2 userInfo test", res);
    }
}

