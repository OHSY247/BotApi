package github.botapi.util.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author straycamel
 * @date 2021/6/8
 */
public interface HttpRequestService {

    /**
     * 从网络Url中下载文件-自动构造文件名
     *
     * @param urlStr-fileName 设定为以"/"分割url取最后一串字符
     * @param savePath        下载的文件保存的目录
     * @return 解析后的文件名
     */
    String downloadFromUrl(String urlStr, String savePath);

    /**
     * 从网络Url中下载文件
     * 若文件已存在-提醒即可
     *
     * @param urlStr
     * @param fileName 下载的文件保存本地的文件名
     * @param savePath 下载的文件保存的目录
     * @throws IOException
     */
    void downloadFromUrl(String urlStr, String fileName, String savePath) throws IOException;

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    byte[] readInputStream(InputStream inputStream) throws IOException;

    /**
     * 向指定的URL发送GET方法的请求-自定义请求头
     *
     * @param url 发送请求的URL
     * @return 远程资源的响应结果
     */
    String get(String url);

    /**
     * 向指定的URL发送GET方法的请求-自定义请求头
     *
     * @param url     发送请求的URL
     * @param headers 自定义请求头
     * @return 远程资源的响应结果
     */
    String get(String url, Map<String, String> headers);

    /**
     * 向指定的URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式
     * @return 远程资源的响应结果
     */
    String get(String url, String param);

    /**
     * 向指定的URL发送POST方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式
     * @return 远程资源的响应结果
     */
    String post(String url, String param);
}
