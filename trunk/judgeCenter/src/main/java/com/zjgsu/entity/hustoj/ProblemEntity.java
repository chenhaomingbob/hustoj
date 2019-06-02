package com.zjgsu.entity.hustoj;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author chm 神魔法
 * @date 2019/5/31 21:10
 */
@Entity
@Table(name = "problem", schema = "jol", catalog = "")
public class ProblemEntity {
    private Integer   problemId;
    private String title;
    private String description;
    private String input;
    private String output;
    private String sampleInput;
    private String sampleOutput;
    private String spj;
    private String hint;
    private String source;
    private Timestamp inDate;
    private Integer   timeLimit;
    private Integer   memoryLimit;
    private String defunct;
    private Integer accepted;
    private Integer submit;
    private Integer solved;

    @Id
    @Column(name = "problem_id")
    public Integer   getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer   problemId) {
        this.problemId = problemId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "input")
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Basic
    @Column(name = "output")
    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Basic
    @Column(name = "sample_input")
    public String getSampleInput() {
        return sampleInput;
    }

    public void setSampleInput(String sampleInput) {
        this.sampleInput = sampleInput;
    }

    @Basic
    @Column(name = "sample_output")
    public String getSampleOutput() {
        return sampleOutput;
    }

    public void setSampleOutput(String sampleOutput) {
        this.sampleOutput = sampleOutput;
    }

    @Basic
    @Column(name = "spj")
    public String getSpj() {
        return spj;
    }

    public void setSpj(String spj) {
        this.spj = spj;
    }

    @Basic
    @Column(name = "hint")
    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
    @Column(name = "time_limit")
    public Integer   getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer   timeLimit) {
        this.timeLimit = timeLimit;
    }

    @Basic
    @Column(name = "memory_limit")
    public Integer   getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(Integer   memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    @Basic
    @Column(name = "defunct")
    public String getDefunct() {
        return defunct;
    }

    public void setDefunct(String defunct) {
        this.defunct = defunct;
    }

    @Basic
    @Column(name = "accepted")
    public Integer getAccepted() {
        return accepted;
    }

    public void setAccepted(Integer accepted) {
        this.accepted = accepted;
    }

    @Basic
    @Column(name = "submit")
    public Integer getSubmit() {
        return submit;
    }

    public void setSubmit(Integer submit) {
        this.submit = submit;
    }

    @Basic
    @Column(name = "solved")
    public Integer getSolved() {
        return solved;
    }

    public void setSolved(Integer solved) {
        this.solved = solved;
    }

}
