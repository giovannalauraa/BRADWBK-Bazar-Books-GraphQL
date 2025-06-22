package com.bazar.bazarbooks.dto;

public class UserInput {
    private String name;
    private String email;

    public UserInput() {}

    public UserInput(String name, String email) {
        this.name = name;
        this.email = email;
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
