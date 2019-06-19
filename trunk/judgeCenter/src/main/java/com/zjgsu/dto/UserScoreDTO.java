package com.zjgsu.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author chm 神魔法
 * @date 19-6-19 下午3:35
 */
public class UserScoreDTO implements Serializable {
    private Integer userId;
    private Integer submitId;
    private Integer score;
    private Timestamp createdTime;
    private Integer status;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSubmitId() {
        return submitId;
    }

    public void setSubmitId(Integer submitId) {
        this.submitId = submitId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
