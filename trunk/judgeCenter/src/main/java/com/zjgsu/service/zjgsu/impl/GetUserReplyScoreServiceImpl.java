package com.zjgsu.service.zjgsu.impl;

import com.zjgsu.dao.zjgsu.QuestionDao;
import com.zjgsu.dao.zjgsu.UserSubmitDao;
import com.zjgsu.dto.UserScoreDTO;
import com.zjgsu.entity.zjgsu.QuestionEntity;
import com.zjgsu.entity.zjgsu.UserSubmitEntity;
import com.zjgsu.service.zjgsu.GetUserReplyScoreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.zjgsu.util.JudgeCenterConstant.*;

/**
 * 获取用户得分
 *
 * @author chm 神魔法
 * @date 2019/6/4 14:01
 */
//TODO
@Service
public class GetUserReplyScoreServiceImpl implements GetUserReplyScoreService {

    /**
     * 根据提交的id获取得分
     *
     * @param submitId
     */
    public UserScoreDTO getScoreByReplyId(int submitId) {
        Order order = Order.asc("");
        userSubmitDao.listByCriterion();
        UserSubmitEntity userSubmitEntity = userSubmitDao.getByCriterion(Restrictions.eq("submitId", submitId));
        QuestionEntity questionEntity = questionDao.getByCriterion(Restrictions.eq("questionId", userSubmitEntity.getQuestionId()));
        Integer type = questionEntity.getType();
        UserScoreDTO userScoreDTO = new UserScoreDTO();
        if (type.equals(QUESTION_TYPE_NORMAL_FILL) || type.equals(QUESTION_TYPE_CHOICE) || type.equals(QUESTION_TYPE_JUDGMENT)) {
            //不是编程题
            userScoreDTO.setScore(userSubmitEntity.getResult());
            userScoreDTO.setCreatedTime(userSubmitEntity.getCreatedTime());
            userScoreDTO.setStatus(userSubmitEntity.getStatus());
        }else {
            //是编程题
        }

        return userScoreDTO;
    }

    /**
     * 获取程序填空题得分
     *
     * @return score
     */
    private int getProgramFillScore() {
        return 0;
    }

    /**
     * 获取程序改错题得分
     *
     * @return score
     */
    private int getProgramCorrectionScore() {
        return 0;
    }

    /**
     * 获取编程题得分
     *
     * @return score
     */
    private int getProgramScore() {
        return 0;
    }

    @Autowired
    private UserSubmitDao userSubmitDao;
    @Autowired
    private QuestionDao questionDao;
    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(GetUserReplyScoreServiceImpl.class);
}
