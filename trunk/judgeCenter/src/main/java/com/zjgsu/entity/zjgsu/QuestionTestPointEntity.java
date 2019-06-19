package com.zjgsu.entity.zjgsu;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author chm 神魔法
 * @date 19-6-19 上午10:10
 */
@Entity
@Table(name = "question_test_point", schema = "zjgsu", catalog = "")
public class QuestionTestPointEntity {
    private Integer testPointId;
    private Integer questionId;
    private String inputContent;
    private String outputContent;
    private Integer score;
    private Timestamp createdTime;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "test_point_id")
    public Integer getTestPointId() {
        return testPointId;
    }

    public void setTestPointId(Integer testPonitId) {
        this.testPointId = testPonitId;
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
    @Column(name = "input_content")
    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    @Basic
    @Column(name = "output_content")
    public String getOutputContent() {
        return outputContent;
    }

    public void setOutputContent(String outputContent) {
        this.outputContent = outputContent;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
