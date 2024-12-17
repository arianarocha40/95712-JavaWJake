// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 1

package com.example;

import java.util.Scanner;

public class hw1Main {
    public static void main(String[] args) 
    {
       Scanner scanner = new Scanner(System.in);
       CitationList citationList = new CitationList();
       Menu menu = new Menu();

       //read from csv
       citationList.readCitationFile("citations.csv");

       //Main menu loop
       int choice;
       do
       {
        choice = menu.displayMenu(scanner);

        switch (choice) 
        {
            case 1: //display all citation data WITHOUT person info
                for (Citation citation : citationList.getListOfCitations()) 
                {
                    System.out.println(citation.toStringWithoutPerson());
                }
                //System.out.println(citationList.toString());
                break;
            case 2: // display citations by type of offense
                System.out.println("Enter the type of Offense (Parking, Speeding, Jaywalking, Inebriated): ");
                String offenseType = scanner.next();
                scanner.nextLine();
                for (Citation citation : citationList.getListOfCitations()) 
                {
                    if (citation.getTypeOfOffense().equalsIgnoreCase(offenseType)) 
                    {
                        System.out.println(citation.toStringWithoutPerson());
                    }
                }
                //citationList.displayCitationType(offenseType);
                break;
            case 3: //search for a citation by citation number
                System.out.println("Enter the citation number: ");
                int number = scanner.nextInt();
                scanner.nextLine();
                citationList.displayCitation(number);
                break;
            case 4: // search for a citation by last name
                System.out.println("Enter the person's last name: ");
                String lastName = scanner.next();
                scanner.nextLine();
                citationList.displayCitation(lastName);
                break;
            case 5: // add new citation
            Citation newCitation = createNewCitation(scanner, citationList); 
                citationList.newCitation(newCitation);
                break;
            case 0: //quit
                citationList.writeCitationFile("citations.csv");
                System.out.println("Citations saved. Exiting...");
                break;
            default: 
                System.out.println("Invalid choice, please try again.");
                break;
        }
       } while (choice !=0);
       scanner.close();
    }

    public static Citation createNewCitation(Scanner scanner, CitationList citationList)
    {
        System.out.println("Enter citation details: ");
        String hold = scanner.nextLine();

        System.out.println("Type of offense(Parking, Speeding, Jaywalking, Inebriated): ");
        String typeOfOffense = scanner.nextLine();

        System.out.println("Description of the offense: ");
        String description = scanner.nextLine();

        System.out.println("Date of the citation (e.g.: 23-Aug-2023): ");
        String date = scanner.nextLine();

        System.out.println("First name of the person: ");
        String firstName = scanner.nextLine();

        System.out.println("Last name of the person: ");
        String lastName = scanner.nextLine();

        System.out.println("Address of the person: ");
        String address = scanner.nextLine();

        System.out.println("Phone number of the person: ");
        String phoneNumber = scanner.nextLine();

        // Recommend the next citation number based on the number of citations already in the system
        int recommendedNumber = citationList.getListOfCitations().size() + 1;
        System.out.println("Recommended citation number: " + recommendedNumber);

        System.out.print("Enter the citation number (or press Enter to use recommended number): ");
        String citationNumberInput = scanner.nextLine();

        int citationNumber;
        if (citationNumberInput.isEmpty()) {
            // If the user presses Enter, use the recommended number
            citationNumber = recommendedNumber;
        } else {
            // Otherwise, parse the user's input
            citationNumber = Integer.parseInt(citationNumberInput);
        }

        Person person = new Person(firstName, lastName, address, phoneNumber);
        return new Citation(typeOfOffense, description, citationNumber, date, person);
    }
}