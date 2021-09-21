package com.example.finalprojectspringboot.Home;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min = 1, max = 20)
    private String name;
    @Size(min = 1, max = 20)
    private String surname;
    @Size(min = 1, max = 20)
    private String login;
    @Size(min = 1, max = 40)
    private String email;
    @Size(min = 1, max = 20)
    private String password;
    private boolean isAdmin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}