// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 2

package com.example;

public class CourtOfficial extends User {
    private String title;

    public CourtOfficial(int id, String userName, String title) {
        super(id, userName);
        this.title = title;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    @Override
    public String getUserType() {
        return "Court Official";
    }

    @Override
    public String toString() {
        return super.toString() + ", Title: " + title;
    }
}
