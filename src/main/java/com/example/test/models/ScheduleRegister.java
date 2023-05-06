package com.example.test.models;

public class ScheduleRegister {
    private int id;
    private String name;
    private String owner;
    private int idRegister;
    private boolean notification;

    public ScheduleRegister() {
    }

    public ScheduleRegister(int id, String name, String owner, int idRegister, boolean notification) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.idRegister = idRegister;
        this.notification = notification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(int idRegister) {
        this.idRegister = idRegister;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    @Override
    public String toString() {
        return "ScheduleRegister{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", idRegister=" + idRegister +
                ", notification=" + notification +
                '}';
    }
}
