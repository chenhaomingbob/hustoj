package com.zjgsu.service.zjgsu;

/**
 * @author chm 神魔法
 * @date 2019/6/2 13:59
 */
public interface JudgeProgramQuestionService {
    void judgeProgramFillQuestion(int problemId);

    void judgeCorrectionQuestion(int problemId);

    void judgeProgramQuestion(int problemId);
}
