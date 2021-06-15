package github.botapi.util.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * @author straycamel
 * @date 2021/5/18
 * 文件管理操作对象
 */
public class DirHandler {
    /**
     * 只获取某个文件夹下所有文件
     */
    public static ArrayList<String> getFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                System.out.println("文件：" + tempList[i]);
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
                System.out.println("文件夹：" + tempList[i]);
            }
        }
        return files;
    }

    /**
     * 递归调用文件夹下所有文件
     */
    public static ArrayList<String> getRecurseFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
                files.addAll(getRecurseFiles(tempList[i].toString()));
            }
        }
        return files;
    }

    /**
     * 递归调用文件夹下所有文件-根据过滤函数filterHandler
     */
    public static ArrayList<String> getRecurseFiles(String path, Function<String, Boolean> filterHandler) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                if (filterHandler.apply(tempList[i].toString())) {
                    files.add(tempList[i].toString());
                }
            }
            if (tempList[i].isDirectory()) {
                files.addAll(getRecurseFiles(tempList[i].toString(), filterHandler));
            }
        }
        return files;
    }

}
