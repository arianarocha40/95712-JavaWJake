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

    // Method for note creation
    private static void createNote() {
        int choice = getMenuChoice(createMenu);
        switch (choice) {
            case 1:
                createMemo();
                break;
            case 2:
                createTimedMemo();
                break;
            case 3:
                createPoliteMemo();
                break;
            case 4:
                return; // Return to previous menu
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    // Method to create a Memo
    private static void createMemo() {
        System.out.println("Enter Memo name:");
        String name = keyboard.nextLine();
        System.out.println("Enter Memo body:");
        String body = keyboard.nextLine();
        System.out.println("Enter who this is from:");
        String from = keyboard.nextLine();
        System.out.println("Enter who this is to:");
        String to = keyboard.nextLine();
        Memo memo = new Memo(name, body, from, to);
        noteCollection.add(memo);
    }

    // Method to create a Timed Memo
    private static void createTimedMemo() {
        System.out.println("Enter Timed Memo name:");
        String name = keyboard.nextLine();
        System.out.println("Enter Timed Memo body:");
        String body = keyboard.nextLine();
        System.out.println("Enter who this is from:");
        String from = keyboard.nextLine();
        System.out.println("Enter who this is to:");
        String to = keyboard.nextLine();
        TimedMemo timedMemo = new TimedMemo(name, body, from, to);
        noteCollection.add(timedMemo);
    }

    // Method to create a Polite Timed Memo
    private static void createPoliteMemo() {
        System.out.println("Enter Polite Timed Memo name:");
        String name = keyboard.nextLine();
        System.out.println("Enter Polite Timed Memo body:");
        String body = keyboard.nextLine();
        System.out.println("Enter who this is from:");
        String from = keyboard.nextLine();
        System.out.println("Enter who this is to:");
        String to = keyboard.nextLine();
        PoliteTimedMemo politeTimedMemo = new PoliteTimedMemo(name, body, from, to);
        noteCollection.add(politeTimedMemo);
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
                System.out.println("Enter Note number:");
                int number = keyboard.nextInt();
                keyboard.nextLine(); // Clear buffer
                Note noteByNumber = noteCollection.getNoteByNumber(number);
                if (noteByNumber != null) {
                    System.out.println(noteByNumber);
                } else {
                    System.out.println("No note found with number " + number);
                }
                break;
            case 3:
                System.out.println("Enter Note name:");
                String name = keyboard.nextLine();
                for (Note note : noteCollection.getNoteByName(name)) {
                    System.out.println(note);
                }
                break;
            case 4:
                return; // Return to the previous menu
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    // Generic method to get a menu choice from the user
    private static int getMenuChoice(String[] menu) {
        System.out.println(menu[0]);
        for (int i = 1; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
        int choice = keyboard.nextInt();
        keyboard.nextLine(); // Clear buffer
        return choice;
    }

    // Menus with additions
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
