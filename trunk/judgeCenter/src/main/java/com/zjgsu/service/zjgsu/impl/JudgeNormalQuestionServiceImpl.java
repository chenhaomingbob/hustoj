package com.zjgsu.service.zjgsu.impl;

import com.zjgsu.service.zjgsu.JudgeNormalQuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

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
    public boolean judgeNormalFillQuestion(String userAnswer, String[] standardAnswers) {
        userAnswer = userAnswer.replaceAll(" ","");
        for (String standardAnswer : standardAnswers) {
            if (standardAnswer.replaceAll(" ", "").equals(userAnswer)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 按多选题来写
     */
    @Override
    public boolean judgeChoiceQuestion(int userAnswer, int standardAnswer) {
        if (userAnswer == standardAnswer) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 评判判断题
     */
    @Override
    public boolean judgeJudgmentQuestion(String userAnswer, String standardAnswer) {
        if (userAnswer.equalsIgnoreCase(standardAnswer)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(JudgeNormalQuestionServiceImpl.class);

}
