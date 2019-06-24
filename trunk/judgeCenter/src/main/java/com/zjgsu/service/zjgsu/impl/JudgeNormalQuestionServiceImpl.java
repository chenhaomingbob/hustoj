package com.zjgsu.service.zjgsu.impl;

import com.alibaba.fastjson.JSON;
import com.zjgsu.dao.zjgsu.QuestionAnswerDao;
import com.zjgsu.dao.zjgsu.UserSubmitDao;
import com.zjgsu.dto.AnswerDTO;
import com.zjgsu.dto.QuestionAnswerContentListDTO;
import com.zjgsu.dto.UserReplyListDTO;
import com.zjgsu.entity.zjgsu.QuestionAnswerEntity;
import com.zjgsu.entity.zjgsu.QuestionEntity;
import com.zjgsu.entity.zjgsu.UserSubmitEntity;
import com.zjgsu.service.zjgsu.JudgeNormalQuestionService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.zjgsu.util.JudgeCenterConstant.USER_SUBMIT_STATUS_FINISHED;
import static com.zjgsu.util.JudgeCenterConstant.USER_SUBMIT_STATUS_RATED;

/**
 * 用来判断一般题目 ：填空题、选择题、判断题.
 *
 * @author chm 神魔法
 * @date 2019/6/2 14:02
 */
@Service
public class JudgeNormalQuestionServiceImpl implements JudgeNormalQuestionService {
    /**
     * 评判一般填空题
     */
    @Override
    public void judgeNormalFillQuestion(QuestionEntity questionEntity, UserSubmitEntity userSubmitEntity) {
        int result = 0;
        UserReplyListDTO userReplyListDTO = JSON.parseObject(userSubmitEntity.getUserAnswer(), UserReplyListDTO.class);
        Criterion questionId = Restrictions.eq("questionId", questionEntity.getQuestionId());
        List<QuestionAnswerEntity> questionAnswerEntityList = questionAnswerDao.listByCriterion(questionId);
        for (QuestionAnswerEntity questionAnswerEntity : questionAnswerEntityList) {
            String userReply = findUserReplyByNumber(userReplyListDTO, questionAnswerEntity.getSequenceNumber());
            QuestionAnswerContentListDTO questionAnswerDTO = JSON.parseObject(questionAnswerEntity.getAnswerContent(), QuestionAnswerContentListDTO.class);
            if (checkNormalFillUserReply(questionAnswerDTO.getQuestionAnswerList(), userReply)) {
                //用户是正确答案
                result = result + questionAnswerEntity.getSocre();
            }
        }
        userSubmitEntity.setResult(result);
        userSubmitEntity.setStatus(USER_SUBMIT_STATUS_RATED);
        userSubmitDao.update(userSubmitEntity);

    }

    private boolean checkNormalFillUserReply(List<AnswerDTO> answerList, String userReply) {
        if (StringUtils.isEmpty(userReply)) {
            return false;
        }
        for (AnswerDTO answerDTO : answerList) {
            String answerContent = answerDTO.getAnswer();
            answerContent = StringUtils.deleteWhitespace(answerContent);
            userReply = StringUtils.deleteWhitespace(userReply);
            if (StringUtils.equalsIgnoreCase(answerContent, userReply)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 在用户回答中找出与序号相对应的回答
     *
     * @param userReplyListDTO 用户回答
     * @param sequenceNumber   序号
     * @return 用户的一个答案
     */
    private String findUserReplyByNumber(UserReplyListDTO userReplyListDTO, Integer sequenceNumber) {
        String userReply = null;
        List<AnswerDTO> userReplyList = userReplyListDTO.getUserReplyList();
        for (AnswerDTO answerDTO : userReplyList) {
            if (answerDTO.getNumber().equals(sequenceNumber)) {
                userReply = answerDTO.getAnswer();
                break;
            }
        }
        return userReply;
    }

    /**
     * 单选
     */
    @Override
    public void judgeChoiceQuestion(QuestionEntity questionEntity, UserSubmitEntity userSubmitEntity) {
        int result = 0;
        String userAnswer = userSubmitEntity.getUserAnswer();
        Criterion questionId = Restrictions.eq("questionId", questionEntity.getQuestionId());
        Criterion sequenceNumber = Restrictions.eq("sequenceNumber", 1);
        QuestionAnswerEntity questionAnswerEntity = questionAnswerDao.getByCriterion(questionId, sequenceNumber);
        String answerContent = questionAnswerEntity.getAnswerContent();
        if (userAnswer.endsWith(answerContent)) {
            result = questionAnswerEntity.getSocre();
        }
        userSubmitEntity.setResult(result);
        userSubmitEntity.setStatus(USER_SUBMIT_STATUS_RATED);
        userSubmitDao.update(userSubmitEntity);
    }

    /**
     * 评判判断题
     */
    @Override
    public void judgeJudgmentQuestion(QuestionEntity questionEntity, UserSubmitEntity userSubmitEntity) {
        // 因为都是直接对比.
        this.judgeChoiceQuestion(questionEntity, userSubmitEntity);
    }

    @Autowired
    private UserSubmitDao userSubmitDao;
    @Autowired
    private QuestionAnswerDao questionAnswerDao;
    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(JudgeNormalQuestionServiceImpl.class);

}
