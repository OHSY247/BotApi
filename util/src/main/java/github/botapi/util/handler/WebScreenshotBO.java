package github.botapi.util.handler;

import java.io.*;

/**
 * @author straycamel
 * @date 2021/5/18
 * https://github.com/OHSY247/BotApi/issues/5
 * 已弃用
 * take streenshot of web page
 * java没有太好的网页截图工具，我们这里使用js编写，并用java调用js脚本进行截图并生成图片，返回图片url
 */
public class WebScreenshotBO {
    public static String ROOT_STOCK_WEB_SCREENSHOT_JS = "util/src/main/java/github/botapi/util/js/WebScreenshot.js";

    private final String WEB_SCREENSHOT_JS = new File(System.getProperty("user.dir"), ROOT_STOCK_WEB_SCREENSHOT_JS).toString();

    public WebScreenshotBO() {
    }

    /**
     * 使用 phantomjs 通过url生成图片并保存到本地resImgPath
     *
     * @params url 需要截图的url
     * @params resImgPath 截图后保存的体制
     */
    public String generateImgPathByUrl(String url, String resImgPath) throws IOException {
        PhantomjsBO phantomjsBO = new PhantomjsBO();
        String phantomjsApp = phantomjsBO.fetchPath();
        // 使用Runtime类执行终端命令
        String blank = "  ";
        try {
            System.out.println(String.format("phantomjs对网页:%s进行截图ing...", url));
            Process process = Runtime.getRuntime().exec(phantomjsApp + blank
                    + WEB_SCREENSHOT_JS + blank
                    + url + blank
                    + resImgPath);

            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String tmp = "";
            while ((tmp = reader.readLine()) != null) {

                if (reader != null) {
                    reader.close();
                }
                if (process != null) {
                    process.destroy();
                }

            }
            reader.close();
            process.destroy();
            System.out.print("phantomjs生成图片渲染中完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resImgPath;
    }

    @Override
    public String toString() {
        return "to string";
    }
}
