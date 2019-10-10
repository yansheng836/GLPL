package xyz.yansheng.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import xyz.yansheng.bean.Problem;

/**
 * 文件操作工具类。
 * 
 * @author yansheng
 * @date 2019/10/10
 */
public class FileUtil {

    /**
     * 将list写到文件中
     * 
     * @param problemList
     *            问题列表
     * @param pathname
     *            文件名
     */
    public static void writeList(ArrayList<Problem> problemList, String pathname) {

        // 先用StringBuffer拼接字符串，然后转为String写到文件中
        StringBuffer sBuffer = new StringBuffer(17000);
        // 1.文章标题：参考文件名"./LeetCode问题集目录.md"
        sBuffer.append("## " + pathname.substring(2, pathname.length() - 3) + "\n\n");
        // 2.文章的主要内容，问题列表
        for (Problem problem : problemList) {
            sBuffer.append(problem.formatToString() + "\n");
        }

        String encoding = "UTF-8";
        String data = new String(sBuffer);
        File file = new File(pathname);
        try {
            FileUtils.writeStringToFile(file, data, encoding);
            System.out.println("写数据到：" + pathname + " 成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
