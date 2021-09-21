package com.example.finalprojectspringboot.Item;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "items")
public class Item {
@Id //
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Size(min = 1, max = 20)
    private String name;
    @Size(min = 1, max = 20)
    private String model;
    @Size(min = 1, max = 20)
    private String color;
    @Size(min = 1, max = 255)
    private String description;
    private String photo;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}