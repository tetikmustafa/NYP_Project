package com.example.nyp_proje;

public class labCourse extends Course {

    public labCourse(String courseName, String courseCode, String courseTeacher, String courseClassroom, int time, int day) {
        super(courseName, courseCode, courseTeacher, courseClassroom, time, day);
    }

    @Override
    void color(int time, int day) {
        SyllabusScene.cellLists.get(time).get(day).setStyle("-fx-control-inner-background: #DCD0D0;");
    }
}
