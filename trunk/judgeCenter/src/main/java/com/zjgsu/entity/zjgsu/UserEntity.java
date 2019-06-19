package com.zjgsu.entity.zjgsu;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author chm 神魔法
 * @date 19-6-19 上午9:58
 */
@Entity
@Table(name = "user", schema = "zjgsu", catalog = "")
public class UserEntity {
    private Integer userId;
    private Timestamp createdTime;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "created_time")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
