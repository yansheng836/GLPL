package xyz.yansheng.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import xyz.yansheng.bean.Problem;

/**
 * 爬虫工具类.
 * 1.一开始计划直接爬取网址数据，但是没想到数据js动态生成的，不会动态爬取。 
 * 2.后面找到了对应的json数据，于是改为爬取json数据：https://leetcode.com/api/problems/all/
 * 
 * @author yansheng
 * @date 2019/10/09
 */
public class SpiderUtil {

    /**
     * 解析在线json数据:https://leetcode.com/api/problems/all/
     * 
     * @param url
     *            json数据网址
     * @return 问题列表
     */
    public static ArrayList<Problem> getProblemListOnline(String url) {

        // 1.用Jsoup获得在线的json数据，转化为字符串
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取json
        String jsonString = doc.text();

        // 解析json，并返回
        return parseJsonStringToList(jsonString);
    }

    /**
     * 解析本地json数据
     * 
     * @param filepath
     *            文件路径
     * @return 问题列表
     */
    public static ArrayList<Problem> getProblemListFromLocal(String filepath) {

        // 1.读取本地json文件，转化为字符串
        String jsonString = null;
        try {
            jsonString = FileUtils.readFileToString(new File(filepath), "gbk");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 解析json，并返回
        return parseJsonStringToList(jsonString);
    }

    /**
     * 解析“问题”json字符串，返回问题列表
     * 
     * @param jsonString
     *            json字符串
     * @return 问题列表
     */
    public static ArrayList<Problem> parseJsonStringToList(String jsonString) {

        ArrayList<Problem> problemList = new ArrayList<Problem>(1350);

        // 2.解析json，最外层JSONObject{}
        JSONObject dataJson = JSON.parseObject(jsonString);

        // 3.解析内容的数组JSONArray[{},{}]
        JSONArray statStatusPairs = dataJson.getJSONArray("stat_status_pairs");

        // define the prefix of the url
        String prefix = "https://leetcode.com/problems/";
        // 中文版的：
        String prefixCn = "https://leetcode-cn.com/problems/";

        // 4.遍历每个对象，取出需要的值，构造Problem，然后添加到list中。
        int size = statStatusPairs.size();
        for (int i = 0; i < size; i++) {
            JSONObject problemJson = statStatusPairs.getJSONObject(i);
            JSONObject stat = problemJson.getJSONObject("stat");

            // 获取具体的属性
            String id = (String)stat.get("frontend_question_id").toString();
            String title = (String)stat.get("question__title");
            String titleEn = (String)stat.get("question__title_slug");
            String problemUrl = prefix + titleEn + "/description/";
            String solutionUrl = prefix + titleEn + "/solution/";

            JSONObject difficulty = problemJson.getJSONObject("difficulty");
            String range = (String)difficulty.get("level").toString();

            Problem problem = new Problem(id, title, titleEn, range, problemUrl, solutionUrl);
            problemList.add(problem);
        }

        // 逆序，因为在json中id小的在后面，这里进行逆序操作，将其放到前面。
        Collections.reverse(problemList);
        
        // 即使逆序后，会把小id放到前面，但是还有有点乱，再次进行排序
        problemList.sort((Problem o1, Problem o2) -> new Integer(o1.getId()).compareTo(new Integer(o2.getId())));

        return problemList;
    }

}
