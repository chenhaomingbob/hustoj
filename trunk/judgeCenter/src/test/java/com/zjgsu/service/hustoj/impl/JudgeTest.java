package com.zjgsu.service.hustoj.impl;

import com.zjgsu.dao.zjgsu.UserSubmitDao;
import com.zjgsu.entity.zjgsu.UserSubmitEntity;
import com.zjgsu.service.zjgsu.JudgeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.tcp.ReconnectStrategy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.zjgsu.util.JudgeCenterConstant.DATABASE_RECORD_STATUS_RAW;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext-conf.xml"})
public class JudgeTest {

    @Test
    public void test() {
        Criterion criStatus = Restrictions.eq("status", DATABASE_RECORD_STATUS_RAW);
        List<UserSubmitEntity> userSubmitEntityList = userSubmitDao.listByCriterion(criStatus);
        Logger.info("total userSubmit:{}", userSubmitEntityList.size());
        for (UserSubmitEntity userSubmitEntity : userSubmitEntityList) {
            Integer submitId = userSubmitEntity.getSubmitId();
            Logger.info("start process ,submitId:{}", submitId);
            judgeService.judgeQuestion(submitId);
            Logger.info("finish process ,submitId:{}", submitId);
        }
    }


    @Autowired
    private UserSubmitDao userSubmitDao;

    @Autowired
    private JudgeService judgeService;

    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(JudgeTest.class);
}
