package com.zjgsu.service.hustoj.impl;

import com.zjgsu.service.hustoj.SolutionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author chm 神魔法
 * @date 2019/6/1 16:32
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext-conf.xml"})
public class SolutionServiceImplTest {
    @Autowired
    private SolutionService solutionService;

    @Test
    public void testSubmitUserSolution() {
        int problemId = 1000;
        String userId = "admin";
        String ip = "192.168.3.1";
        int language = 1;
        String sourceCode = "#include <stdio.h> \n" +
                "int main() \n" +
                "{ \n" +
                "    int a,b; \n" +
                "    scanf(\"%d %d\",&a, &b); \n" +
                "    printf(\"%d\\n\",a+b); \n" +
                "    return 0; \n" +
                "} ";
        for (int i = 0; i < 8; i++) {
            solutionService.submitUserSolution(problemId, userId, ip, language, sourceCode);

        }

    }
}