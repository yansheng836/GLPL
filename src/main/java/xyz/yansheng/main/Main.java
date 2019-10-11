package xyz.yansheng.main;

import java.util.ArrayList;

import xyz.yansheng.bean.Problem;
import xyz.yansheng.util.FileUtil;
import xyz.yansheng.util.SpiderUtil;

/**
 * 爬取LeetCode问题列表，并且以特定格式写到文件中。
 * 
 * @author yansheng
 * @date 2019/10/09
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("正在爬取数据，请稍候……");
        
        // 方法1.爬取在线的json、然后进行解析获取数据
        String url = "https://leetcode.com/api/problems/all/";
        ArrayList<Problem> problemList = SpiderUtil.getProblemListOnline(url);

        // 方法2.解析本地json获取数据
        // String filepath = "./leetcode-api.json";
        // ArrayList<Problem> problemList = SpiderUtil.getProblemListFromLocal(filepath);

        // 写到文件中
        String pathname = "./LeetCode问题集目录.md";
        String pathname1 = "./LeetCode问题集目录-简单.md";
        String pathname2 = "./LeetCode问题集目录-中等.md";
        String pathname3 = "./LeetCode问题集目录-困难.md";

        String[] strings = {pathname, pathname1, pathname2, pathname3};
        
        for (String string : strings) {
            FileUtil.writeList(problemList, string);
        }
    }

}
