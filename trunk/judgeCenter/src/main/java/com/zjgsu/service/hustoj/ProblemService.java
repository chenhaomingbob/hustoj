package com.zjgsu.service.hustoj;

/**
 * @author chm 神魔法
 * @date 2019/6/4 12:30
 */
public interface ProblemService {
    void addProblemToHustoj(int problemId, String title, int time_lime, int memory_limit);

    void writeTestPointsFileToJudgeDisk(int problemId);
}
