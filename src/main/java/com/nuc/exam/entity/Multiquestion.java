package com.nuc.exam.entity;

public class Multiquestion {
    private Integer questionId;

    private String questionName;

    private String questionContext;

    private String answear;

    private String questionA;

    private String questionB;

    private String questionC;

    private String questionD;


    private Integer score;

    private String questionChapter;

    private Integer level;

    @Override
    public String toString() {
        return "Multiquestion{" +
                "questionId=" + questionId +
                ", questionName='" + questionName + '\'' +
                ", questionContext='" + questionContext + '\'' +
                ", answear='" + answear + '\'' +
                ", questionA='" + questionA + '\'' +
                ", questionB='" + questionB + '\'' +
                ", questionC='" + questionC + '\'' +
                ", questionD='" + questionD + '\'' +
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

    public String getAnswear() {
        return answear;
    }

    public void setAnswear(String answear) {
        this.answear = answear;
    }

    public String getQuestionA() {
        return questionA;
    }

    public void setQuestionA(String questionA) {
        this.questionA = questionA;
    }

    public String getQuestionB() {
        return questionB;
    }

    public void setQuestionB(String questionB) {
        this.questionB = questionB;
    }

    public String getQuestionC() {
        return questionC;
    }

    public void setQuestionC(String questionC) {
        this.questionC = questionC;
    }

    public String getQuestionD() {
        return questionD;
    }

    public void setQuestionD(String questionD) {
        this.questionD = questionD;
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
