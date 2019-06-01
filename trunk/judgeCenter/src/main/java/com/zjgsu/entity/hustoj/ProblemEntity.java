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
    private int problemId;
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
    private int timeLimit;
    private int memoryLimit;
    private String defunct;
    private Integer accepted;
    private Integer submit;
    private Integer solved;

    @Id
    @Column(name = "problem_id")
    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
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
    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    @Basic
    @Column(name = "memory_limit")
    public int getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(int memoryLimit) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProblemEntity that = (ProblemEntity) o;

        if (problemId != that.problemId) return false;
        if (timeLimit != that.timeLimit) return false;
        if (memoryLimit != that.memoryLimit) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (input != null ? !input.equals(that.input) : that.input != null) return false;
        if (output != null ? !output.equals(that.output) : that.output != null) return false;
        if (sampleInput != null ? !sampleInput.equals(that.sampleInput) : that.sampleInput != null) return false;
        if (sampleOutput != null ? !sampleOutput.equals(that.sampleOutput) : that.sampleOutput != null) return false;
        if (spj != null ? !spj.equals(that.spj) : that.spj != null) return false;
        if (hint != null ? !hint.equals(that.hint) : that.hint != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (inDate != null ? !inDate.equals(that.inDate) : that.inDate != null) return false;
        if (defunct != null ? !defunct.equals(that.defunct) : that.defunct != null) return false;
        if (accepted != null ? !accepted.equals(that.accepted) : that.accepted != null) return false;
        if (submit != null ? !submit.equals(that.submit) : that.submit != null) return false;
        if (solved != null ? !solved.equals(that.solved) : that.solved != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = problemId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (input != null ? input.hashCode() : 0);
        result = 31 * result + (output != null ? output.hashCode() : 0);
        result = 31 * result + (sampleInput != null ? sampleInput.hashCode() : 0);
        result = 31 * result + (sampleOutput != null ? sampleOutput.hashCode() : 0);
        result = 31 * result + (spj != null ? spj.hashCode() : 0);
        result = 31 * result + (hint != null ? hint.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (inDate != null ? inDate.hashCode() : 0);
        result = 31 * result + timeLimit;
        result = 31 * result + memoryLimit;
        result = 31 * result + (defunct != null ? defunct.hashCode() : 0);
        result = 31 * result + (accepted != null ? accepted.hashCode() : 0);
        result = 31 * result + (submit != null ? submit.hashCode() : 0);
        result = 31 * result + (solved != null ? solved.hashCode() : 0);
        return result;
    }
}
