// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 2

package com.example;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator; // HW2 import
import java.util.Collections;// HW2 import
import java.util.Comparator;// HW2 import
//import java.util.List;// HW2 import

//import com.example.Citation; //import Citation;

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
                int userID = Integer.parseInt(data[8]); // HW2 reading userID from CSV as instructed

                //Create person & citation OBJs
                Person person = new Person(firstName, lastName, address, phoneNumber);
                Citation citation = new Citation(typeOfOffense, description, number, date, person, userID); // HW2 add userID
                
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
        } catch (IOException e) {System.out.println("Error writing to citation file: " + e.getMessage());}
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
   
    public String displayCitationType(String typeOfOffense) // HW2 modification
    {
        StringBuilder result = new StringBuilder();
        
        for (Citation citation : listOfCitations) 
        {
            if (citation.getTypeOfOffense().toUpperCase().equals(typeOfOffense.toUpperCase())) 
            {
                result.append(citation.toString());
            }
        }
        return result.length() > 0 ? result.toString(): "None Found"; // fancy if then statement
        // If the condition (in this case, result.length() > 0) is true, the expression returns valueIfTrue; otherwise, it returns valueIfFalse
        // fun new format -- condition ? valueIfTrue : valueIfFalse;
    }
    
    public String displayCitation(int number) // HW2 modification
    {
        StringBuilder result = new StringBuilder();

        for(Citation citation : listOfCitations)
        {
            if(citation.getNumber() == number) 
            { 
                result.append(citation.toString());
            }
        }
        return result.length() >0 ? result.toString() : "None Found";
    }
    
    public String displayCitation(String lastName) // HW2 modificaiton
    {
        StringBuilder result = new StringBuilder();

        for(Citation citation : listOfCitations)
        {
            if(citation.getPerson().getLastName().toUpperCase().equals(lastName.toUpperCase()))
            {
                result.append(citation.toString());
            }
        }
        return result.length() > 0 ? result.toString() : "None Found";
    }

    // //newCitation()
    // public void newCitation(Citation citation)
    // {
    //     listOfCitations.add(citation);
    // }
    
    // Threw a ConcurrentModifciationException. Opting to use iterator instead 
    // public String delete(int number) {
    //     for(Citation citation: listOfCitations) {
    //         if(citation.getNumber() == number) {
    //             listOfCitations.remove(citation);
    //             return "Deleted";
    //         }
    //     }
    //     return "Not Found";
    // }

    public String delete(int number) { // HW2 method
        Iterator<Citation> iterator = listOfCitations.iterator();
        while (iterator.hasNext()) {
            Citation citation = iterator.next();
            if (citation.getNumber() == number) {
                iterator.remove();  // Safely remove the Citation
                return "Deleted";
            }
        }
        return "Not Found";
    }
    
    public void sortByNumber() { // HW2 method
        Collections.sort(listOfCitations);
    }

    public void sortByName() { // HW2 method
        Collections.sort(listOfCitations, new Comparator<Citation>() {
            @Override
            public int compare(Citation c1, Citation c2) {
                int lastNameComparison = c1.getPerson().getLastName().compareTo(c2.getPerson().getLastName());
                if (lastNameComparison !=0) {
                    return lastNameComparison;
                } else {
                    return c1.getPerson().getFirstName().compareTo(c2.getPerson().getFirstName());
                }
            }
        });
    }

    public void sortByType() { // HW2 method
        Collections.sort(listOfCitations, new TypeSorter());
    }

    public String findByUser(int userID) { // HW2 method
        StringBuilder result = new StringBuilder();
        for(Citation citation : listOfCitations)
        {
            if(citation.getUserID() == userID)
            {
                result.append(citation.toString()).append("\n");
            }
        }
        return result.length() > 0 ? result.toString() : "None Found";
    }


}