package github.botapi.util.handler;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
 */
public class SeleniumBO {
    private final String systemName;
    private final String systemArch;
    private final String systemVersion;
    /**
     * 脚本执行程序 静态目录
     * 默认使用chromedriver
     * */
    public static String CHROMEDRIVER = "chromedriver";
    public static String ROOT_STOCK_PATH = "util/src/main/java/github/botapi/util/app/selenium";
    public static String FILE_PATH = new File(System.getProperty("user.dir"), ROOT_STOCK_PATH).toString();

    private final ChromeDriver chromeDriver;

    @Override
    public String toString() {
        return "SeleniumBO{" +
                "systemName='" + systemName + '\'' +
                ", systemArch='" + systemArch + '\'' +
                ", systemVersion='" + systemVersion + '\'' +
                '}';
    }
    /**
     * 实例化对象
     * 声明驱动和chrome应用
     * */
    public SeleniumBO(){
        try{
            System.setProperty("webdriver.chrome.driver", "/Users/straycamel/alibaba-inc/idea-workspace/BotApi/util/src/main/java/github/botapi/util/app/selenium/chromedriver");
        } catch (Exception e) {
            // todo 若未发现驱动可以组织实例化这个对象吗
            e.printStackTrace();
        }
        Properties props = System.getProperties();
        this.systemName = props.getProperty("os.name");
        this.systemArch = props.getProperty("os.arch");
        this.systemVersion = props.getProperty("os.version");

        this.chromeDriver = new ChromeDriver();
    }
    /**
     * 解析URL 进行截图并保存到自动生成的文件路径
     * */
    public String generateScreenshotPath(String url){
        /**
         * todo 通过一定默认规则解析url 确定保存图片的url 默认规则未确定
         *
         * */
        String pathname = "test";
        return generateScreenshotPath(url,pathname);
    }
    /**
     * 解析URL 进行截图并保存到文件路径
     * todo 超时锁
     * todo 截取长屏-现在只能截取一个窗口的大小，无法像手机一样滑动截取
     * */
    public String generateScreenshotPath(String url, String pathname){

        try {
			chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			chromeDriver.manage().window().maximize();
            chromeDriver.get(url);
            //等待页面加载完成
			new WebDriverWait(chromeDriver, 300).until(chromeDriver -> ((JavascriptExecutor) chromeDriver)
					.executeScript("return document.readyState").equals("complete"));
			JavascriptExecutor jexec = (JavascriptExecutor) chromeDriver;
			int width =((Long)  jexec.executeScript("return document.body.scrollWidth")).intValue();
			int height = ((Long) jexec.executeScript("return document.body.scrollHeight")).intValue();
            System.out.printf("[%d %d]\n", width, height);
            //设置浏览窗口大小
			chromeDriver.manage().window().setSize(new Dimension(width, height));
			Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(chromeDriver);
			BufferedImage image = screenshot.getImage();
            try {
                ImageIO.write(image, "PNG", new File(pathname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*File srcFile = ((TakesScreenshot)chromeDriver).getScreenshotAs(OutputType.FILE);
            //通过FileUtils中的copyFile()方法保存getScreenshotAs()返回的文件;"屏幕截图"即时保存截图的文件夹
            try {
                Files.copy(srcFile, new File(pathname));
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        } finally {
            chromeDriver.quit();
        }
        return pathname;
    }

    public WebDriver fetchChromeDriver(){
        return chromeDriver;
    }

    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println(this.toString() + "now finalize:" + System.currentTimeMillis());
        chromeDriver.quit();
   }
}
