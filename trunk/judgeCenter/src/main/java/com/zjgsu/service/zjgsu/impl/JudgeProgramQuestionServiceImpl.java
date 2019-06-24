package com.zjgsu.service.zjgsu.impl;


import com.zjgsu.dao.hustoj.ProblemMapDao;
import com.zjgsu.dao.zjgsu.UserSubmitDao;
import com.zjgsu.entity.hustoj.ProblemMapEntity;
import com.zjgsu.entity.zjgsu.QuestionEntity;
import com.zjgsu.entity.zjgsu.UserSubmitEntity;
import com.zjgsu.service.hustoj.SolutionService;
import com.zjgsu.service.zjgsu.JudgeProgramQuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.zjgsu.util.JudgeCenterConstant.USER_SUBMIT_STATUS_FINISHED;

/**
 * @author chm 神魔法
 * @date 2019/6/2 14:01
 */
@Service
public class JudgeProgramQuestionServiceImpl implements JudgeProgramQuestionService {
    /**
     * 程序填空题
     */
    @Override
    public void judgeProgramFillQuestion(QuestionEntity questionEntity, UserSubmitEntity userSubmitEntity) {
        this.judgeProgramQuestion(questionEntity, userSubmitEntity);
    }

    /**
     * 程序改错题
     * // http://10.21.11.73/#/problem/821
     * // http://10.21.11.73/#/problem/1282
     */
    @Override
    public void judgeCorrectionQuestion(QuestionEntity questionEntity, UserSubmitEntity userSubmitEntity) {
        this.judgeProgramQuestion(questionEntity, userSubmitEntity);
    }

    /**
     * 编程题
     * 往hustoj的数据库中扔一个solution即可
     */
    @Override
    public void judgeProgramQuestion(QuestionEntity questionEntity, UserSubmitEntity userSubmitEntity) {
        String userId = "hi";
        int language = userSubmitEntity.getLanguage();
        String sourceCode = userSubmitEntity.getSourceCode();
        ProblemMapEntity problemMapEntity = problemMapDao.getByCriterion(Restrictions.eq("questionId", questionEntity.getQuestionId()));
        int solutionId = solutionService.submitUserSolution(problemMapEntity.getProblemId(), userId, HOST_IP, language, sourceCode);
        userSubmitEntity.setSolutionId(solutionId);
        userSubmitEntity.setStatus(USER_SUBMIT_STATUS_FINISHED);
        userSubmitDao.update(userSubmitEntity);
    }

    @Autowired
    private UserSubmitDao userSubmitDao;
    @Autowired
    private ProblemMapDao problemMapDao;
    @Autowired
    private SolutionService solutionService;
    @Autowired
    private String HOST_IP;
    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(JudgeProgramQuestionServiceImpl.class);
}
