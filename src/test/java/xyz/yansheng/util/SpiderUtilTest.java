package xyz.yansheng.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import xyz.yansheng.bean.Problem;

/**
 * 测试SpiderUtil。
 * 
 * @author yansheng
 * @date 2019/10/09
 */
public class SpiderUtilTest {

    @Test
    public void testGetProblemListOnline() {

        String url = "https://leetcode.com/api/problems/all/";
        ArrayList<Problem> problemList = SpiderUtil.getProblemListOnline(url);
        // 判断非空
        assertNotNull(problemList);
        assertFalse(problemList.isEmpty());

        // 遍历
        for (Problem problem : problemList) {
            System.out.println(problem.formatToString());
        }
    }

    @Test
    public void testGetProblemListFromLocal() {
        String filepath = "./leetcode-api.json";
        ArrayList<Problem> problemList = SpiderUtil.getProblemListFromLocal(filepath);

        // 判断非空
        assertNotNull(problemList);
        assertFalse(problemList.isEmpty());

        // 遍历
        for (Problem problem : problemList) {
            System.out.println(problem.formatToString());
        }
    }

}
