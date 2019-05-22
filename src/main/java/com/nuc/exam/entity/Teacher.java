package com.nuc.exam.entity;

public class Teacher {

    private Integer teacherId;

    private String teacherNumber;

    private String teacherName;


    private String teacherPassword;

    private boolean teacherSex;

    private String teacherEmail;

    private String teacherPhone;

    public String toString() {
        return "Teacher{" +
                "teacherNumber='" + teacherNumber + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherSex=" + teacherSex +
                ", teacherEmail='" + teacherEmail + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                '}';
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public boolean isTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(boolean teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }
}
