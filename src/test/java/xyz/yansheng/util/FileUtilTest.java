package xyz.yansheng.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import xyz.yansheng.bean.Problem;

/**
 * test FileUtil
 * 
 * @author yansheng
 * @date 2019/10/10
 */
public class FileUtilTest {

    @Test
    public void testWriteList() {

        String filepath = "leetcode-api.json";
        ArrayList<Problem> problemList = SpiderUtil.getProblemListFromLocal(filepath);
        // 判断非空
        assertNotNull(problemList);
        assertFalse(problemList.isEmpty());

        String pathname = "./LeetCode问题集目录.md";

        // 写到文件中
        FileUtil.writeList(problemList, pathname);
    }
}
