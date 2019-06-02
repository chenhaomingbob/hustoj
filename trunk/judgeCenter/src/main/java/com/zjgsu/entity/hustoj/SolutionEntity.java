package com.zjgsu.entity.hustoj;

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
    private Integer solutionId;
    private Integer problemId;
    private String userId;
    private Integer time;
    private Integer memory;
    /**
     * 录入事件
     */
    private Timestamp inDate;
    private short result;
    private Integer language;
    private String ip;
    private Integer contestId;
    private byte valid;
    private byte num;
    private Integer codeLength;
    private Timestamp judgetime;
    private BigDecimal passRate;
    private Integer lintError;
    private String judger;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "solution_id")
    public Integer getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer solutionId) {
        this.solutionId = solutionId;
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
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "time")
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Basic
    @Column(name = "memory")
    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
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
    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
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
    public Integer getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(Integer codeLength) {
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
    public Integer getLintError() {
        return lintError;
    }

    public void setLintError(Integer lintError) {
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
}
