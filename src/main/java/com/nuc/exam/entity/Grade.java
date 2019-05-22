package com.nuc.exam.entity;

import java.util.Date;

public class Grade {

    private Integer gradeId;

    private Integer gradeExamId;

    private String gradeStudentNumber;

    private String gradeClass;

    private String gradeClassName;

    private Integer gradeScore;

    private Date gradeExamTime;

    private Exam exam;

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", gradeExamId=" + gradeExamId +
                ", gradeStudentNumber='" + gradeStudentNumber + '\'' +
                ", gradeClass='" + gradeClass + '\'' +
                ", gradeClassName='" + gradeClassName + '\'' +
                ", gradeScore=" + gradeScore +
                ", gradeExamTime=" + gradeExamTime +
                ", exam=" + exam +
                '}';
    }

    public Date getGradeExamTime() {
        return gradeExamTime;
    }

    public void setGradeExamTime(Date gradeExamTime) {
        this.gradeExamTime = gradeExamTime;
    }


    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getGradeExamId() {
        return gradeExamId;
    }

    public void setGradeExamId(Integer gradeExamId) {
        this.gradeExamId = gradeExamId;
    }

    public String getGradeStudentNumber() {
        return gradeStudentNumber;
    }

    public void setGradeStudentNumber(String gradeStudentNumber) {
        this.gradeStudentNumber = gradeStudentNumber;
    }

    public String getGradeClass() {
        return gradeClass;
    }

    public void setGradeClass(String gradeClass) {
        this.gradeClass = gradeClass;
    }

    public String getGradeClassName() {
        return gradeClassName;
    }

    public void setGradeClassName(String gradeClassName) {
        this.gradeClassName = gradeClassName;
    }

    public Integer getGradeScore() {
        return gradeScore;
    }

    public void setGradeScore(Integer gradeScore) {
        this.gradeScore = gradeScore;
    }
}
