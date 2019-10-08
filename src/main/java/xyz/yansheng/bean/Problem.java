package xyz.yansheng.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import xyz.yansheng.util.StringUtil;

/**
 * LeetCode问题的实体类
 * 
 * @author yansheng
 * @date 2019/10/08
 */
// @Getter
// @Setter
@AllArgsConstructor
// @ToString
public @Data class Problem {

    /**
     * 问题的序号id
     */
    private String id;
    /**
     * 问题的标题
     */
    private String title;
    /**
     * 问题的英文标题
     */
    private String titleEn;
    /**
     * 问题的难度等级，分为：简单、中等、困难三种
     */
    private String range;
    /**
     * 问题的描述的网址
     */
    private String problemUrl;
    /**
     * 问题的解答的网址
     */
    private String solutionUrl;

    /**
     * 生成格式化的类的实例的内容 ：- [ ] 0001.两数之和(Two Sum)
     * ：[题目描述](https://leetcode-cn.com/problems/two-sum/)，[解答](https://leetcode-cn.com/problems/two-sum/solution/)
     * 
     * @return String
     */
    public String formatToString() {

        return "- [ ] " + StringUtil.formatId(id) + "." + title + "(" + titleEn + ")：[题目描述](" + problemUrl + ")，[解答](" + solutionUrl + ")";
    }

}
