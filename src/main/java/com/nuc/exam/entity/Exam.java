package com.nuc.exam.entity;

public class Exam {
    private Integer examId;

    private String examName;//考试科目

    private String examCreater;//考试创建者

    private String examClassName;//考试专业

    private String examTime;

    private Integer examStatus;//考试状态 0:未开考，1:开始考试 2:考试结束

    private String examContext;//考试题目


    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", examName='" + examName + '\'' +
                ", examCreater='" + examCreater + '\'' +
                ", examClassName='" + examClassName + '\'' +
                ", examTime='" + examTime + '\'' +
                ", examStatus=" + examStatus +
                ", examContext='" + examContext + '\'' +
                '}';
    }

    public String getExamContext() {
        return examContext;
    }

    public void setExamContext(String examContext) {
        this.examContext = examContext;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamCreater() {
        return examCreater;
    }

    public void setExamCreater(String examCreater) {
        this.examCreater = examCreater;
    }

    public String getExamClassName() {
        return examClassName;
    }

    public void setExamClassName(String examClassName) {
        this.examClassName = examClassName;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public Integer getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(Integer examStatus) {
        this.examStatus = examStatus;
    }
}
