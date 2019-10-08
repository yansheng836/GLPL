package xyz.yansheng.bean;

import org.junit.Test;

/**
 * @author yansheng
 * @date 2019/10/09
 */
public class ProblemTest {

    @Test
    public void test() {
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
    // <tr>
    // <td value="ac" label="[object Object]"><span class="text-success fa fa-check"></span>
    // </td>
    // <td label="[object Object]">1</td>
    // <td value="Two Sum" label="[object Object]">
    // <div><a href="/problems/two-sum">两数之和</a> <span class="fa fa-info-circle title-tooltip" data-toggle="tooltip"
    // data-placement="top" data-original-title="Two Sum" aria-hidden="true" style="cursor: pointer;"></span> </div>
    // </td>
    // <td value="363" label="[object Object]"><a href="/problems/two-sum/solution" class="solution-link">363</a>
    // </td>
    // <td value="46.723562712212555" label="[object Object]">46.7%</td>
    // <td value="[object Object]" label="[object Object]"><span class="label label-success round">简单</span>
    // </td>
    // <td label="[object Object]"></td>
    // </tr>
}
