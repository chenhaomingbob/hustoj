package base;

import com.zjgsu.dao.hustoj.SourceCodeDao;
import com.zjgsu.entity.hustoj.SourceCodeEntity;
import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author chm 神魔法
 * @date 2019/6/2 10:53
 */

public class runTest {
    @Autowired
    private SourceCodeDao sourceCodeDao;
    @Test
    public void test1() throws IOException {
        String filePath = "E:\\tt\\Code/test.in";
        File file = new File(filePath);
//        SourceCodeEntity sourceCodeEntity = sourceCodeDao.getByCriterion(Restrictions.eq("solutionId", 1031));
        FileUtils.write(file,"123", Charset.forName("UTF-8"));
    }
}
