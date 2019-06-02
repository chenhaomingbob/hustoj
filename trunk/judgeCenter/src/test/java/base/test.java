package base;

import com.sun.media.jfxmedia.track.Track;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author chm 神魔法
 * @date 2019/6/1 18:21
 */
public class test {

    @Test
    public void test1() {
        String code = "#include <stdio.h> \n" +
                "int main() \n" +
                "{ \n" +
                "    int a,b; \n" +
                "    scanf(\"%d %d\",&a, &b); \n" +
                "    printf(\"%d\\n\",a+b); \n" +
                "    return 0; \n" +
                "} ";
        System.out.println(code.length());
    }

    @Test
    public void test2() {
//        String fileName = "E:/Hub/Code/ZJGS/test.in";
//        File file = new File(fileName);
//        FileUtils.writeLines();

    }
}
