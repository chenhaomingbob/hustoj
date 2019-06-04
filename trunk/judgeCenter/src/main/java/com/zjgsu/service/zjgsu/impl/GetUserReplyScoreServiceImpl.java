package com.zjgsu.service.zjgsu.impl;

import com.zjgsu.service.zjgsu.GetUserReplyScoreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;

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
     * @param replyId
     */
    public void getScoreByReplyId(int replyId) {

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


    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(GetUserReplyScoreServiceImpl.class);
}
