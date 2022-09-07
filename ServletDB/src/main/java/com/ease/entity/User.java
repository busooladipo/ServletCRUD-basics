package com.ease.entity;

public class User {
    private int users_id;
    private String users_name;
    private String users_email;

    public User(int users_id, String users_name, String users_email) {
        this.users_id = users_id;
        this.users_name = users_name;
        this.users_email = users_email;
    }

    public User(String users_name, String users_email) {
        this.users_name = users_name;
        this.users_email = users_email;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getUsers_email() {
        return users_email;
    }

    public void setUsers_email(String users_email) {
        this.users_email = users_email;
    }
}
