package com.sportyshoes.sportyshoes.model;

public class User {
    public String name;
    public String email;
    public String password;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString() {
        return "User [email=" + this.email + ", password=" + this.password + "]";
    }
}
