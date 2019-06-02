package com.zjgsu.entity.hustoj;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author chm 神魔法
 * @date 2019/5/31 21:10
 */
@Entity
@Table(name = "solution_test_points", schema = "jol", catalog = "")
public class SolutionTestPointsEntity {
    private Integer   testPointRecordId;
    private Integer solutionId;
    private String testPointInputFile;
    private String testPointOutputFile;
    private String testPointResult;
    private Integer testPointUseTime;
    private Integer testPointUseMemory;
    private Timestamp testPointJudgeTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "test_point_record_id")
    public Integer   getTestPointRecordId() {
        return testPointRecordId;
    }

    public void setTestPointRecordId(Integer   testPointRecordId) {
        this.testPointRecordId = testPointRecordId;
    }

    @Basic
    @Column(name = "solution_id")
    public Integer getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer solutionId) {
        this.solutionId = solutionId;
    }

    @Basic
    @Column(name = "test_point_input_file")
    public String getTestPointInputFile() {
        return testPointInputFile;
    }

    public void setTestPointInputFile(String testPointInputFile) {
        this.testPointInputFile = testPointInputFile;
    }

    @Basic
    @Column(name = "test_point_output_file")
    public String getTestPointOutputFile() {
        return testPointOutputFile;
    }

    public void setTestPointOutputFile(String testPointOutputFile) {
        this.testPointOutputFile = testPointOutputFile;
    }

    @Basic
    @Column(name = "test_point_result")
    public String getTestPointResult() {
        return testPointResult;
    }

    public void setTestPointResult(String testPointResult) {
        this.testPointResult = testPointResult;
    }

    @Basic
    @Column(name = "test_point_use_time")
    public Integer getTestPointUseTime() {
        return testPointUseTime;
    }

    public void setTestPointUseTime(Integer testPointUseTime) {
        this.testPointUseTime = testPointUseTime;
    }

    @Basic
    @Column(name = "test_point_use_memory")
    public Integer getTestPointUseMemory() {
        return testPointUseMemory;
    }

    public void setTestPointUseMemory(Integer testPointUseMemory) {
        this.testPointUseMemory = testPointUseMemory;
    }

    @Basic
    @Column(name = "test_point_judge_time")
    public Timestamp getTestPointJudgeTime() {
        return testPointJudgeTime;
    }

    public void setTestPointJudgeTime(Timestamp testPointJudgeTime) {
        this.testPointJudgeTime = testPointJudgeTime;
    }

}
