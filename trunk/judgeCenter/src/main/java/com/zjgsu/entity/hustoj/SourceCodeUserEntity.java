package com.zjgsu.entity.hustoj;

import javax.persistence.*;

/**
 * @author chm 神魔法
 * @date 2019/5/31 21:10
 */
@Entity
@Table(name = "source_code_user", schema = "jol", catalog = "")
public class SourceCodeUserEntity {
    private int solutionId;
    private String source;

    @Id
    @Column(name = "solution_id")
    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SourceCodeUserEntity that = (SourceCodeUserEntity) o;

        if (solutionId != that.solutionId) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = solutionId;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        return result;
    }
}
