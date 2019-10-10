 package xyz.yansheng.util;

import org.junit.Test;

/**
 * @author yansheng
 * @date 2019/10/09
 */
public class StringUtilTest {

    /**
     * Test method for {@link xyz.yansheng.util.StringUtil#formatId(java.lang.String)}.
     */
    @Test
    public void testFormatId() {
        
        int count = 1100;
        for (int i = 1; i < count; i++) {
            System.out.println(StringUtil.formatId(String.valueOf(i)));
        }
    }

}
