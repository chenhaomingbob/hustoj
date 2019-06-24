package com.zjgsu.service.zjgsu.impl;

import com.zjgsu.dao.zjgsu.QuestionDao;
import com.zjgsu.dao.zjgsu.UserSubmitDao;
import com.zjgsu.entity.zjgsu.QuestionEntity;
import com.zjgsu.entity.zjgsu.UserSubmitEntity;
import com.zjgsu.service.zjgsu.JudgeNormalQuestionService;
import com.zjgsu.service.zjgsu.JudgeProgramQuestionService;
import com.zjgsu.service.zjgsu.JudgeService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.zjgsu.util.JudgeCenterConstant.*;

/**
 * @author chm 神魔法
 * @date 2019/6/2 13:37
 */
@Service
public class JudgeServiceImpl implements JudgeService {
    /**
     * 判题的入口
     */
    @Override
    public void judgeQuestion(int submitId) {
        UserSubmitEntity userSubmitEntity = userSubmitDao.getByCriterion(Restrictions.eq("submitId", submitId));
        Integer questionId = userSubmitEntity.getQuestionId();
        QuestionEntity questionEntity = questionDao.getByCriterion(Restrictions.eq("questionId", questionId));
        Integer questionType = questionEntity.getType();
        Logger.info("接受到用户提交,submitId:{},userId:{},questionId:{},", submitId, userSubmitEntity.getUserId(), questionId);
        if (questionType.equals(QUESTION_TYPE_NORMAL_FILL)) {
            judgeNormalQuestionService.judgeNormalFillQuestion(questionEntity, userSubmitEntity);
        } else if (questionType.equals(QUESTION_TYPE_CHOICE)) {
            judgeNormalQuestionService.judgeChoiceQuestion(questionEntity, userSubmitEntity);
        } else if (questionType.equals(QUESTION_TYPE_JUDGMENT)) {
            judgeNormalQuestionService.judgeJudgmentQuestion(questionEntity, userSubmitEntity);
        } else if (questionType.equals(QUESTION_TYPE_PROGRAM_FILL)) {
            judgeProgramQuestionService.judgeProgramFillQuestion(questionEntity, userSubmitEntity);
        } else if (questionType.equals(QUESTION_TYPE_PROGRAM_CORRECTION)) {
            judgeProgramQuestionService.judgeCorrectionQuestion(questionEntity, userSubmitEntity);
        } else if (questionType.equals(QUESTION_TYPE_PROGRAM)) {
            judgeProgramQuestionService.judgeProgramQuestion(questionEntity, userSubmitEntity);
        }
    }


    @Autowired
    private UserSubmitDao userSubmitDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private JudgeNormalQuestionService judgeNormalQuestionService;
    @Autowired
    private JudgeProgramQuestionService judgeProgramQuestionService;

    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(JudgeServiceImpl.class);
}
