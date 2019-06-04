package com.zjgsu.service.zjgsu;

/**
 * @author chm 神魔法
 * @date 2019/6/2 13:59
 */
public interface JudgeNormalQuestionService {
    boolean judgeNormalFillQuestion(String userAnswer, String[] standardAnswers);

    boolean judgeChoiceQuestion(int userAnswer, int standardAnswer);

    boolean judgeJudgmentQuestion(String userAnswer, String standardAnswer);
}
