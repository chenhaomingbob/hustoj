package com.zjgsu.entity.hustoj;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author chm 神魔法
 * @date 19-6-19 上午11:02
 */
@Entity
@Table(name = "problem_map", schema = "jol", catalog = "")
public class ProblemMapEntity {
    private Integer problemMapId;
    private Integer problemId;
    private Integer questionId;
    private Timestamp createdTime;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "problem_map_id")
    public Integer getProblemMapId() {
        return problemMapId;
    }

    public void setProblemMapId(Integer problemMapId) {
        this.problemMapId = problemMapId;
    }

    @Basic
    @Column(name = "problem_id")
    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    @Basic
    @Column(name = "question_id")
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
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
