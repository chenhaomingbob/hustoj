package com.zjgsu.task;

import com.zjgsu.dao.hustoj.SolutionDao;
import com.zjgsu.dao.zjgsu.UserSubmitDao;
import com.zjgsu.entity.hustoj.SolutionEntity;
import com.zjgsu.entity.zjgsu.UserSubmitEntity;
import com.zjgsu.service.zjgsu.GetUserReplyScoreService;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author chm 神魔法
 * @date 19-6-19 下午7:20
 */
@Component
public class Task {
    @Scheduled(fixedDelay = 1000)//(cron = "seconds minutes hours dayofmonth month dayofweek")
    public void startSecKill(){
        Criterion criterion = Restrictions.eq("status",0);
        Criterion criterion1 = Restrictions.between("result", 4, 20);
        List<SolutionEntity> solutionEntityList = solutionDao.listPageByCriterion(1, 20, criterion,criterion1);
        for (SolutionEntity solutionEntity : solutionEntityList) {
            Criterion criSolutionId = Restrictions.eq("solutionId",solutionEntity.getSolutionId());
            UserSubmitEntity userSubmitEntity = userSubmitDao.getByCriterion(criSolutionId);
            getUserReplyScoreService.updateProgramInfo(solutionEntity,userSubmitEntity);
            solutionEntity.setStatus(1);
            solutionDao.update(solutionEntity);
        }
        System.out.println("finish"+ new Date());
    }

    @Autowired
    private GetUserReplyScoreService getUserReplyScoreService;
    @Autowired
    private SolutionDao solutionDao;
    @Autowired
    private UserSubmitDao userSubmitDao;

}




