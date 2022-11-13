package com.example.UntitledTestSuite.Entities;

public class AccountData {
    public String username;
    public String password;

    public AccountData(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}