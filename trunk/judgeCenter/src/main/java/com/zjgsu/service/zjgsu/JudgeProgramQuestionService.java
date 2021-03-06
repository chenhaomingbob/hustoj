package com.zjgsu.service.zjgsu;

import com.zjgsu.entity.zjgsu.QuestionEntity;
import com.zjgsu.entity.zjgsu.UserSubmitEntity;

/**
 * @author chm 神魔法
 * @date 2019/6/2 13:59
 */
public interface JudgeProgramQuestionService {
    void judgeProgramFillQuestion(QuestionEntity questionEntity, UserSubmitEntity userSubmitEntity);

    void judgeCorrectionQuestion(QuestionEntity questionEntity, UserSubmitEntity userSubmitEntity);

    void judgeProgramQuestion(QuestionEntity questionEntity, UserSubmitEntity userSubmitEntity);
}
