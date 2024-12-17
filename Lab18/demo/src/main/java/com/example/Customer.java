package com.example;

public class Customer implements Comparable<Customer>{
    private String firstName, lastName;
    private int rating;
    private double balance;
    private RatingType ratingType;

    public Customer(String firstName, String lastName, int rating, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.balance = balance;
        
        // PART 1: setting ratingType here:
        if (rating >=0 && rating <=3) {this.ratingType = RatingType.LOW;}
        else if (rating >=4 && rating <=7) {this.ratingType = RatingType.MEDIUM;}
        else if (rating >=8 && rating <=10) {this.ratingType = RatingType.HIGH;}
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getRating() { return rating; }
    public double getBalance() { return balance; }
    public String getRatingType() { return ratingType.toString();} // PART 1: Getter here

    @Override
    public String toString() {
        return "firstName = " + firstName + " "
                + "lastName = " + lastName + " "
                + "rating = " + rating + " "
                + "balance = " + balance + " "
                + "ratingType = " + ratingType; // PART 1: ratingType here
    }

    @Override
    public int compareTo(Customer customer) {
        return Integer.compare(this.rating, customer.rating);
        //return 0; OLD CODE
    }
}
