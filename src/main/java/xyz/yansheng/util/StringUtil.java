package xyz.yansheng.util;

import java.text.DecimalFormat;

/**
 * 字符串工具类。
 * 
 * @author yansheng
 * @date 2019/10/09
 */
public class StringUtil {

    /**
     * 格式化“问题的序号id”,将其转化为4位的数，如果位数不够，用0补齐。
     * 
     * @param id
     *            问题的序号id
     * @return 格式化后的id
     */
    public static String formatId(String id) {
        DecimalFormat format = new DecimalFormat("0000");
        // 要先将字符串转为对应的数值的类，不然会抛出IllegalArgumentException
        String formatString = format.format(new Integer(id));
        return formatString;
    }

}
