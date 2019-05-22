package com.nuc.exam.entity;

public class Judgequestion {

    private Integer questionId;

    private String questionName;

    private String questionContext;

    private boolean answear;

    private Integer score;

    private String questionChapter;

    private Integer level;

    @Override
    public String toString() {
        return "Judgequestion{" +
                "questionId=" + questionId +
                ", questionName='" + questionName + '\'' +
                ", questionContext='" + questionContext + '\'' +
                ", answear='" + answear + '\'' +
                ", score=" + score +
                ", questionChapter='" + questionChapter + '\'' +
                ", level=" + level +
                '}';
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionContext() {
        return questionContext;
    }

    public void setQuestionContext(String questionContext) {
        this.questionContext = questionContext;
    }


    public boolean isAnswear() {
        return answear;
    }

    public void setAnswear(boolean answear) {
        this.answear = answear;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getQuestionChapter() {
        return questionChapter;
    }

    public void setQuestionChapter(String questionChapter) {
        this.questionChapter = questionChapter;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
