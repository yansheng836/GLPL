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
     * 将list写到文件中（先根据文件名判断是否需要区分打印的列表的难度）
     * 
     * @param problemList
     *            问题列表
     * @param pathname
     *            文件名
     */
    public static void writeList(ArrayList<Problem> problemList, String pathname) {

        ArrayList<Problem> problems = new ArrayList<Problem>(400);
        // 根据文件名判断是否需要区分打印的列表的难度
        String range = "0";
        if (pathname.contains("-简单")) {
            range = "1";
        } else if (pathname.contains("-中等")) {
            range = "2";
        } else if (pathname.contains("-困难")) {
            range = "3";
        }

        // 如果是0，则说明是所有问题，不区分难度
        if ("0".equals(range)) {
            problems = problemList;
        } else {
            // 按照困难等级进行分类
            for (Problem problem : problemList) {
                if (range.equals(problem.getRange())) {
                    problems.add(problem);
                }
            }
        }

        // 先用StringBuffer拼接字符串，然后转为String写到文件中
        StringBuffer sBuffer = new StringBuffer(17000);
        // 1.文章标题：参考文件名"./LeetCode问题集目录.md"
        sBuffer.append("## " + pathname.substring(2, pathname.length() - 3) + "(共" + problems.size() + "题)\n\n");
        // 2.文章的主要内容，问题列表
        for (Problem problem : problems) {
            sBuffer.append(problem.formatToString() + "\n");
        }

        String encoding = "UTF-8";
        String data = new String(sBuffer);
        File file = new File(pathname);
        try {
            FileUtils.writeStringToFile(file, data, encoding);
            System.out.println("写数据到：" + pathname + " 成功！共有 " + problems.size() + " 条数据。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
