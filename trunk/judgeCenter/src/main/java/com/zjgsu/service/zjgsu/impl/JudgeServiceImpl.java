package com.zjgsu.service.zjgsu.impl;

import com.zjgsu.service.zjgsu.JudgeService;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    public void judgeQuestion(int submissionId) {

    }


    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(JudgeServiceImpl.class);
}
