package github.botapi.util;

import github.botapi.util.handler.FileHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestZip {

    public static void main(String[] args) throws Exception{
        //testToZip();
        testUnzip();
    }

    /**
     * 测试压缩文件
     */
    public static void testToZip() throws Exception {
        File file1 = new File("c:\\1.txt");
        File file2 = new File("c:\\2.txt");
        List<File> files = new ArrayList<File>();
        files.add(file1);
        files.add(file2);
        OutputStream out = new FileOutputStream("c:\\1.zip");
        FileHandler.toZip(files,out);
    }

    /**
     * 测试解压文件
     * @throws Exception
     */
    public static void testUnzip() throws Exception{
        File srcFile = new File("/Users/straycamel/Documents/response.bin");
        String destDirPath = "/Users/straycamel/Documents/";
        FileHandler.unZip(srcFile,destDirPath);
    }
}

