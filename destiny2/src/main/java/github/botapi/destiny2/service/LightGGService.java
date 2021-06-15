package github.botapi.destiny2.service;

/**
 * @author straycamel
 * @date 2021/6/9
 */
public interface LightGGService {
    /**
     * 生成图片
     * 以下为调用WebScreenshotBO的demo代码
     * https://github.com/OHSY247/BotApi/issues/5 网页截图使用 puppeteer 采用node建立一个单独的服务器开放接口-提供调用
     * String lightGGUrl = String.format(LIGHT_GG_ZH_CHT_DB_URL+"/%02d",itemID);
     * WebScreenshotBO webScreenshotBO = new WebScreenshotBO();
     * String fileStockPath = new File(TMP_STOCK_IMG_PATH,String.format("%s.png",itemID)).toString();
     * JsHandler.handler();
     */
    String generateImgPathByUrl(long itemID);
}
