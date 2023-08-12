package com.example.ontap1;

public class User {
    private int imageAvarta;
    private String nameUser;

    public User(int imageAvarta, String nameUser) {
        this.imageAvarta = imageAvarta;
        this.nameUser = nameUser;
    }

    public int getImageAvarta() {
        return imageAvarta;
    }

    public void setImageAvarta(int imageAvarta) {
        this.imageAvarta = imageAvarta;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
}
