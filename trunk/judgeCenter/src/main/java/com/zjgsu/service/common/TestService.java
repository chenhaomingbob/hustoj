package com.zjgsu.service.common;

import com.alibaba.fastjson.JSONObject;
import com.zjgsu.dao.zjgsu.UserSubmitDao;
import com.zjgsu.dto.UserScoreDTO;
import com.zjgsu.entity.zjgsu.UserSubmitEntity;
import com.zjgsu.service.zjgsu.GetUserReplyScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.zjgsu.util.JudgeCenterConstant.USER_SUBMIT_STATUS_INITIAL;

/**
 * @author chm 神魔法
 * @date 19-6-24 上午10:21
 */

@Service
public interface TestService {

    int UserSubmit(JSONObject userSubmitJsonObject);

    UserScoreDTO getSubmitInfo(int submitId);
}
