// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 2

package com.example;

public class Citation implements Comparable<Citation>{ // HW2 change to implement comparable
    private String typeOfOffense;
    private String description;
    private int number;
    private String date;
    private Person person;
    private int userID; //HW2 Change "add new member data"

    //default constructor
    public Citation() 
    {
        this.typeOfOffense = "";
        this.description = "";
        this.number = 0;
        this.date = "";
        this.person = new Person();
        this.userID = 0; //HW2 change "new data member"
    }

    //Overload Constructor
    public Citation(String typeOfOffense, String description, int number, String date, Person person, int userID)
    {
        this.typeOfOffense = typeOfOffense;
        this.description = description;
        this.number = number;
        this.date = date;
        this.person = person;
        this.userID = userID; // HW2 change "new data member"
    }

    //Getters & Setters
    public String getTypeOfOffense() {return typeOfOffense;}
    public void setTypeOfOffense(String typeOfOffense) {this.typeOfOffense = typeOfOffense;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public int getNumber() {return number;}
    public void setNumber(int number) {this.number = number;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public Person getPerson() {return person;}
    public void setPerson(Person person) {this.person = person;}

    public int getUserID() {return userID;} //HW2 change getter
    public void setUserID(int userID) {this.userID = userID;} // HW2 change setter

    //HW2 implement compareTo based on citation number
    @Override
    public int compareTo(Citation other) {
        return Integer.compare(this.number, other.number);
    }

    // Override -- toString()
    public String toString()
    {
        return "Citation #: " + number + "\n" + 
                "Type of Offense: " + typeOfOffense + "\n" + 
                "Description: " + description + "\n" +
                "Date: " + date + "\n" +
                "Person: " + person.toString() + "\n" +
                "UserID: " + userID + "\n"; // HW2 change add toString
    }

    // toString but not including person information as explicitly instructed in the HW
    public String toStringWithoutPerson() {
        return "Citation #: " + number + "\n" +
               "Type of Offense: " + typeOfOffense + "\n" +
               "Description: " + description + "\n" +
               "Date: " + date + "\n";  
               // HW2 Q don't add here? or add here? *******************
    }

    //ToCSV
    public String toCSV() 
    {
        return number + "," + typeOfOffense + "," + description + "," + date + "," +
                person.getFirstName() + "," + person.getLastName() + "," + 
                person.getAddress() + "," + person.getPhoneNumber() + "," +
                userID; // HW2 change add toCSV()
    }
}