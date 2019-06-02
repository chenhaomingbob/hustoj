package base;

import com.zjgsu.dao.hustoj.ProblemDao;
import com.zjgsu.dao.hustoj.SourceCodeDao;
import com.zjgsu.entity.hustoj.ProblemEntity;
import com.zjgsu.entity.hustoj.SourceCodeEntity;
import com.zjgsu.service.hustoj.SolutionService;
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
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext-conf.xml"})
public class runTest {
    @Autowired
    private SourceCodeDao sourceCodeDao;
    @Autowired
    private ProblemDao problemDao;
    @Autowired
    private SolutionService solutionService;
    @Test
    public void test1() throws IOException {
        String filePath = "/home/judge/test.in";
        File file = new File(filePath);
//        SourceCodeEntity sourceCodeEntity = sourceCodeDao.getByCriterion(Restrictions.eq("solutionId", 1031));
        FileUtils.write(file,"123", Charset.forName("UTF-8"));
    }

    @Test
    public void addProblem() {
        ProblemEntity problemEntity = problemDao.getByCriterion(Restrictions.eq("problemId", 1000));

        problemEntity.setProblemId(null);
        problemDao.save(problemEntity);

    }

    @Test
    public void addTestFiles(){
        solutionService.writeTestPointsFileToJudgeDisk(1002);
    }

}
