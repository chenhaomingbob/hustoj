package com.zjgsu.service.hustoj.impl;

import com.zjgsu.dao.zjgsu.UserSubmitDao;
import com.zjgsu.entity.zjgsu.UserSubmitEntity;
import com.zjgsu.service.hustoj.SolutionService;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext-conf.xml"})
public class SubmitTest {
    @Test
    public void UserSubmitNoramlFillTest() {
        String userAnswer="{\"userReplyList\":[{\"answer\":\"ab\",\"number\":1},{\"answer\":\"ba\",\"number\":2}]}";
        UserSubmitEntity userSubmitEntity = new UserSubmitEntity();
        userSubmitEntity.setUserId(1);
        userSubmitEntity.setQuestionId(2);
        userSubmitEntity.setUserAnswer(userAnswer);
        userSubmitEntity.setStatus(1);
        int submitId = userSubmitDao.save(userSubmitEntity);
        Logger.info("submitId:{}", submitId);
    }

    @Test
    public void UserSubmitChoiceTest() {
        UserSubmitEntity userSubmitEntity = new UserSubmitEntity();

        userSubmitEntity.setUserId(1);
        userSubmitEntity.setQuestionId(3);
        userSubmitEntity.setUserAnswer("a");
        userSubmitEntity.setStatus(1);

        int submitId = userSubmitDao.save(userSubmitEntity);
        Logger.info("submitId:{}", submitId);
    }

    @Test
    public void UserSubmitJudgmentTest() {
        UserSubmitEntity userSubmitEntity = new UserSubmitEntity();

        userSubmitEntity.setUserId(1);
        userSubmitEntity.setQuestionId(4);
        userSubmitEntity.setUserAnswer("true");
        userSubmitEntity.setStatus(1);

        int submitId = userSubmitDao.save(userSubmitEntity);
        Logger.info("submitId:{}", submitId);
    }
    @Test
    public void UserSubmitProgramTest() {
        String sourceCode = "#include <stdio.h> \n" +
                "int main() \n" +
                "{ \n" +
                "    int a,b; \n" +
                "    scanf(\"%d %d\",&a, &b); \n" +
                "    printf(\"%d\\n\",a+b); \n" +
                "    return 0; \n" +
                "} ";
        UserSubmitEntity userSubmitEntity = new UserSubmitEntity();
        userSubmitEntity.setUserId(1);
        userSubmitEntity.setQuestionId(1);
        userSubmitEntity.setLanguage(1);
        userSubmitEntity.setStatus(1);
        userSubmitEntity.setSourceCode(sourceCode);


        int submitId = userSubmitDao.save(userSubmitEntity);
        Logger.info("submitId:{}", submitId);

    }
    @Autowired
    private SolutionService solutionService;
    @Autowired
    private UserSubmitDao userSubmitDao;
    /**
     * 日志记录器.
     */
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(SubmitTest.class);
}
