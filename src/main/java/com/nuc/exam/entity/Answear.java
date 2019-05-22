package com.nuc.exam.entity;

public class Answear {

    private Integer examId;

    private String studentNumber;

    private String answear;

    private Integer score;

    private Integer questionId;

    @Override
    public String toString() {
        return "Answear{" +
                "examId=" + examId +
                ", studentNumber=" + studentNumber +
                ", answear='" + answear + '\'' +
                ", score=" + score +
                ", questionId=" + questionId +
                '}';
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getAnswear() {
        return answear;
    }

    public void setAnswear(String answear) {
        this.answear = answear;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
