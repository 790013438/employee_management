package snippets.jee.util;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CommonUtilTest {

    @Test
    public void testGetUniqueFilename() {
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= 1000000; ++i) {
            set.add(CommonUtil.getUniqueFilename());
        }
        assertEquals(1000000, set.size());
        System.out.print(CommonUtil.getUniqueFilename());
    }

    @Test
    public void testGetFilenameSuffix() {
        // out.println("Hello, world!");
        assertEquals(".jpg", CommonUtil.getFilenameSuffix("hello.jpg"));
        assertEquals(".jpg", CommonUtil.getFilenameSuffix("a.b.c.jpg"));
        assertEquals("", CommonUtil.getFilenameSuffix("hello"));
        assertEquals("", CommonUtil.getFilenameSuffix(".jpg"));
        assertEquals("", CommonUtil.getFilenameSuffix("hello."));
    }

}
