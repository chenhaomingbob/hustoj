package com.zjgsu.service.hustoj;

/**
 * @author chm 神魔法
 * @date 2019/6/1 11:41
 */
public interface SolutionService {

    void submitUserSolution(int problemId, String userId, String ip,int languageId, String sourceCode);

    void writeTestPointsFileToJudgeDisk(int problemId);
}
