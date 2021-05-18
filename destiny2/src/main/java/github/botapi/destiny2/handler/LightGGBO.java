package github.botapi.destiny2.handler;

import github.botapi.util.handler.WebScreenshotBO;

import java.io.File;
import java.io.IOException;

/**
 * @author straycamel
 * @date 2021/5/18
 */
public class LightGGBO {
    private static final String LIGHT_GG_URL = "https://www.baidu.com/";
    public static String ROOT_STOCK_TMP_IMG_PATH = "/tmp/";
    private static final String TMP_STOCK_IMG_PATH =new File(System.getProperty("user.dir"), ROOT_STOCK_TMP_IMG_PATH).toString();;
    /**
     * 生成图片
     * */
    public static String generateImgPath(String item){
        WebScreenshotBO webScreenshotBO = new WebScreenshotBO();
        String imgPath = new File(TMP_STOCK_IMG_PATH, item+".png").toString();
        try {
            webScreenshotBO.generateImgPath(LIGHT_GG_URL,imgPath);
            return imgPath;
        } catch (IOException e) {
            e.printStackTrace();
            return "图片生成失败";
        }
    }
}
