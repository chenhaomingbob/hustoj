package com.zjgsu.entity.zjgsu;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author chm 神魔法
 * @date 19-6-19 上午9:59
 */
@Entity
@Table(name = "exception", schema = "zjgsu", catalog = "")
public class ExceptionEntity {
    private Integer errorId;
    private String event;
    private String description;
    private Timestamp createdTime;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "error_id")
    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    @Basic
    @Column(name = "event")
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
