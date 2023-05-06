package com.example.test.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String user;
    private int id_schedule;
    private boolean notification;

    public Register() {
    }

    public Register(String user, int id_schedule, boolean notification) {
        this.user = user;
        this.id_schedule = id_schedule;
        this.notification = notification;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId_schedule() {
        return id_schedule;
    }

    public void setId_schedule(int id_schedule) {
        this.id_schedule = id_schedule;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", id_schedule=" + id_schedule +
                ", notification=" + notification +
                '}';
    }
}
