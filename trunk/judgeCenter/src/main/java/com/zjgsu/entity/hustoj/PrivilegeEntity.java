package com.zjgsu.entity.hustoj;

import javax.persistence.*;

/**
 * @author chm 神魔法
 * @date 2019/5/31 21:10
 */
@Entity
@Table(name = "privilege", schema = "jol", catalog = "")
public class PrivilegeEntity {
    private String userId;
    private String rightstr;
    private String defunct;

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "rightstr")
    public String getRightstr() {
        return rightstr;
    }

    public void setRightstr(String rightstr) {
        this.rightstr = rightstr;
    }
                                
    @Basic
    @Column(name = "defunct")
    public String getDefunct() {
        return defunct;
    }

    public void setDefunct(String defunct) {
        this.defunct = defunct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivilegeEntity that = (PrivilegeEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (rightstr != null ? !rightstr.equals(that.rightstr) : that.rightstr != null) return false;
        if (defunct != null ? !defunct.equals(that.defunct) : that.defunct != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (rightstr != null ? rightstr.hashCode() : 0);
        result = 31 * result + (defunct != null ? defunct.hashCode() : 0);
        return result;
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
