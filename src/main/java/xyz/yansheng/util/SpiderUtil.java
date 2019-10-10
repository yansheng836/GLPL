package xyz.yansheng.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import xyz.yansheng.bean.Problem;

/**
 * 爬虫工具类，爬取json数据：https://leetcode.com/api/problems/all/
 * 
 * @author yansheng
 * @date 2019/10/09
 */
public class SpiderUtil {

    /**
     * 解析本地json数据
     * 
     * @param filepath
     *            文件路径
     * @return 问题列表
     */
    public static ArrayList<Problem> getProblemList(String filepath) {

        ArrayList<Problem> problemList = new ArrayList<Problem>(1000);

        // 1.读取本地json文件，转化为字符串
        String json = null;
        try {
            json = FileUtils.readFileToString(new File(filepath), "gbk");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2.解析json，最外层JSONObject{}
        JSONObject dataJson = JSON.parseObject(json);
        // System.out.println(dataJson);

        // 3.解析内容的数组JSONArray[{},{}]
        JSONArray statStatusPairs = dataJson.getJSONArray("stat_status_pairs");
        // System.out.println(statStatusPairs);

        // define the prefix of the url
        String prefix = "https://leetcode.com/problems/";

        // 4.遍历每个对象
        int size = statStatusPairs.size();
        for (int i = 0; i < size; i++) {
            JSONObject problemJson = statStatusPairs.getJSONObject(i);
            // System.out.println(jsonObject);
            JSONObject stat = problemJson.getJSONObject("stat");
            // System.out.println(stat);

            // 获取具体的属性
            String id = (String)stat.get("question_id").toString();
            String title = (String)stat.get("question__title");
            String titleEn = (String)stat.get("question__title_slug");
            String problemUrl = prefix + titleEn + "/description/";
            String solutionUrl = prefix + titleEn + "/solution/";

            JSONObject difficulty = problemJson.getJSONObject("difficulty");
            String range = (String)difficulty.get("level").toString();

            Problem problem = new Problem(id, title, titleEn, range, problemUrl, solutionUrl);
            // System.out.println(problem.toString());
            // System.out.println(problem.formatToString());
            problemList.add(problem);
        }

        return problemList;
    }

    /**
     * 解析在线json数据（简单版，内容详见getProblemList）
     * 
     * @param url
     *            json数据网址
     * @return 问题列表
     */
    public static ArrayList<Problem> getProblemList0(String url) {

        ArrayList<Problem> problemList = new ArrayList<Problem>(1000);

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(doc.text());
        
        // ……，下面内容同下

        return problemList;
    }

}
