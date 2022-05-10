package org.codeman;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hdgaadd
 * Created on 2022/05/02
 */
public class PrintStructure {
    /**
     * 忽略文件夹
     */
    private static final List<String> IGNORE_DIRECTORY = new ArrayList<String>(){{
        add(".git");
        add(".idea");
        add("target");
    }};
    private static final String FIRST_DIRECTION_PARENT = "├── ";
    private static final String FIRST_DIRECTION_CHILD = "└── ";
    private static final String SECOND_DIRECTION_PARENT = "     ├── ";
    private static final String SECOND_DIRECTION_CHILD = "     └── ";
    /**
     * 遍历层数
     */
    private static final int LAYERS = 2; // ['leɪəz]
    /**
     * 程序组成结构没有以"src"开头的模块
     */
    private static final List<String> noSrc = new ArrayList<String>(){{
        add("Netty");
        add("rpc");
    }};

    public static void main(String[] args) {
        // 项目文件对象
        File file = new File(System.getProperty("user.dir"));
        System.out.println(file.getName());
        loopTraverse(file, FIRST_DIRECTION_PARENT, FIRST_DIRECTION_CHILD, 1);
    }

    /**
     * 循环遍历每一级别[trəˈvɜːs]
     *
     * @param file
     * @param directionParent
     * @param directionChild
     * @param index 本次遍历所在的层数
     */
    private static void loopTraverse(File file, String directionParent, String directionChild, int index) {
        File[] files = file.listFiles();
        // 文件夹尾端下标
        int endIndex = getDirectoryLen(file);
        for (int i = 0; i < files.length; i++) {
            File curFile = files[i];
            String curFileName = curFile.getName();;
            if (!IGNORE_DIRECTORY.contains(curFileName) && curFile.isDirectory()) {
                // [ˌdekəˈreɪʃn]装饰品
                String firstDecoration = (i == endIndex) ? directionChild : directionParent;
                // 模块描述
                String firstDescription = getDescription(curFile);
                System.out.println(firstDecoration + curFileName + firstDescription);

                // 处理程序组成结构没有以"src"开头的模块
                if (!noSrc.contains(curFileName)) {
                    curFile = new File(file.toString() + "\\" + curFileName + "\\src\\main\\java\\org\\codeman");
                }
                // 循环遍历下一层
                if (index < LAYERS) {
                    loopTraverse(curFile, SECOND_DIRECTION_PARENT, SECOND_DIRECTION_CHILD, index + 1);
                }
            }
        }
    }

    /**
     * 获取模块描述
     *
     * @param file
     * @return
     */
    private static String getDescription(File file) {
        for (File curFile : file.listFiles()) {
            if (curFile.isFile()) {
                String description = curFile.getName();
                if (!description.contains(".")) {
                    return " -- " + description;
                }
            }
        }
        return "";
    }

    /**
     * 获取某级别文件夹尾端下标，方便添加前缀："└── "
     *
     * @param file
     * @return
     */
    private static int getDirectoryLen(File file) {
        int index = -1;
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File curFile = files[i];
            if (!IGNORE_DIRECTORY.contains(curFile.getName()) && curFile.isDirectory()) {
                index = i;
            }
        }
        return index;
    }
}
