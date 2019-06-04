package com.zjgsu.service.hustoj.impl;

import com.zjgsu.dao.hustoj.SolutionDao;
import com.zjgsu.dao.hustoj.SourceCodeDao;
import com.zjgsu.dao.hustoj.SourceCodeUserDao;
import com.zjgsu.dao.zjgsu.TestPointDao;
import com.zjgsu.entity.hustoj.SolutionEntity;
import com.zjgsu.entity.hustoj.SourceCodeEntity;
import com.zjgsu.entity.hustoj.SourceCodeUserEntity;
import com.zjgsu.entity.zjgsu.TestPointEntity;
import com.zjgsu.service.hustoj.SolutionService;
import com.zjgsu.util.JudgeCenterConstant;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.List;


/**
 * @author chm 神魔法
 * @date 2019/6/1 11:41
 */
@Service
public class SolutionServiceImpl implements SolutionService {
    /**
     * 来自hustoj core judge_client 关于result
     * #define OJ_WT0 0
     * #define OJ_WT1 1
     * // Compiling
     * #define OJ_CI 2
     * // Running & Judging
     * #define OJ_RI 3
     * // Accepted
     * #define OJ_AC 4
     * // Presentation Error
     * #define OJ_PE 5
     * // Wrong Answer
     * #define OJ_WA 6
     * // Time Limit Exceeded
     * #define OJ_TL 7
     * // Memory Limit Exceeded
     * #define OJ_ML 8
     * // Output Limit Exceeded
     * #define OJ_OL 9
     * // 运行出错
     * #define OJ_RE 10
     * // 编译出错
     * #define OJ_CE 11
     * #define OJ_CO 12
     * #define OJ_TR 13
     *
     * 关于language
     * static char lang_ext[19][8] = {"c", "cc", "pas", "java", "rb", "sh", "py",
     * 							   "php", "pl", "cs", "m", "bas", "scm", "c", "cc", "lua", "js", "go", "sql"};
     */
    /**
     * 将zjgsu中的编程题提交到hustoj的数据库中
     */
    @Override
    public void submitUserSolution(int problemId, String userId, String ip, int languageId, String sourceCode) {
        SolutionEntity solutionEntity = new SolutionEntity();

        solutionEntity.setProblemId(problemId);
        solutionEntity.setUserId(userId);
        solutionEntity.setLanguage(languageId);
        solutionEntity.setIp(ip);
        solutionEntity.setInDate(new Timestamp(System.currentTimeMillis()));
        solutionEntity.setCodeLength(sourceCode.length());
        // 14 是一个找不到solution状态定义的数
        solutionEntity.setResult((short) 14);
        //---- 以下个属性，因为数据库的表设计的原因，给其默认值。hustoj的裁判机会自动补全上这些数据
        solutionEntity.setTime(0);
        solutionEntity.setMemory(0);
        solutionEntity.setValid((byte) 0);
        solutionEntity.setNum((byte) 0);
        solutionEntity.setLintError(0);
        solutionEntity.setJudger("");
        solutionEntity.setPassRate(new BigDecimal(0));

        int solutionId = Integer.valueOf(solutionDao.save(solutionEntity));
        SourceCodeEntity sourceCodeEntity = new SourceCodeEntity();
        sourceCodeEntity.setSolutionId(solutionId);
        sourceCodeEntity.setSource(sourceCode);
        sourceCodeDao.save(sourceCodeEntity);

        SourceCodeUserEntity sourceCodeUserEntity = new SourceCodeUserEntity();
        sourceCodeUserEntity.setSolutionId(solutionId);
        sourceCodeUserEntity.setSource(sourceCode);
        sourceCodeUserDao.save(sourceCodeUserEntity);
        // result 状态设置为0 ，裁判机会轮询数据库获取到。
        solutionEntity.setResult((short) 0);
        solutionDao.update(solutionEntity);
        Logger.info("SolutionId:{} 已成功保存至数据库", solutionId);
    }






    @Autowired
    private TestPointDao testPointDao;
    @Autowired
    private SourceCodeDao sourceCodeDao;
    @Autowired
    private SourceCodeUserDao sourceCodeUserDao;
    @Autowired
    private SolutionDao solutionDao;
    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(SolutionServiceImpl.class);
}
