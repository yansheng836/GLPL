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
        
        for (int i = 1; i < 101; i++) {
            System.out.println(StringUtil.formatId(String.valueOf(i)));
        }
    }

}
