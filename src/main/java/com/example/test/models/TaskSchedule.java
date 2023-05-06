package com.example.test.models;

import java.util.Date;

public class TaskSchedule {
    private int id;

    private int idSchedule;
    private String name;
    private String description;
    private Date dateCreated;
    private String nameSchedule;
    private String ownerSchedule;

    public TaskSchedule() {
    }

    public TaskSchedule(int id, int idSchedule, String name, String description, Date dateCreated, String nameSchedule, String ownerSchedule) {
        this.id = id;
        this.idSchedule = idSchedule;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.nameSchedule = nameSchedule;
        this.ownerSchedule = ownerSchedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getNameSchedule() {
        return nameSchedule;
    }

    public void setNameSchedule(String nameSchedule) {
        this.nameSchedule = nameSchedule;
    }

    public String getOwnerSchedule() {
        return ownerSchedule;
    }

    public void setOwnerSchedule(String ownerSchedule) {
        this.ownerSchedule = ownerSchedule;
    }

    @Override
    public String toString() {
        return "TaskSchedule{" +
                "id=" + id +
                ", idSchedule=" + idSchedule +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", nameSchedule='" + nameSchedule + '\'' +
                ", ownerSchedule='" + ownerSchedule + '\'' +
                '}';
    }
}
