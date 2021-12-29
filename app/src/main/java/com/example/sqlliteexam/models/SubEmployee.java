package com.example.sqlliteexam.models;

public class SubEmployee {

    private int id;
    private int EmplId;
    String name;
    String email;

    public SubEmployee(int id, int emplId, String name, String email) {
        this.id = id;
        EmplId = emplId;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmplId() {
        return EmplId;
    }

    public void setEmplId(int emplId) {
        EmplId = emplId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
