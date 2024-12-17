// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 1

package com.example;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.example.Citation;
//import Citation;

public class CitationList {
    private ArrayList<Citation> listOfCitations;
    private String title;
    private String authority;

    //default constructor
    public CitationList()
    {
        this.title = "Chief";
        this.authority = "Barrett";
        this.listOfCitations = new ArrayList<>();
    }

    // overloaded constructor
    public CitationList(String title, String authority)
    {
        this.title = title;
        this.authority = authority;
        this.listOfCitations = new ArrayList<>();
    }

    //Getters and Setters
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getAuthority() {return authority;}
    public void setAuthority(String authority) {this.authority = authority;}

    public ArrayList<Citation> getListOfCitations() {return listOfCitations;}
    public void newCitation(Citation citation) {listOfCitations.add(citation);} //adding new citation

    // methods:
    public void readCitationFile(String filename) //Reads citation file
    {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            while ((line = br.readLine()) !=null)
            {
                String[] data = line.split(",");
                // CSV Columns
                int number = Integer.parseInt(data[0]);
                String typeOfOffense = data[1];
                String description = data[2];
                String date = data[3];
                String firstName = data[4];
                String lastName = data[5];
                String address = data[6];
                String phoneNumber = data[7];

                //Create person & citation OBJs
                Person person = new Person(firstName, lastName, address, phoneNumber);
                Citation citation = new Citation(typeOfOffense, description, number, date, person);
                
                //Adding to List of Citations
                listOfCitations.add(citation);
            }
        } catch (IOException e) {e.printStackTrace();}
    }
    
    public void writeCitationFile(String filename) //--writes citation to a CSV file
    {
        try(FileWriter writer = new FileWriter(filename))
        {
            for (Citation citation : listOfCitations) {writer.write(citation.toCSV()+ "\n");}
        } catch (IOException e) {e.printStackTrace();}
    }

    // display all citations using toString()

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(" ").append(authority).append(" is the officer in charge of all citations. \n\n");
        for (Citation citation : listOfCitations) 
            {sb.append(citation.toString()).append("\n");}
        return sb.toString();
    }
   
    public void displayCitationType(String typeOfOffense) 
    {
        for (Citation citation : listOfCitations) 
        {
            if (citation.getTypeOfOffense().toUpperCase().equals(typeOfOffense.toUpperCase())) 
            {
                System.out.println(citation);
            }
        }
    }
    
    public void displayCitation(int number)
    {
        for(Citation citation : listOfCitations)
        {
            if(citation.getNumber() == number) 
            { 
                System.out.println(citation);
            }
        }
    }
    
    public void displayCitation(String lastName) 
    {
        for(Citation citation : listOfCitations)
        {
            if(citation.getPerson().getLastName().toUpperCase().equals(lastName.toUpperCase()))
            {
                System.out.println(citation);
            }
        }
    }

    //newCitation()
    public void newCitation(Citation citation)
    {
        listOfCitations.add(citation);
    }
}