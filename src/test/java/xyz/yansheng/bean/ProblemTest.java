package xyz.yansheng.bean;

import org.junit.Test;

/**
 * @author yansheng
 * @date 2019/10/09
 */
public class ProblemTest {

    @Test
    public void testProblem() {
        // - [ ] 两数之和(Two Sum) ：[题目描述](https://leetcode-cn.com/problems/two-sum/)，
        // [解答](https://leetcode-cn.com/problems/two-sum/solution/)
        String id = "1";
        String title = "两数之和";
        String titleEn = "Two Sum";
        String range = "简单";
        String problemUrl = "https://leetcode-cn.com" + "/problems/two-sum";
        String solutionUrl = "https://leetcode-cn.com" + "/problems/two-sum/solution";
        
        Problem problem = new Problem(id,title,titleEn,range,problemUrl,solutionUrl);
        System.out.println(problem.toString());
        System.out.println(problem.formatToString());
        
    }
    
}
