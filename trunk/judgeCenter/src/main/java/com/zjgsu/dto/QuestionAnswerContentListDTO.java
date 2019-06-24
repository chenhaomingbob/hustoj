package com.zjgsu.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author chm 神魔法
 * @date 19-6-19 下午2:23
 */
public class QuestionAnswerContentListDTO implements Serializable {
    private static final long serialVersionUID = -4360815736170230300L;
    List<AnswerDTO> questionAnswerList;

    public List<AnswerDTO> getQuestionAnswerList() {
        return questionAnswerList;
    }

    public void setQuestionAnswerList(List<AnswerDTO> questionAnswerList) {
        this.questionAnswerList = questionAnswerList;
    }
}
