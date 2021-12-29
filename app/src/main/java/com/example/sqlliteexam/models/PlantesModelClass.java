package com.example.sqlliteexam.models;

public class PlantesModelClass {
    private Integer id;
    private String name;
    private String description;
    private String price;
    private String quatity;

    public PlantesModelClass(Integer id, String name, String description, String price, String quatity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quatity = quatity;
    }

    public PlantesModelClass(String name, String description, String price, String quatity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quatity = quatity;
    }

    public PlantesModelClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public PlantesModelClass(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuatity() {
        return quatity;
    }

    public void setQuatity(String quatity) {
        this.quatity = quatity;
    }
}
