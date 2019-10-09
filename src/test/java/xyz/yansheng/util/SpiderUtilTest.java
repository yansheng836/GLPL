 package xyz.yansheng.util;

import org.junit.Test;

/**
 * @author yansheng
 * @date 2019/10/09
 */
public class SpiderUtilTest {
    
    @Test
    public void testGetProblemList() {
//        String url = "https://leetcode-cn.com/problemset/all/";
        String url = "https://leetcode-cn.com/problemset/all/#page-2";
        SpiderUtil.getProblemList(url);
    }

}
