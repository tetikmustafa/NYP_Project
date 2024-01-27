package com.example.nyp_proje;

public class onlineCourse extends Course {

    public onlineCourse(String courseName, String courseCode, String courseTeacher, String courseClassroom, int time, int day) {
        super(courseName, courseCode, courseTeacher, courseClassroom, time, day);
    }

    @Override
    void color(int time, int day) {
        SyllabusScene.cellLists.get(time).get(day).setStyle("-fx-control-inner-background: #D9E1E8;");
    }
}
