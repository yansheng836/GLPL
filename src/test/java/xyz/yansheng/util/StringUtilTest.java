package xyz.yansheng.util;

import static org.junit.Assert.assertTrue;

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
            String id = StringUtil.formatId(String.valueOf(i));
            assertTrue(id.length() == 4);
            
            System.out.print(id +",");
        }
    }

}
