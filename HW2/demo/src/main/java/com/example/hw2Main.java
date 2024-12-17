// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 2

package com.example;
import java.io.BufferedReader; // HW2 add
import java.io.FileReader; // HW2 add
import java.io.IOException; // HW2 add
import java.util.HashMap; // HW2 add

import java.util.Scanner;

public class hw2Main {
    private static HashMap<String, String> configData; // HW2 add
    private static UserList userList; // HW2 add

    //Method to read the config file and store data in a HashMap (python --> Dictionary type stuff) 
    //HW2 add
    private static HashMap<String, String> readConfigFile() { // HW2 requirement
        HashMap<String, String> config = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("configuration.csv"))) {
            String line; 
            while((line = reader.readLine()) !=null) {
                String[] parts = line.split(",");
                if(parts.length == 2) {
                    config.put(parts[0].trim(), parts[1].trim()); // Storing key value [airs]
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading configuration file: " + e.getMessage());
        }
        return config; //Returning populated hashmap
    }

    public static void main(String[] args) 
    {
        configData = readConfigFile(); // HW2 Calling method to load data into configData at the start  

        //HW2 get filepaths from configData
        String citationFile = configData.get("input file");
        String userFile = configData.get("user file");

        //HW2 instantiating relevant new objects 
        Scanner scanner = new Scanner(System.in);
        CitationList citationList = new CitationList();
        userList = new UserList(); 

        //Loading ciatations and users from files
        citationList.readCitationFile(citationFile);
        userList.readUserFile(userFile);
        
        //HW2 printing out filepaths
        System.out.println("Citation file: " + configData.get("input file"));
        System.out.println("User file: " + configData.get("user file"));

        Menu menu = new Menu();
        int choice;

        //read from csv
        // citationList.readCitationFile("citations.csv"); HW1 removal

        //Main menu loop
        do
        {
            choice = menu.displayMenu(scanner);

            switch (choice) 
            {
                case 0: //quit
                    citationList.writeCitationFile(citationFile);
                    System.out.println("Citations saved. Exiting...");
                    break;

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
                    // HW2 removal
                    // for (Citation citation : citationList.getListOfCitations())  
                    // {
                    //     if (citation.getTypeOfOffense().equalsIgnoreCase(offenseType)) 
                    //     {
                    //         System.out.println(citation.toStringWithoutPerson());
                    //     }
                    // }
                    System.out.println(citationList.displayCitationType(offenseType)); // HW 2 addition
                    break;

                case 3: //search for a citation by citation number
                    System.out.println("Enter the citation number: ");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(citationList.displayCitation(number));
                    break;

                case 4: // search for a citation by last name
                    System.out.println("Enter the person's last name: ");
                    String lastName = scanner.next();
                    scanner.nextLine();
                    System.out.println(citationList.displayCitation(lastName));
                    break;

                case 5: // add new citation
                    //HW2 tried adding & failed
                    newCitation(scanner,citationList);
                    //Hw2 removed then put back
                    // Citation newCitation = createNewCitation(scanner, citationList, userList); 
                    // citationList.newCitation(newCitation);
                    // System.out.println("New citation added.");
                    break;
                
                //HW2 Addition ccases 6-10
                case 6: // Delete an existing citation by number
                    System.out.println("Enter the citation number to delete: ");
                    int deleteNumber = scanner.nextInt();
                    scanner.nextLine();
                    String deleteResult = citationList.delete(deleteNumber);
                    System.out.println(deleteResult);
                    break;
    
                case 7: // Sort citations by number and display
                    citationList.sortByNumber();
                    System.out.println("Citations sorted by number:");
                    System.out.println(citationList.toString());
                    break;
    
                case 8: // Sort citations by person's last name and first name, then display
                    citationList.sortByName();
                    System.out.println("Citations sorted by person's last name and first name:");
                    System.out.println(citationList.toString());
                    break;
    
                case 9: // Sort citations by type and display
                    citationList.sortByType();
                    System.out.println("Citations sorted by type:");
                    System.out.println(citationList.toString());
                    break;
    
                case 10: // Display citations by userID
                    System.out.println("Available Users:");
                    userList.displayUsers();
                    System.out.println("Enter the userID for which to display citations:");
                    int userID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(citationList.findByUser(userID));
                    break;
                
                default: 
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice !=0);
        scanner.close();
    }

    //HW2 requirement
    private static void newCitation(Scanner scanner, CitationList citationList) {
        Citation newCitation = createNewCitation(scanner, citationList, userList);
        citationList.newCitation(newCitation);
        System.out.println("New citation added.");
    }

    private static Citation createNewCitation(Scanner scanner, CitationList citationList, UserList userList)
    {
        System.out.println("Enter citation details: ");
        String hold = scanner.nextLine();

        //Prompt for type of offense
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
        int citationNumber = citationNumberInput.isEmpty() ? recommendedNumber : Integer.parseInt(citationNumberInput);
        // HW1 removal for upgraded fancy verion ^^
        // if (citationNumberInput.isEmpty()) {
        //     // If the user presses Enter, use the recommended number
        //     citationNumber = recommendedNumber;
        // } else {
        //     // Otherwise, parse the user's input
        //     citationNumber = Integer.parseInt(citationNumberInput);
        // }

        //Hw2 addition: Have to prompt for userID
        //Display all available users
        System.out.println("Available Users: ");
        for(User user : userList.getListOfUsers()) {
            System.out.println("UserID: " + user.getID() + ", Name: " + user.getUserName());
        }

        System.out.println("Enter the userID responsible for this citation: ");
        int userID = scanner.nextInt();
        scanner.nextLine(); 

        Person person = new Person(firstName, lastName, address, phoneNumber);
        return new Citation(typeOfOffense, description, citationNumber, date, person, userID);
    }

    // HW2 removal
    // //newCitation()
    // public void newCitation(Citation citation)
    // {
    //     listOfCitations.add(citation);
    // }
}