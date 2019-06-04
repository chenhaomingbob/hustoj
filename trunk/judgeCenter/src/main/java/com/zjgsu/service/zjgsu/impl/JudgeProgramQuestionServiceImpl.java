package com.zjgsu.service.zjgsu.impl;


import com.zjgsu.service.hustoj.SolutionService;
import com.zjgsu.service.zjgsu.JudgeProgramQuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void judgeProgramFillQuestion(int problemId) {
        this.judgeProgramQuestion(problemId);
    }

    /**
     * 程序改错题
     * // http://10.21.11.73/#/problem/821
     * // http://10.21.11.73/#/problem/1282
     */
    @Override
    public void judgeCorrectionQuestion(int problemId) {
        this.judgeProgramQuestion(problemId);
    }

    /**
     * 编程题
     * 往hustoj的数据库中扔一个solution即可
     */
    @Override
    public void judgeProgramQuestion(int problemId) {
        String userId = "admin";
        int language=0;
        String sourceCode = "";
        String ip = "192.168.1.1";
        solutionService.submitUserSolution(problemId, userId, ip, language, sourceCode);
    }

    @Autowired
    private SolutionService solutionService;

    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(JudgeProgramQuestionServiceImpl.class);
}
