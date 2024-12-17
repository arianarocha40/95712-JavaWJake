// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 1

package com.example;

public class Citation {
    private String typeOfOffense;
    private String description;
    private int number;
    private String date;
    private Person person;

    //default constructor
    public Citation() 
    {
        this.typeOfOffense = "";
        this.description = "";
        this.number = 0;
        this.date = "";
        this.person = new Person();
    }

    //Overload Test Constructor
    public Citation(int number, String typeOfOffense, String description, String date, Person person)
    {
        this(typeOfOffense, description, number, date, person); 
    }

    //Overload COnstructor
    public Citation(String typeOfOffense, String description, int number, String date, Person person)
    {
        this.typeOfOffense = typeOfOffense;
        this.description = description;
        this.number = number;
        this.date = date;
        this.person = person;
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

    // Override -- toString()
    public String toString()
    {
        return "Citation #: " + number + "\n" + 
                "Type of Offense: " + typeOfOffense + "\n" + 
                "Description: " + description + "\n" +
                "Date: " + date + "\n" +
                "Person: " + person.toString() + "\n";
    }

    // toString but not including person information as explicitly instructed in the HW
    public String toStringWithoutPerson() {
        return "Citation #: " + number + "\n" +
               "Type of Offense: " + typeOfOffense + "\n" +
               "Description: " + description + "\n" +
               "Date: " + date + "\n";
    }

    //ToCSV
    public String toCSV() 
    {
        return number + "," + typeOfOffense + "," + description + "," + date + "," +
                person.getFirstName() + "," + person.getLastName() + "," + 
                person.getAddress() + "," + person.getPhoneNumber();
    }
}