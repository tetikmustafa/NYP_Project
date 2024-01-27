package com.example.nyp_proje;

public abstract class Course {
    private String courseName;
    private String courseCode;
    private String courseTeacher;
    private String courseClassroom;

    public Course(String courseName, String courseCode, String courseTeacher, String courseClassroom, int time, int day) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseTeacher = courseTeacher;
        this.courseClassroom = courseClassroom;
        this.color(time,day);
    }
    abstract void color(int time, int day);
    public void AddCourse(int time, int day, String dersTipi){
        SyllabusScene.cellItems.get(time).get(day).setAll(courseName, courseCode, courseTeacher, courseClassroom,dersTipi);
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getCourseClassroom() {
        return courseClassroom;
    }

    public void setCourseClassroom(String courseClassroom) {
        this.courseClassroom = courseClassroom;
    }
}
