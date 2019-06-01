package com.zjgsu.service.hustoj.impl;

import com.zjgsu.dao.hustoj.SolutionDao;
import com.zjgsu.dao.hustoj.SourceCodeDao;
import com.zjgsu.dao.hustoj.SourceCodeUserDao;
import com.zjgsu.entity.hustoj.SolutionEntity;
import com.zjgsu.service.hustoj.SolutionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chm 神魔法
 * @date 2019/6/1 11:41
 */
@Service
public class SolutionServiceImpl implements SolutionService {
    /**
     * 将zjgsu中的编程题提交到hustoj的数据库中
     */
    @Override
    public void submitUserSolution() {
        System.out.println(sourceCodeDao);
    }

    @Autowired
    private SourceCodeDao sourceCodeDao;
    @Autowired
    private SourceCodeUserDao sourceCodeUserDao;
    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(SolutionServiceImpl.class);
}
