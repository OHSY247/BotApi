package github.botapi.util.handler;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author straycamel
 * @date 2021/5/18
 * Selenium 模拟浏览器
 * https://github.com/OHSY247/BotApi/issues/5
 * 已弃用
 */
public class SeleniumBO {
    /**
     * 脚本执行程序 静态目录
     * 默认使用chromedriver
     */
    public static String CHROMEDRIVER = "chromedriver";
    public static String ROOT_STOCK_PATH = "util/src/main/java/github/botapi/util/app/selenium";
    public static String FILE_PATH = new File(System.getProperty("user.dir"), ROOT_STOCK_PATH).toString();
    private final String systemName;
    private final String systemArch;
    private final String systemVersion;
    private final ChromeOptions options;
    private final ChromeDriver chromeDriver;

    /**
     * 实例化对象
     * 声明驱动和chrome应用
     */
    public SeleniumBO() {
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/straycamel/alibaba-inc/idea-workspace/BotApi/util/src/main/java/github/botapi/util/app/selenium/chromedriver");
        } catch (Exception e) {
            // todo 若未发现驱动可以组织实例化这个对象吗
            e.printStackTrace();
        }
        Properties props = System.getProperties();
        this.systemName = props.getProperty("os.name");
        this.systemArch = props.getProperty("os.arch");
        this.systemVersion = props.getProperty("os.version");
        this.options = new ChromeOptions();
        // 添加UA
        options.addArguments("user-agent='MQQBrowser/26 Mozilla/5.0 (Linux; U; Android 2.3.7; zh-cn; MB200 Build/GRJ22; CyanogenMod-7) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1'");

        // 指定浏览器分辨率
        //options.addArguments("window-size=1920x3000");

        // 谷歌文档提到需要加上这个属性来规避bug
        //options.addArguments("--disable-gpu");

        // 隐藏滚动条, 应对一些特殊页面
        //options.addArguments("--hide-scrollbars");

        // 不加载图片, 提升速度
        //options.addArguments("blink-settings=imagesEnabled=false");

        // 浏览器不提供可视化页面. linux下如果系统不支持可视化不加这条会启动失败
        //options.addArguments("--headless");
        //options.addArguments("headless=true");
        options.addArguments("--disable-web-security");

        // 以最高权限运行
        options.addArguments("--no-sandbox");

        /*// 手动指定使用的浏览器位置
        options.binary_location = r"C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"

        #添加crx插件
        options.add_extension("d:\crx\AdBlock_v2.17.crx")

        // 禁用JavaScript
        options.addArguments("--disable-javascript")

        // 设置开发者模式启动，该模式下webdriver属性为正常值
        options.add_experimental_options("excludeSwitches', ['enable-automation'])

        // 禁用浏览器弹窗
        prefs = {
            'profile.default_content_setting_values' :  {
                'notifications' : 2
             }
        options.add_experimental_options("prefs',prefs)

                }  */

        this.chromeDriver = new ChromeDriver(this.options);
    }

    @Override
    public String toString() {
        return "SeleniumBO{" +
                "systemName='" + systemName + '\'' +
                ", systemArch='" + systemArch + '\'' +
                ", systemVersion='" + systemVersion + '\'' +
                '}';
    }

    /**
     * 解析URL 进行截图并保存到自动生成的文件路径
     */
    public String generateScreenshotPath(String url) {
        /**
         * todo 通过一定默认规则解析url 确定保存图片的url 默认规则未确定
         *
         * */
        String pathname = "test";
        return generateScreenshotPath(url, pathname);
    }

    /**
     * 解析URL 进行截图并保存到文件路径
     * todo 超时锁
     * todo 截取长屏-现在只能截取一个窗口的大小，无法像手机一样滑动截取
     */
    public String generateScreenshotPath(String url, String pathname) {

        try {
            chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            chromeDriver.manage().window().maximize();
            chromeDriver.get(url);
            //等待页面加载完成
            new WebDriverWait(chromeDriver, 300).until(chromeDriver -> "complete".equals(((JavascriptExecutor) chromeDriver).executeScript("return document.readyState")));
            JavascriptExecutor jexec = (JavascriptExecutor) chromeDriver;
            int width = ((Long) jexec.executeScript("return document.body.scrollWidth")).intValue();
            int height = ((Long) jexec.executeScript("return document.body.scrollHeight")).intValue();
            System.out.printf("网页窗口最大尺寸[%d*%d]\n", width, height);
            //设置浏览窗口大小
            chromeDriver.manage().window().setSize(new Dimension(width, height));
            Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(chromeDriver);
            BufferedImage image = screenshot.getImage();
            try {
                ImageIO.write(image, "PNG", new File(pathname));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            chromeDriver.quit();
        }
        return pathname;
    }

    public WebDriver getDriver() {
        return chromeDriver;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(this.toString() + "now finalize:" + System.currentTimeMillis());
        chromeDriver.quit();
    }
}
