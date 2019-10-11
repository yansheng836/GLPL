package xyz.yansheng.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    
    @Test
    public void testSortList() {
        String id = "1";
        String title = "两数之和";
        String titleEn = "Two Sum";
        String range = "简单";
        String problemUrl = "https://leetcode-cn.com" + "/problems/two-sum";
        String solutionUrl = "https://leetcode-cn.com" + "/problems/two-sum/solution";

        Problem problem1 = new Problem(id, title, titleEn, range, problemUrl, solutionUrl);
        Problem problem2 = new Problem("2", "2", titleEn, range, problemUrl, solutionUrl);
        Problem problem3 = new Problem("3", "3", titleEn, range, problemUrl, solutionUrl);

        ArrayList<Problem> problems = new ArrayList<Problem>();
        problems.add(problem2);
        problems.add(problem1);
        problems.add(problem3);
        
        System.out.println("排序前：");
        problems.forEach((Problem problem) -> System.out.println(problem.formatToString()));

        // problems.sort(null);
        // 方法1.java7.排序
        Collections.sort(problems, new Comparator<Problem>() {

            @Override
            public int compare(Problem o1, Problem o2) {

                int id1 = new Integer(o1.getId());
                int id2 = new Integer(o2.getId());

                // 第一个数比较小，返回负数
                if (id1 < id2) {
                    return -1;
                } else {
                    return 1;
                }
            }

        });
        
        System.out.println("排序后：");
        problems.forEach((Problem problem) -> System.out.println(problem.formatToString()));

        // 方法2.java8.用lambda排序
        problems.sort((Problem o1, Problem o2) -> new Integer(o1.getId()).compareTo(new Integer(o2.getId())));

        System.out.println("排序后：");
        problems.forEach((Problem problem) -> System.out.println(problem.formatToString()));

    }

}
