package NotePackage;

import java.util.Scanner;

public class MakeANote {
    private static Scanner keyboard = new Scanner(System.in);
    private static NoteCollection noteCollection = new NoteCollection();

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            int choice = getMenuChoice(mainMenu);
            switch (choice) {
                case 1:
                    createNote();
                    break;
                case 2:
                    displayNotes();
                    break;
                case 3:
                    quit = true;
                    break;
                case 4:
                    noteCollection.sortByName();
                    System.out.println("Notes sorted by name.");
                    break;
                case 5:
                    noteCollection.sortByNumber();
                    System.out.println("Notes sorted by number.");
                    break;
                case 6:
                    noteCollection.sortBySize();
                    System.out.println("Notes sorted by size.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Method for note creation using the factory method
    private static void createNote() {
        int choice = getMenuChoice(createMenu);
        String name, body, from, to;
        switch (choice) {
            case 1:  // Memo
                name = getStringInput("Enter Memo name:");
                body = getStringInput("Enter Memo body:");
                from = getStringInput("Enter who this is from:");
                to = getStringInput("Enter who this is to:");
                Note memo = NoteCollection.createNote("Memo", name, body, from, to);
                noteCollection.add(memo);
                break;
            case 2:  // Timed Memo
                name = getStringInput("Enter Timed Memo name:");
                body = getStringInput("Enter Timed Memo body:");
                from = getStringInput("Enter who this is from:");
                to = getStringInput("Enter who this is to:");
                Note timedMemo = NoteCollection.createNote("TimedMemo", name, body, from, to);
                noteCollection.add(timedMemo);
                break;
            case 3:  // Polite Timed Memo (Builder Pattern)
                name = getStringInput("Enter Polite Timed Memo name:");
                body = getStringInput("Enter Polite Timed Memo body:");
                from = getStringInput("Enter who this is from:");
                to = getStringInput("Enter who this is to:");
                Note politeMemo = new PoliteTimedMemo.Builder()
                        .setName(name)
                        .setBody(body)
                        .setFrom(from)
                        .setTo(to)
                        .build();
                noteCollection.add(politeMemo);
                break;
            case 4:
                return;  // Return to previous menu
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    // Method for displaying notes
    private static void displayNotes() {
        int choice = getMenuChoice(displayMenu);
        switch (choice) {
            case 1:
                for (Note note : noteCollection.getAllNotes()) {
                    System.out.println(note);
                }
                break;
            case 2:
                int number = getIntInput("Enter Note number:");
                Note noteByNumber = noteCollection.getNoteByNumber(number);
                if (noteByNumber != null) {
                    System.out.println(noteByNumber);
                } else {
                    System.out.println("No note found with number " + number);
                }
                break;
            case 3:
                String name = getStringInput("Enter Note name:");
                for (Note note : noteCollection.getNoteByName(name)) {
                    System.out.println(note);
                }
                break;
            case 4:
                return;  // Return to previous menu
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    // Helper method to get a string input
    private static String getStringInput(String prompt) {
        System.out.println(prompt);
        return keyboard.nextLine();
    }

    // Helper method to get an integer input
    private static int getIntInput(String prompt) {
        System.out.println(prompt);
        while (!keyboard.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            keyboard.next();  // Clear invalid input
        }
        int number = keyboard.nextInt();
        keyboard.nextLine();  // Clear buffer
        return number;
    }

    // Method to get menu choice
    private static int getMenuChoice(String[] menu) {
        System.out.println(menu[0]);
        for (int i = 1; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
        return getIntInput("Enter your choice:");
    }

    // Menu definitions
    private static String[] mainMenu = {
        "Main Menu", 
        "Create a New Note", 
        "Display existing Notes", 
        "Quit", 
        "Sort by Name", 
        "Sort by Number", 
        "Sort by Size"
    };

    private static String[] createMenu = {
        "Note Creation", 
        "Create a Memo", 
        "Create a Timed Memo", 
        "Create a Polite Memo", 
        "Return to previous menu"
    };

    private static String[] displayMenu = {
        "Display Options", 
        "Display all Notes", 
        "Display Note by Number", 
        "Display Notes by Name", 
        "Return to previous menu"
    };
}
