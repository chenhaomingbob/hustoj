package com.zjgsu.dto;

import java.io.Serializable;

/**
 * @author chm 神魔法
 * @date 19-6-19 下午2:05
 */
public class AnswerDTO implements Serializable{
    private String answer;
    private Integer number;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
