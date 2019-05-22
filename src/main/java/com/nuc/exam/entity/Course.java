package com.nuc.exam.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Course {
    private Integer courseId;
    private String courseName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date courseStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date courseEndTime;
    private String courseClassName;
    private Integer courseTeacherId;
    private Teacher teacher;

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseStartTime=" + courseStartTime +
                ", courseEndTime=" + courseEndTime +
                ", courseClassName='" + courseClassName + '\'' +
                ", courseTeacherId=" + courseTeacherId +
                '}';
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getCourseId() {
        return courseId;
    }


    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }


    public Integer getCourseTeacherId() {
        return courseTeacherId;
    }

    public void setCourseTeacherId(Integer courseTeacherId) {
        this.courseTeacherId = courseTeacherId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCourseStartTime() {
        return courseStartTime;
    }

    public void setCourseStartTime(Date courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    public Date getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(Date courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public String getCourseClassName() {
        return courseClassName;
    }

    public void setCourseClassName(String courseClassName) {
        this.courseClassName = courseClassName;
    }


}
