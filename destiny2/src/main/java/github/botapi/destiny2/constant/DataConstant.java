package github.botapi.destiny2.constant;

/**
 * @author straycamel
 * @date 2021/6/8
 */
public class DataConstant {
    /**
     * @author straycamel
     * @date 2021/6/8
     * manifest数据下载存放目录
     */
    public static String DOWNLOAD_MANIFEST_DIR = System.getProperty("user.dir") + "/data/downloadManifest";

    /**
     * @author straycamel
     * @date 2021/6/8
     * manifest数据下载后解压的sqlite数据源存放目录
     */
    public static String DATA_MANIFEST_DIR = System.getProperty("user.dir") + "/data/destiny2Manifest";

    public static String DEFAULT_LANGUAGE = "zh-chs";
    /**
     * @author straycamel
     * @date 2021/6/8
     * 文件目录分隔符
     */
    public static String SEPARATOR = "/";
}
