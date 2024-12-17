// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 2

package com.example;

import java.util.Scanner;

public class Menu {
    private String[] menuChoices;

    //default contructors 
    public Menu()
    {
        menuChoices = new String[]
        {
            "Quit", 
            "Display All Citations", 
            "Display Citations by Offense Type", 
            "Search for a Citation by Number", 
            "Search for a Citation by Person's Last Name",
            "Add a New Citation",
            "Delete an Existing Citation Number", 
            "Sort Citations by Number",
            "Sort Citations by Person (Last Name)",
            "Sort Citations by Type",
            "Display Citations by User"
        };
    }

    //Display menu and prompt user for choice
    public int displayMenu(Scanner scanner)     
    {
        System.out.println("\nCitation Support System Menu: ");
        
        //Display all menu options
        for(int i=0; i< menuChoices.length; i++)
        { 
            System.out.println(i + ". " + menuChoices[i]);
        }

        // prompt user for choice
        System.out.print("Enter your choice: ");

        //error handling
        try 
        {
            int choice = scanner.nextInt();
            if(choice < 0 || choice >= menuChoices.length) 
            {
                System.out.println("Invalid choice. Please enter a number between 0 and " + (menuChoices.length -1));
                return 0;
            }
            return choice;
        } catch (Exception e)
        {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
            return 0;
        }
    }
}