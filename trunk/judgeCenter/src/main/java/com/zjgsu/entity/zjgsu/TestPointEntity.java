package com.zjgsu.entity.zjgsu;

import javax.persistence.*;

/**
 * @author chm 神魔法
 * @date 2019/6/2 11:16
 */
@Entity
@Table(name = "test_point", schema = "zjgsu", catalog = "")
public class TestPointEntity {
    private Integer testPonitId;
    private Integer problemId;
    private Byte status;
    private String inputContent;
    private String outputContent;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "test_ponit_id")
    public Integer getTestPonitId() {
        return testPonitId;
    }

    public void setTestPonitId(Integer testPonitId) {
        this.testPonitId = testPonitId;
    }

    public void setTestPonitId(int testPonitId) {
        this.testPonitId = testPonitId;
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
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
}
