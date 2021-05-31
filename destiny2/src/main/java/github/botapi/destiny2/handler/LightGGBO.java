package github.botapi.destiny2.handler;

import java.io.File;

/**
 * @author straycamel
 * @date 2021/5/18
 */
public class LightGGBO {
    protected static final String LIGHT_GG_BASE_URL = "https://www.light.gg";
    protected static final String LIGHT_GG_ZH_CHT_DB_URL = LIGHT_GG_BASE_URL+"/db/zh-cht/items";
    public static String ROOT_STOCK_TMP_IMG_PATH = "/tmp/";
    private static final String TMP_STOCK_IMG_PATH =new File(System.getProperty("user.dir"), ROOT_STOCK_TMP_IMG_PATH).toString();
    /**
     * 生成图片
     * 以下为调用WebScreenshotBO的demo代码
     * https://github.com/OHSY247/BotApi/issues/5 网页截图使用 puppeteer 采用node建立一个单独的服务器开放接口-提供调用
     * String lightGGUrl = String.format(LIGHT_GG_ZH_CHT_DB_URL+"/%02d",itemID);
        WebScreenshotBO webScreenshotBO = new WebScreenshotBO();
        String fileStockPath = new File(TMP_STOCK_IMG_PATH,String.format("%s.png",itemID)).toString();
        JsHandler.handler();
     * */
    public static String generateImgPathByUrl(long itemID){
        return "tmp/tmp.jpg";
    }
}
