package github.botapi.util.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.function.Function;

/**
 * @author straycamel
 * @date 2021/5/18
 * phantomjs脚本下载页 https://phantomjs.org/download.html
 * https://github.com/OHSY247/BotApi/issues/5
 * 已弃用
 */
public class PhantomjsBO {
    /**
     * 脚本执行程序 静态目录
     */
    public static String APP_NAME = "phantomjs";
    public static String ROOT_STOCK_PATH = "util/src/main/java/github/botapi/util/app/phantomjs";
    public static String FILE_PATH = new File(System.getProperty("user.dir"), ROOT_STOCK_PATH).toString();
    private String systemName, systemArch, systemVersion;

    public PhantomjsBO() {
        Properties props = System.getProperties();
        this.systemName = props.getProperty("os.name");
        this.systemArch = props.getProperty("os.arch");
        this.systemVersion = props.getProperty("os.version");
    }

    @Override
    public String toString() {
        return "PhantomjsBO{" +
                "systemName='" + systemName + '\'' +
                ", systemArch='" + systemArch + '\'' +
                ", systemVersion='" + systemVersion + '\'' +
                '}';
    }

    /**
     * phantomjs 文件、版本、系统名过滤函数
     * 之前将所有平台的所有版本多下载到项目中-所以做了过滤函数-但是将所有函数下载到项目太占用.git空间了，随之放弃
     */
    @Deprecated
    public Boolean autoPathFilter(String path) {
        String subPath = path.replace(FILE_PATH, "");
        String[] subPaths = subPath.split("_");
        // 基础校验
        if (subPath == "") {
            return false;
        }
        // 名称应用校验
        int appNameCheckFlag = 0;
        if (!subPaths[appNameCheckFlag].contains(APP_NAME)) {
            return false;
        }
        // 系统名称校验
        int systemNameCheckFlag = 1;
        if (!this.systemName.toLowerCase().contains(subPaths[systemNameCheckFlag])) {
            return false;
        }
        // 系统位号arch校验-只要有一个符合即为正确
        int systemVersionCheckFlag = 2;
        for (String x : Arrays.copyOfRange(subPaths, systemVersionCheckFlag, subPaths.length)) {
            if (this.systemArch.toLowerCase().contains(x)) {
                System.out.println(subPath);
                return true;
            }
        }
        return false;
    }

    /**
     * 简化版:文件过滤器
     */
    public Boolean pathFilter(String path) {
        String subPath = path.replace(FILE_PATH, "");
        String[] subPaths = subPath.split("_");
        // 基础校验
        if (subPath == "") {
            return false;
        }
        // 名称应用校验
        int appNameCheckFlag = 0;
        if (!subPaths[appNameCheckFlag].contains(APP_NAME)) {
            return false;
        }
        return true;
    }

    /**
     * 识别系统型号，爬取Phatomjs下载页对应的url，并进行下载保存文件到tmp文件夹
     */
    public String fetchPath() {
        /**
         * 获取所有app应用程序文件夹下所有文件
         * todo 这里代码能作优化吗
         * */
        Function<String, Boolean> filter = path -> pathFilter(path);
        /**
         * 对文件进行过滤
         * */
        ArrayList<String> appPaths = DirHandler.getRecurseFiles(FILE_PATH, filter);

        try {
            System.out.println(appPaths.get(0));
            return appPaths.get(0);
        } catch (Exception e) {
            System.out.println("请查阅：/util/src/main/java/github/botapi/util/app/phantomjs/readme.md");
            e.printStackTrace();

        }
        return "";
    }
}
