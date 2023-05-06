package com.example.test.models;

import jakarta.persistence.*;

@Entity
@Table(name = "task_complete")
public class TaskComplete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int id_task;
    private String user;
    private boolean complete;

    public TaskComplete() {
    }

    public TaskComplete(int id, int id_task, String user, boolean complete) {
        this.id = id;
        this.id_task = id_task;
        this.user = user;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "TaskComplete{" +
                "id=" + id +
                ", id_task=" + id_task +
                ", user='" + user + '\'' +
                ", complete=" + complete +
                '}';
    }
}
