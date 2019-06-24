package com.zjgsu.service.common.impl;

import com.alibaba.fastjson.JSONObject;
import com.zjgsu.dao.zjgsu.UserSubmitDao;
import com.zjgsu.dto.UserScoreDTO;
import com.zjgsu.entity.zjgsu.UserSubmitEntity;
import com.zjgsu.service.common.TestService;
import com.zjgsu.service.zjgsu.GetUserReplyScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.zjgsu.util.JudgeCenterConstant.USER_SUBMIT_STATUS_INITIAL;

/**
 * @author chm 神魔法
 * @date 19-6-24 下午7:57
 */
@Service
@Transactional
public class TestServiceImpl implements TestService {
    @Override
    public int UserSubmit(JSONObject userSubmitJsonObject) {
        UserSubmitEntity userSubmitEntity = new UserSubmitEntity();
        userSubmitEntity.setUserId(userSubmitJsonObject.getInteger("userId"));
        userSubmitEntity.setUserAnswer(userSubmitJsonObject.getString("userAnswer"));
        userSubmitEntity.setQuestionId(userSubmitJsonObject.getInteger("questionId"));
        userSubmitEntity.setLanguage(userSubmitJsonObject.getInteger("language"));
        userSubmitEntity.setSourceCode(userSubmitJsonObject.getString("sourceCode"));
        userSubmitEntity.setStatus(USER_SUBMIT_STATUS_INITIAL);
        return userSubmitDao.save(userSubmitEntity);
    }
    @Override
    public UserScoreDTO getSubmitInfo(int submitId) {
        return getUserReplyScoreService.getScoreByReplyId(submitId);



    }
    @Autowired
    private UserSubmitDao userSubmitDao;
    @Autowired
    private GetUserReplyScoreService getUserReplyScoreService;
}
