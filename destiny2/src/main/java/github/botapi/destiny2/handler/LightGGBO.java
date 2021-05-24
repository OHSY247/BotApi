package github.botapi.destiny2.handler;

import github.botapi.util.handler.WebScreenshotBO;

import java.io.File;
import java.io.IOException;

/**
 * @author straycamel
 * @date 2021/5/18
 */
public class LightGGBO {
    private static final String LIGHT_GG_BASE_URL = "https://www.light.gg";
    public static String ROOT_STOCK_TMP_IMG_PATH = "/tmp/";
    private static final String TMP_STOCK_IMG_PATH =new File(System.getProperty("user.dir"), ROOT_STOCK_TMP_IMG_PATH).toString();;
    /**
     * 生成图片
     * 以下为调用WebScreenshotBO的demo代码
     * public static String generateImgPath(String item){
     *     WebScreenshotBO webScreenshotBO = new WebScreenshotBO();
     *     String imgPath = new File(TMP_STOCK_IMG_PATH, item+".png").toString();
     *     try {
     *     webScreenshotBO.generateImgPath(LIGHT_GG_BASE_URL,imgPath);
     *     return imgPath;
     *     } catch (IOException e) {
     *     e.printStackTrace();
     *     return "图片生成失败";
     * }
     * */
    public static String generateImgPath(String item){
        WebScreenshotBO webScreenshotBO = new WebScreenshotBO();
        try {
            webScreenshotBO.generateImgPath(LIGHT_GG_BASE_URL,"/Users/straycamel/alibaba-inc/idea-workspace/BotApi/tmp/test.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //SeleniumBO seleniumBO = new SeleniumBO();
        //seleniumBO.generateScreenshotPath(LIGHT_GG_BASE_URL,"/Users/straycamel/alibaba-inc/idea-workspace/BotApi/tmp/test.png");
        return "xx";
    }
}
