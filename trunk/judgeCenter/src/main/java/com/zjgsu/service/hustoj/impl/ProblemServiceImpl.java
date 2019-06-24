package com.zjgsu.service.hustoj.impl;

import com.zjgsu.dao.hustoj.ProblemDao;
import com.zjgsu.dao.hustoj.ProblemMapDao;
import com.zjgsu.dao.zjgsu.QuestionTestPointDao;
import com.zjgsu.entity.hustoj.ProblemEntity;
import com.zjgsu.entity.hustoj.ProblemMapEntity;
import com.zjgsu.entity.zjgsu.QuestionTestPointEntity;
import com.zjgsu.service.common.CommonService;
import com.zjgsu.service.hustoj.ProblemService;
import com.zjgsu.service.hustoj.SolutionService;
import com.zjgsu.util.JudgeCenterConstant;
import com.zjgsu.util.JudgeExceptionConstant;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static com.zjgsu.util.JudgeCenterConstant.*;

/**
 * @author chm 神魔法
 * @date 2019/6/4 12:31
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    /**
     * 往hustoj的数据库中添加问题，并且在本地创建测试文件
     */
    @Override
    public void addProblemToHustoj(int problemId, String title, int time_lime, int memory_limit) {
        ProblemEntity problemEntity = new ProblemEntity();
        problemEntity.setProblemId(problemId);
        problemEntity.setTitle(title);
        problemEntity.setTimeLimit(time_lime);
        problemEntity.setMemoryLimit(memory_limit);
        problemDao.save(problemEntity);
        this.writeTestPointsFileToJudgeDisk(problemId);
    }

    /**
     * 在服务器上,创建测试点文件
     */
    @Override
    public void writeTestPointsFileToJudgeDisk(int questionId) {
        // question为zjgsu中问题的id,problem为hustoj中问题的id.
        ProblemMapEntity problemMapEntity = problemMapDao.getByCriterion(Restrictions.eq("questionId", questionId));
        Integer problemId = problemMapEntity.getProblemId();
        //1.根据problemId 查询
        Criterion statusCriterion = Restrictions.eq("status", DATABASE_RECORD_STATUS_RAW);
        Criterion problemCriterion = Restrictions.eq("problemId", problemId);
        List<QuestionTestPointEntity> testPointEntityList = questionTestPointDao.listByCriterion(statusCriterion, problemCriterion);
        //2.根据数据的测试点数据，保存文件
        String problemDataFileDirPath = judgeDataLocation + problemId;
        try {
            File testFile;
            for (int i = 0; i < testPointEntityList.size(); i++) {
                QuestionTestPointEntity testPointEntity = testPointEntityList.get(i);
                // input
                String inputFilePath = generateProblemTestFileName(problemDataFileDirPath, i, 1);
                testFile = new File(inputFilePath);
                // 覆盖写。并且如果该路径不存在，会直接都创建
                FileUtils.write(testFile, testPointEntity.getInputContent(), Charset.forName("UTF-8"));
                // output
                String outputFilePath = generateProblemTestFileName(problemDataFileDirPath, i, 2);
                testFile = new File(outputFilePath);
                FileUtils.write(testFile, testPointEntity.getOutputContent(), Charset.forName("UTF-8"));
            }
            Logger.info("创建测试文件,questionId:{},problemId:{},测试点个数:{}", questionId, problemId, testPointEntityList.size());
        } catch (IOException e) {
            commonService.saveErrorRecord(JudgeExceptionConstant.EVENT_HUSTOJ_CREATE_TEST_FILE, String.format("hostIp:{},hostName:{},ProblemId:{}", HOST_IP, HOST_NAME, problemId));
            Logger.error("创建测试文件时失败,questionId:{},problemId:{}", questionId, problemId, e);
        }
    }

    /**
     * 形成测试文件的名称
     *
     * @param number 顺序编号
     * @param type   类型， 输入(1)/输出(2)
     * @return 文件名
     */
    private String generateProblemTestFileName(String problemDataFileDirPath, int number, int type) {
        StringBuilder stringBuilder = new StringBuilder(problemDataFileDirPath).append(JudgeCenterConstant.FILE_SEPARATOR).append(JudgeCenterConstant.PROBLEM_Test_FILE_NAME_PREFIX).append(number);
        if (JudgeCenterConstant.TEST_FILE_INPUT_TYPE == type) {
            stringBuilder.append(JudgeCenterConstant.PROBLEM_INPUT_FILE_NAME_SUFFIX);
        } else if (JudgeCenterConstant.TEST_FILE_OUTPUT_TYPE == type) {
            stringBuilder.append(JudgeCenterConstant.PROBLEM_OUTPUT_FILE_NAME_SUFFIX);
        }

        return stringBuilder.toString();
    }


    @Autowired
    private ProblemMapDao problemMapDao;
    @Autowired
    private QuestionTestPointDao questionTestPointDao;
    @Autowired
    private ProblemDao problemDao;
    @Autowired
    private CommonService commonService;
    @Value("${hustoj.judge.data.location}")
    private String judgeDataLocation;
    /**
     * 日志记录器.
     */
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(ProblemServiceImpl.class);
}
