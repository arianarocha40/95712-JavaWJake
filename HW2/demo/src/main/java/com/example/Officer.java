// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 2

package com.example;

public class Officer extends User {
    private Rank rank;

    public Officer(int id, String userName, Rank rank) {
        super(id, userName);
        this.rank = rank;
    }

    public Rank getRank() {return rank;}
    public void setRank(Rank rank) {this.rank = rank;}

    @Override
    public String getUserType() {
        return "Officer";
    }

    @Override
    public String toString() {
        return super.toString() + ", Rank: " + rank;
    }
}
