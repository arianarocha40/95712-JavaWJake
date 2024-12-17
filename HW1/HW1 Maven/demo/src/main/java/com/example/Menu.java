// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 1

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
            "Display all citations", 
            "Display citations by offense type", 
            "Search for a citation by number", 
            "Search for a citation by person's last name",
            "Add a new citation"
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