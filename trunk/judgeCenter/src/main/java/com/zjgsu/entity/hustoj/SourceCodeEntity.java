package com.zjgsu.entity.hustoj;

import javax.persistence.*;

/**
 * @author chm 神魔法
 * @date 2019/5/31 21:10
 */
@Entity
@Table(name = "source_code", schema = "jol", catalog = "")
public class SourceCodeEntity {
    private Integer   solutionId;
    private String source;

    @Id
    @Column(name = "solution_id")
    public Integer   getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer   solutionId) {
        this.solutionId = solutionId;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
