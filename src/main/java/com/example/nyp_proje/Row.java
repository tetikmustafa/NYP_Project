package com.example.nyp_proje;

import javafx.scene.control.ListView;

public class Row {
    private String time;
    private ListView monday;
    private ListView tuesday;
    private ListView wednesday;
    private ListView thursday;
    private ListView friday;
    private ListView saturday;
    private ListView sunday;

    public Row(String time, ListView monday, ListView tuesday, ListView wednesday, ListView thursday, ListView friday, ListView saturday, ListView sunday) {
        this.time = time;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ListView getMonday() {
        return monday;
    }

    public void setMonday(ListView monday) {
        this.monday = monday;
    }

    public ListView getTuesday() {
        return tuesday;
    }

    public void setTuesday(ListView tuesday) {
        this.tuesday = tuesday;
    }

    public ListView getWednesday() {
        return wednesday;
    }

    public void setWednesday(ListView wednesday) {
        this.wednesday = wednesday;
    }

    public ListView getThursday() {
        return thursday;
    }

    public void setThursday(ListView thursday) {
        this.thursday = thursday;
    }

    public ListView getFriday() {
        return friday;
    }

    public void setFriday(ListView friday) {
        this.friday = friday;
    }

    public ListView getSaturday() {
        return saturday;
    }

    public void setSaturday(ListView saturday) {
        this.saturday = saturday;
    }

    public ListView getSunday() {
        return sunday;
    }

    public void setSunday(ListView sunday) {
        this.sunday = sunday;
    }
}
