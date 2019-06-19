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

import java.util.ArrayList;
import java.util.List;

import static com.zjgsu.util.JudgeCenterConstant.*;

/**
 * 获取用户得分
 *
 * @author chm 神魔法
 * @date 2019/6/4 14:01
 */
//TODO
@Service
public class GetUserReplyScoreServiceImpl implements GetUserReplyScoreService {

    /**
     * 根据提交的id获取得分
     *
     * @param submitId
     */
    public UserScoreDTO getScoreByReplyId(int submitId) {
        Order order = Order.asc("");
        userSubmitDao.listByCriterion();
        UserSubmitEntity userSubmitEntity = userSubmitDao.getByCriterion(Restrictions.eq("submitId", submitId));
        QuestionEntity questionEntity = questionDao.getByCriterion(Restrictions.eq("questionId", userSubmitEntity.getQuestionId()));
        Integer type = questionEntity.getType();
        UserScoreDTO userScoreDTO = new UserScoreDTO();
        if (type.equals(QUESTION_TYPE_NORMAL_FILL) || type.equals(QUESTION_TYPE_CHOICE) || type.equals(QUESTION_TYPE_JUDGMENT)) {
            //不是编程题
            userScoreDTO.setScore(userSubmitEntity.getResult());
            userScoreDTO.setCreatedTime(userSubmitEntity.getCreatedTime());
            userScoreDTO.setStatus(userSubmitEntity.getStatus());
        } else {
            //是编程题
        }
        return userScoreDTO;
    }

    @Override
    public void updateProgramInfo(SolutionEntity solutionEntity, UserSubmitEntity userSubmitEntity) {
        Integer questionType = userSubmitEntity.getQuestionType();
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
        int result = 0;
        Criterion criQuestionId = Restrictions.eq("questionId", userSubmitEntity.getQuestionId());
        if (solutionEntity.getResult() == SOLUTION_RESULT_AC) {
            result = 100;
        } else if (solutionEntity.getResult() != SOLUTION_RESULT_CE) {
            // 不是编译错误
            Criterion criSolutionId = Restrictions.eq("solutionId", solutionEntity.getSolutionId());
            List<SolutionTestPointsEntity> solutionTestPointsEntityList = solutionTestPointsDao.listByCriterion(criSolutionId);
            // questionTestPoints
            List<Order> orders = new ArrayList<>();
            Order order = Order.asc("testPointId");
            orders.add(order);
            Criterion criterion = Restrictions.eq("questionId", 1000);
            List<QuestionTestPointEntity> questionTestPointEntityList = questionTestPointDao.listByCriterionAndOrder(orders, criterion);
            for (SolutionTestPointsEntity solutionTestPointsEntity : solutionTestPointsEntityList) {
                if (solutionTestPointsEntity.getTestPointResult().equals(4)) {
                    String testPointInputFile = solutionTestPointsEntity.getTestPointInputFile();
                    int i = testPointInputFile.lastIndexOf(".");
                    QuestionTestPointEntity questionTestPointEntity = questionTestPointEntityList.get(i);
                    result = result + questionTestPointEntity.getScore();
                }
            }
        }
        userSubmitEntity.setResult(result);
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
