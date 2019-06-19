package com.zjgsu.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author chm 神魔法
 * @date 19-6-19 下午2:01
 */
public class UserReplyListDTO implements Serializable {
    List<AnswerDTO> userReplyList;

    public List<AnswerDTO> getUserReplyList() {
        return userReplyList;
    }

    public void setUserReplyList(List<AnswerDTO> userReplyList) {
        this.userReplyList = userReplyList;
    }
}
