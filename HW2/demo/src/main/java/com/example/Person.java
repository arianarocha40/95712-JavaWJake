// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 2

package com.example;

public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    //default constructo
    public Person() 
    {
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.phoneNumber = "";
    }

    // overloaded constructor
    public Person(String firstName, String lastName, String address, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // getters & setters
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    //toString() 
    public String toString()
    {
        return firstName + " " + lastName + "; " + address + "; " + phoneNumber;
        // This is the discrepancy I think was mentioned in the email announcement, just formatting.
        // return "First Name: " + firstName + "\n" + 
        //         "Last Name: " + lastName + "\n" + 
        //         "Address: " + address + "\n" +
        //         "Phone Number: " + phoneNumber;
    }

    //ToCSV
    public String toCSV() 
    {
        return firstName + "," + lastName + "," + address + "," + phoneNumber; 
    }
}