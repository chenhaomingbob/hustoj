package com.zjgsu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author chm 神魔法
 * @date 2019/5/31 21:10
 */
@Entity
@Table(name = "users", schema = "jol", catalog = "")
public class UsersEntity {
    private String userId;
    private String email;
    private Integer submit;
    private Integer solved;
    private String defunct;
    private String ip;
    private Timestamp accesstime;
    private int volume;
    private int language;
    private String password;
    private Timestamp regTime;
    private String nick;
    private String school;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Basic
    @Column(name = "defunct")
    public String getDefunct() {
        return defunct;
    }

    public void setDefunct(String defunct) {
        this.defunct = defunct;
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
    @Column(name = "accesstime")
    public Timestamp getAccesstime() {
        return accesstime;
    }

    public void setAccesstime(Timestamp accesstime) {
        this.accesstime = accesstime;
    }

    @Basic
    @Column(name = "volume")
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "reg_time")
    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    @Basic
    @Column(name = "nick")
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Basic
    @Column(name = "school")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (volume != that.volume) return false;
        if (language != that.language) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (submit != null ? !submit.equals(that.submit) : that.submit != null) return false;
        if (solved != null ? !solved.equals(that.solved) : that.solved != null) return false;
        if (defunct != null ? !defunct.equals(that.defunct) : that.defunct != null) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (accesstime != null ? !accesstime.equals(that.accesstime) : that.accesstime != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (regTime != null ? !regTime.equals(that.regTime) : that.regTime != null) return false;
        if (nick != null ? !nick.equals(that.nick) : that.nick != null) return false;
        if (school != null ? !school.equals(that.school) : that.school != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (submit != null ? submit.hashCode() : 0);
        result = 31 * result + (solved != null ? solved.hashCode() : 0);
        result = 31 * result + (defunct != null ? defunct.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (accesstime != null ? accesstime.hashCode() : 0);
        result = 31 * result + volume;
        result = 31 * result + language;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (regTime != null ? regTime.hashCode() : 0);
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        return result;
    }
}
