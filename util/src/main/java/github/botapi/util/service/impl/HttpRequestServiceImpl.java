package github.botapi.util.service.impl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import github.botapi.util.constant.NetworkConstant;
import github.botapi.util.service.HttpRequestService;
import org.springframework.stereotype.Service;

/**
 * @author straycamel
 * @date 2021/6/8
 */
@Service
public class HttpRequestServiceImpl implements HttpRequestService {
    @Override
    public String downloadFromUrl(String urlStr, String savePath) {
        try {
            if (urlStr == null || !urlStr.contains(NetworkConstant.SEPARATOR)) {
                throw new IOException("下载链接无法解析文件名");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] urlArray = urlStr.split(NetworkConstant.SEPARATOR);

        String fileName = urlArray[urlArray.length - 1];
        try {
            downloadFromUrl(urlStr, fileName, savePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filePath = new File(savePath, fileName).toString();
        System.out.println("filePath:" + filePath);
        return filePath;
    }

    @Override
    public void downloadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
        //文件保存位置
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            boolean result = saveDir.mkdirs();
            System.out.println("Status = " + result);
        }
        File file = new File(saveDir + File.separator + fileName);
        if (file.exists()) {
            System.out.println("notice:" + urlStr + " already download");
        } else {
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(NetworkConstant.BUFFER_SIZE);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            //得到输入流
            InputStream inputStream = conn.getInputStream();
            //获取自己数组
            byte[] getData = readInputStream(inputStream);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if (fos != null) {
                fos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            System.out.println("info:" + url + " download success");

        }
    }

    @Override
    public byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    @Override
    public String get(String url) {
        String result = "";
        BufferedReader bufferedReader = null;
        try {
            //1、读取初始URL
            String urlNameString = url;
            //2、将url转变为URL类对象
            URL realUrl = new URL(urlNameString);

            //3、打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            //4、设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            //5、建立实际的连接
            connection.connect();
            //获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            //遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "---->" + map.get(key));
            }

            //6、定义BufferedReader输入流来读取URL的响应内容 ，UTF-8是后续自己加的设置编码格式，也可以去掉这个参数
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line = "";
            while (null != (line = bufferedReader.readLine())) {
                result += line;
            }
            //            int tmp;
            //            while((tmp = bufferedReader.read()) != -1){
            //                result += (char)tmp;
            //            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("发送GET请求出现异常！！！" + e);
            e.printStackTrace();
        } finally {        //使用finally块来关闭输入流
            try {
                if (null != bufferedReader) {
                    bufferedReader.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public String get(String url, Map<String, String> headers) {
        String result = "";
        BufferedReader bufferedReader = null;
        try {
            //1、读取初始URL
            String urlNameString = url;
            //2、将url转变为URL类对象
            URL realUrl = new URL(urlNameString);

            //3、打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            //4、设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            Iterator<Map.Entry<String, String>> iterator = headers.entrySet().iterator();
            if (iterator != null) {
                System.out.println(iterator);
                while (iterator.hasNext()) {
                    Map.Entry<String, String> tmp = iterator.next();
                    connection.setRequestProperty(tmp.getKey(), tmp.getValue());
                }
            }

            //5、建立实际的连接
            connection.connect();
            //获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            //遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "---->" + map.get(key));
            }

            //6、定义BufferedReader输入流来读取URL的响应内容 ，UTF-8是后续自己加的设置编码格式，也可以去掉这个参数
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line = "";
            while (null != (line = bufferedReader.readLine())) {
                result += line;
            }
            //            int tmp;
            //            while((tmp = bufferedReader.read()) != -1){
            //                result += (char)tmp;
            //            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("发送GET请求出现异常！！！" + e);
            e.printStackTrace();
        } finally {        //使用finally块来关闭输入流
            try {
                if (null != bufferedReader) {
                    bufferedReader.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public String get(String url, String param) {
        String result = "";
        BufferedReader bufferedReader = null;
        try {
            //1、读取初始URL
            String urlNameString = url + "?" + param;
            //2、将url转变为URL类对象
            URL realUrl = new URL(urlNameString);

            //3、打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            //4、设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            connection.connect();
            //获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            //遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "---->" + map.get(key));
            }

            //6、定义BufferedReader输入流来读取URL的响应内容 ，UTF-8是后续自己加的设置编码格式，也可以去掉这个参数
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line = "";
            while (null != (line = bufferedReader.readLine())) {
                result += line;
            }
            //            int tmp;
            //            while((tmp = bufferedReader.read()) != -1){
            //                result += (char)tmp;
            //            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("发送GET请求出现异常！！！" + e);
            e.printStackTrace();
        } finally {        //使用finally块来关闭输入流
            try {
                if (null != bufferedReader) {
                    bufferedReader.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public String post(String url, String param) {
        String result = "";
        BufferedReader bufferedReader = null;
        PrintWriter out = null;
        try {
            //1、2、读取并将url转变为URL类对象
            URL realUrl = new URL(url);

            //3、打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            //4、设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            // 发送POST请求必须设置如下两行
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //5、建立实际的连接
            out = new PrintWriter(connection.getOutputStream());
            //发送请求参数
            out.print(param);
            //flush输出流的缓冲
            out.flush();
            //

            //6、定义BufferedReader输入流来读取URL的响应内容
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while (null != (line = bufferedReader.readLine())) {
                result += line;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("发送POST请求出现异常！！！" + e);
            e.printStackTrace();
        } finally {        //使用finally块来关闭输出流、输入流
            try {
                if (null != out) {
                    out.close();
                }
                if (null != bufferedReader) {
                    bufferedReader.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return result;
    }


    public static final long MINUTE = 1000 * 60L;
    public static final long TEN_MINUTE = MINUTE * 10;
    public static final long HALF_HOUR = MINUTE * 30;
    public static final long ONE_DAY = MINUTE * 60 * 24;
    public static final long TWO_WEEK = ONE_DAY * 14;
    public static void main(String[] args) {
        System.out.println(TWO_WEEK);
    }
}
