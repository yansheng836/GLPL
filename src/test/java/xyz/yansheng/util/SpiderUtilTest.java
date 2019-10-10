package xyz.yansheng.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import xyz.yansheng.bean.Problem;

/**
 * @author yansheng
 * @date 2019/10/09
 */
public class SpiderUtilTest {

    @Test
    public void testGetProblemList() {
        // String url = "https://leetcode-cn.com/problemset/all/";
        String filepath = "leetcode-api.json";
        ArrayList<Problem> problemList = SpiderUtil.getProblemList(filepath);
        // 逆序
        Collections.reverse(problemList);

        // 将字符串写到文件中
        String pathname = "./LeetCode问题集目录.md";
        StringBuffer sBuffer = new StringBuffer(16000);
        sBuffer.append("## " + pathname.substring(2, pathname.length() - 3) + "\n\n");
        System.out.println(sBuffer);
        // f.write('## %s\n\n' % filename[:-3])
        for (Problem problem : problemList) {
            // System.out.println(problem.formatToString());
            sBuffer.append(problem.formatToString() + "\n");
        }

        String encoding = "UTF-8";
        String data = new String(sBuffer);
        File file = new File(pathname);
        try {
            FileUtils.writeStringToFile(file, data, encoding);
            System.out.println("写数据到：" + pathname + "成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testGetProblemList0() {
        
        String url = "https://leetcode.com/api/problems/all/";
        SpiderUtil.getProblemList0(url);
    }

}
