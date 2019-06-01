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
    private int testPointRecordId;
    private Integer solutionId;
    private String testPointInputFile;
    private String testPointOutputFile;
    private String testPointResult;
    private Integer testPointUseTime;
    private Integer testPointUseMemory;
    private Timestamp testPointJudgeTime;

    @Id
    @Column(name = "test_point_record_id")
    public int getTestPointRecordId() {
        return testPointRecordId;
    }

    public void setTestPointRecordId(int testPointRecordId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SolutionTestPointsEntity that = (SolutionTestPointsEntity) o;

        if (testPointRecordId != that.testPointRecordId) return false;
        if (solutionId != null ? !solutionId.equals(that.solutionId) : that.solutionId != null) return false;
        if (testPointInputFile != null ? !testPointInputFile.equals(that.testPointInputFile) : that.testPointInputFile != null)
            return false;
        if (testPointOutputFile != null ? !testPointOutputFile.equals(that.testPointOutputFile) : that.testPointOutputFile != null)
            return false;
        if (testPointResult != null ? !testPointResult.equals(that.testPointResult) : that.testPointResult != null)
            return false;
        if (testPointUseTime != null ? !testPointUseTime.equals(that.testPointUseTime) : that.testPointUseTime != null)
            return false;
        if (testPointUseMemory != null ? !testPointUseMemory.equals(that.testPointUseMemory) : that.testPointUseMemory != null)
            return false;
        if (testPointJudgeTime != null ? !testPointJudgeTime.equals(that.testPointJudgeTime) : that.testPointJudgeTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = testPointRecordId;
        result = 31 * result + (solutionId != null ? solutionId.hashCode() : 0);
        result = 31 * result + (testPointInputFile != null ? testPointInputFile.hashCode() : 0);
        result = 31 * result + (testPointOutputFile != null ? testPointOutputFile.hashCode() : 0);
        result = 31 * result + (testPointResult != null ? testPointResult.hashCode() : 0);
        result = 31 * result + (testPointUseTime != null ? testPointUseTime.hashCode() : 0);
        result = 31 * result + (testPointUseMemory != null ? testPointUseMemory.hashCode() : 0);
        result = 31 * result + (testPointJudgeTime != null ? testPointJudgeTime.hashCode() : 0);
        return result;
    }
}
