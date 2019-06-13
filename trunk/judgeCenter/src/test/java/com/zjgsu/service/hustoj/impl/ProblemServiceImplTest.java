package com.zjgsu.service.hustoj.impl;

import com.zjgsu.service.hustoj.ProblemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
/**
 * @author chm 神魔法
 * @date 2019/6/13 16:32
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext-conf.xml"})
public class ProblemServiceImplTest {
    @Autowired
    private ProblemService problemService;
    @Test
    public void addProblemToHustoj() {
    }

    @Test
    public void writeTestPointsFileToJudgeDisk() {
        problemService.writeTestPointsFileToJudgeDisk(1000);
    }
}