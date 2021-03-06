package com.zjgsu.service.zjgsu.impl;

import com.zjgsu.dao.hustoj.SolutionTestPointsDao;
import com.zjgsu.dao.zjgsu.QuestionDao;
import com.zjgsu.dao.zjgsu.QuestionTestPointDao;
import com.zjgsu.dao.zjgsu.UserSubmitDao;
import com.zjgsu.dto.UserScoreDTO;
import com.zjgsu.entity.hustoj.SolutionEntity;
import com.zjgsu.entity.hustoj.SolutionTestPointsEntity;
import com.zjgsu.entity.zjgsu.QuestionEntity;
import com.zjgsu.entity.zjgsu.QuestionTestPointEntity;
import com.zjgsu.entity.zjgsu.UserSubmitEntity;
import com.zjgsu.service.zjgsu.GetUserReplyScoreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.zjgsu.util.JudgeCenterConstant.*;

/**
 * 获取用户得分
 *
 * @author chm 神魔法
 * @date 2019/6/4 14:01
 */
@Service
public class GetUserReplyScoreServiceImpl implements GetUserReplyScoreService {
    /**
     * 根据提交的id获取得分
     *
     * @param submitId
     */
    @Override
    public UserScoreDTO getScoreByReplyId(int submitId) {
        UserSubmitEntity userSubmitEntity = userSubmitDao.getByCriterion(Restrictions.eq("submitId", submitId));
        UserScoreDTO userScoreDTO = new UserScoreDTO();
        userScoreDTO.setScore(userSubmitEntity.getResult());
        userScoreDTO.setCreatedTime(userSubmitEntity.getCreatedTime());
        userScoreDTO.setStatus(userSubmitEntity.getStatus());
        return userScoreDTO;
    }

    /**
     * 把已经完成评判的提交，进行更新。
     * @param solutionEntity
     * @param userSubmitEntity
     */
    @Override
    public void updateProgramInfo(SolutionEntity solutionEntity, UserSubmitEntity userSubmitEntity) {
        Criterion criStatus = Restrictions.eq("status",DATABASE_RECORD_STATUS_RAW);
        Criterion criterion = Restrictions.eq("questionId", userSubmitEntity.getQuestionId());
        QuestionEntity questionEntity = questionDao.getByCriterion(criterion,criStatus);
        Integer questionType = questionEntity.getType();
        if (questionType.equals(QUESTION_TYPE_PROGRAM_FILL)) {
            this.updateProgramFillSubmit(solutionEntity, userSubmitEntity);
        } else if (questionType.equals(QUESTION_TYPE_PROGRAM_CORRECTION)) {
            this.updateProgramCorrectionSubmit(solutionEntity, userSubmitEntity);
        } else if (questionType.equals(QUESTION_TYPE_PROGRAM)) {
            this.updateProgramSubmit(solutionEntity, userSubmitEntity);
        }
    }

    private void updateProgramFillSubmit(SolutionEntity solutionEntity, UserSubmitEntity userSubmitEntity) {
        this.updateProgramSubmit(solutionEntity, userSubmitEntity);
    }

    private void updateProgramCorrectionSubmit(SolutionEntity solutionEntity, UserSubmitEntity userSubmitEntity) {
        this.updateProgramSubmit(solutionEntity, userSubmitEntity);
    }

    private void updateProgramSubmit(SolutionEntity solutionEntity, UserSubmitEntity userSubmitEntity) {
        Criterion criStatus = Restrictions.eq("status",DATABASE_RECORD_STATUS_RAW);
        int result = 0;
        if (solutionEntity.getResult() == SOLUTION_RESULT_AC) {
            result = 100;
        } else if (solutionEntity.getResult() != SOLUTION_RESULT_CE) {
            // 不是编译错误
            Criterion criSolutionId = Restrictions.eq("solutionId", solutionEntity.getSolutionId());
            List<SolutionTestPointsEntity> solutionTestPointsEntityList = solutionTestPointsDao.listByCriterion(criSolutionId,criStatus);
            // questionTestPoints
            List<Order> orders = new ArrayList<>();
            Order order = Order.asc("testPointId");
            orders.add(order);
            Criterion criterion = Restrictions.eq("questionId", userSubmitEntity.getQuestionId());
            List<QuestionTestPointEntity> questionTestPointEntityList = questionTestPointDao.listByCriterionAndOrder(orders, criterion);
            for (SolutionTestPointsEntity solutionTestPointsEntity : solutionTestPointsEntityList) {
                if (solutionTestPointsEntity.getTestPointResult().equals(SOLUTION_RESULT_AC)) {
                    String testPointInputFile = solutionTestPointsEntity.getTestPointInputFile();
                    int i = testPointInputFile.lastIndexOf(".");
                    QuestionTestPointEntity questionTestPointEntity = questionTestPointEntityList.get(i);
                    result = result + questionTestPointEntity.getScore();
                }
            }
        }
        userSubmitEntity.setResult(result);
        userSubmitEntity.setStatus(USER_SUBMIT_STATUS_RATED);
        userSubmitDao.update(userSubmitEntity);
    }

    @Autowired
    private UserSubmitDao userSubmitDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private SolutionTestPointsDao solutionTestPointsDao;
    @Autowired
    private QuestionTestPointDao questionTestPointDao;
    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(GetUserReplyScoreServiceImpl.class);
}
