package com.example.test.models.api;

import java.util.Date;

public class Task {
    private int id;
    private int idSchedule;
    private String name;
    private String description;
    private Date dateCreated;
    private String nameSchedule;
    private String ownerSchedule;
    private boolean complete;

    public Task() {
    }

    public Task(int id, int idSchedule, String name, String description, Date dateCreated, String nameSchedule, String ownerSchedule, boolean complete) {
        this.id = id;
        this.idSchedule = idSchedule;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.nameSchedule = nameSchedule;
        this.ownerSchedule = ownerSchedule;
        this.complete = complete;
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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
