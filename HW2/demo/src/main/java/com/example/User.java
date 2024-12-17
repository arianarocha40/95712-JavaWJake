// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 2

package com.example;

public abstract class User {
    private int id;
    private String userName;

    // Constructor
    public User(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    // Getters and Setters
    public int getID() {return id;}
    public void setID(int id) {this.id = id;}

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    // Abstract method to get the user type (e.g., Administrator, Officer, CourtOfficial)
    public abstract String getUserType();

    // toString method
    @Override
    public String toString() {
        return "User ID: " + id + ", Name: " + userName + ", Type: " + getUserType();
    }
}
