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

        // 写到文件中
        String pathname = "./test/LeetCode问题集目录.md";
        String pathname1 = "./test/LeetCode问题集目录-简单.md";
        String pathname2 = "./test/LeetCode问题集目录-中等.md";
        String pathname3 = "./test/LeetCode问题集目录-困难.md";

        String[] strings = {pathname, pathname1, pathname2, pathname3};
        for (String string : strings) {
            FileUtil.writeList(problemList, string);
        }
    }

}
