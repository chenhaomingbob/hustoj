package com.zjgsu.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author chm 神魔法
 * @date 2019/5/31 21:10
 */
@Entity
@Table(name = "solution", schema = "jol", catalog = "")
public class SolutionEntity {
    private int solutionId;
    private int problemId;
    private String userId;
    private int time;
    private int memory;
    private Timestamp inDate;
    private short result;
    private int language;
    private String ip;
    private Integer contestId;
    private byte valid;
    private byte num;
    private int codeLength;
    private Timestamp judgetime;
    private BigDecimal passRate;
    private int lintError;
    private String judger;

    @Id
    @Column(name = "solution_id")
    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    @Basic
    @Column(name = "problem_id")
    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "time")
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Basic
    @Column(name = "memory")
    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Basic
    @Column(name = "in_date")
    public Timestamp getInDate() {
        return inDate;
    }

    public void setInDate(Timestamp inDate) {
        this.inDate = inDate;
    }

    @Basic
    @Column(name = "result")
    public short getResult() {
        return result;
    }

    public void setResult(short result) {
        this.result = result;
    }

    @Basic
    @Column(name = "language")
    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    @Basic
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "contest_id")
    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    @Basic
    @Column(name = "valid")
    public byte getValid() {
        return valid;
    }

    public void setValid(byte valid) {
        this.valid = valid;
    }

    @Basic
    @Column(name = "num")
    public byte getNum() {
        return num;
    }

    public void setNum(byte num) {
        this.num = num;
    }

    @Basic
    @Column(name = "code_length")
    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    @Basic
    @Column(name = "judgetime")
    public Timestamp getJudgetime() {
        return judgetime;
    }

    public void setJudgetime(Timestamp judgetime) {
        this.judgetime = judgetime;
    }

    @Basic
    @Column(name = "pass_rate")
    public BigDecimal getPassRate() {
        return passRate;
    }

    public void setPassRate(BigDecimal passRate) {
        this.passRate = passRate;
    }

    @Basic
    @Column(name = "lint_error")
    public int getLintError() {
        return lintError;
    }

    public void setLintError(int lintError) {
        this.lintError = lintError;
    }

    @Basic
    @Column(name = "judger")
    public String getJudger() {
        return judger;
    }

    public void setJudger(String judger) {
        this.judger = judger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SolutionEntity that = (SolutionEntity) o;

        if (solutionId != that.solutionId) return false;
        if (problemId != that.problemId) return false;
        if (time != that.time) return false;
        if (memory != that.memory) return false;
        if (result != that.result) return false;
        if (language != that.language) return false;
        if (valid != that.valid) return false;
        if (num != that.num) return false;
        if (codeLength != that.codeLength) return false;
        if (lintError != that.lintError) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (inDate != null ? !inDate.equals(that.inDate) : that.inDate != null) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (contestId != null ? !contestId.equals(that.contestId) : that.contestId != null) return false;
        if (judgetime != null ? !judgetime.equals(that.judgetime) : that.judgetime != null) return false;
        if (passRate != null ? !passRate.equals(that.passRate) : that.passRate != null) return false;
        if (judger != null ? !judger.equals(that.judger) : that.judger != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = solutionId;
        result1 = 31 * result1 + problemId;
        result1 = 31 * result1 + (userId != null ? userId.hashCode() : 0);
        result1 = 31 * result1 + time;
        result1 = 31 * result1 + memory;
        result1 = 31 * result1 + (inDate != null ? inDate.hashCode() : 0);
        result1 = 31 * result1 + (int) result;
        result1 = 31 * result1 + language;
        result1 = 31 * result1 + (ip != null ? ip.hashCode() : 0);
        result1 = 31 * result1 + (contestId != null ? contestId.hashCode() : 0);
        result1 = 31 * result1 + (int) valid;
        result1 = 31 * result1 + (int) num;
        result1 = 31 * result1 + codeLength;
        result1 = 31 * result1 + (judgetime != null ? judgetime.hashCode() : 0);
        result1 = 31 * result1 + (passRate != null ? passRate.hashCode() : 0);
        result1 = 31 * result1 + lintError;
        result1 = 31 * result1 + (judger != null ? judger.hashCode() : 0);
        return result1;
    }
}
