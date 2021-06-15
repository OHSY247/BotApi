package github.botapi.destiny2.constant;

import java.io.File;

/**
 * @author straycamel
 * @date 2021/6/9
 */
public class LightGGConstant {
    protected static final String LIGHT_GG_BASE_URL = "https://www.light.gg";
    protected static final String LIGHT_GG_ZH_CHT_DB_URL = LIGHT_GG_BASE_URL + "/db/zh-cht/items";
    public static String ROOT_STOCK_TMP_IMG_PATH = "/tmp/";
    private static final String TMP_STOCK_IMG_PATH = new File(System.getProperty("user.dir"), ROOT_STOCK_TMP_IMG_PATH).toString();
}
