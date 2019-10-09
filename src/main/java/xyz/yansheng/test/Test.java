package xyz.yansheng.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author yansheng
 * @date 2019/10/09
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String url = "https://leetcode-cn.com/problemset/all/";
        System.out.println(name(url));

    }

    public static String name(String url) {
        Runtime rt = Runtime.getRuntime();
        Process process = null;
        try {
            process = rt.exec("G:\\Workspaces\\eclipse最新英文版\\GLPL\\phantomjs.exe G:\\Workspaces\\eclipse最新英文版\\GLPL\\parser.js " + url);
            InputStream in = process.getInputStream();
            InputStreamReader reader = new InputStreamReader(in, "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            StringBuffer sbf = new StringBuffer();
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                sbf.append(tmp);
            }
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
