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
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

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
                return;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private static void createMemo() {
        System.out.println("Enter Memo name:");
        String name = keyboard.nextLine();
        System.out.println("Enter Memo body:");
        String body = keyboard.nextLine();
        System.out.println("Enter who this is from:");
        String from = keyboard.nextLine();
        System.out.println("Enter who this is to:");
        String to = keyboard.nextLine();
        noteCollection.add(new Memo(name, body, from, to));
    }

    private static void createTimedMemo() {
        // Similar to createMemo, but uses TimedMemo
    }

    private static void createPoliteMemo() {
        // Similar to createMemo, but uses PoliteTimedMemo
    }

    private static void displayNotes() {
        int choice = getMenuChoice(displayMenu);
        switch (choice) {
            case 1:
                for (Note note : noteCollection.getAllNotes()) {
                    System.out.println(note);
                }
                break;
            case 2:
                // Display specific note by number
                break;
            case 3:
                // Display notes by name
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private static int getMenuChoice(String[] menu) {
        System.out.println(menu[0]);
        for (int i = 1; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
        int choice = keyboard.nextInt();
        keyboard.nextLine(); // clear buffer
        return choice;
    }

    private static String[] mainMenu = {
        "Main Menu", "Create a New Note", "Display existing Note(s)", "Quit"
    };

    private static String[] createMenu = {
        "Note Creation", "Create a Memo", "Create a Timed Memo", "Create a Polite Memo", "Return to previous menu"
    };

    private static String[] displayMenu = {
        "Display Options", "Display all Notes", "Display Note by Number", "Display Notes by Name", "Return to previous menu"
    };
}
















// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.Scanner;

// // Driver for Lab9
// public class MakeANote 
// {

//     // Keyboard scanner for user input
//     private static Scanner keyboard = new Scanner(System.in);

//     // String values for the main menu - title first
//     private static final String[] mainMenu = {"Main Menu", "Create a new Note",
//             "Display existing Note(s)", "Quit"};

//     // String  values for the create sub-menu - title first
//     private static final String[] createMenu = {"Note Creation", "Create a Memo",
//             "Create a Timed Memo", "Create a Polite Memo", "Return to previous menu"};

//     // String values for the display sub-menu - title first
//     private static final String[] displayMenu = {"Display Options", "Display all Notes",
//             "Display Note by Number", "Display Notes by Name", "Return to previous menu"};

//     // getMenuChoice(String[] menu)
//     //      Displays menu[]
//     //      Prompts the user for a choice
//     //      Returns choice without error checking
//     private static int getMenuChoice(String[] menu) {
//         int choice;
//         System.out.println(menu[0]);
//         // Display the menu, whatever its size is
//         for (int i = 1; i < menu.length; i++) {
//             System.out.println(i + ". " + menu[i]);
//         }
//         System.out.print("Enter your choice: ");
//         choice = Integer.parseInt(keyboard.nextLine());
//         return choice;
//     }

//     // Abstract class Note
//     static abstract class Note 
//     {
//         protected String name;
//         protected String body;
//         protected static int noteCount = 0;
//         protected int noteNumber;
//         protected static final String FOOTER = "***** Powered by Make-A-Note *****";

//         // Constructor that sets name and body, increments noteCount and assigns NoteNumber
//         public Note() 
//         {
//             noteCount++;
//             this.noteNumber = noteCount;
//         }

//         public Note(String name, String body) 
//         {
//             this(); // default constructor for keeping track of count and noteNumber
//             this.name = name;
//             this.body = body;
//         }

//         // Getter for noteNumber
//         public int getNoteNumber() 
//         {
//             return noteNumber;
//         }

//         // Abstract method to be implemented by subclasses
//         public abstract String toString();
//     }

//     // Memo class extends Note and adds from/to fields
//     static class Memo extends Note 
//     {
//         private String from; // Memo author
//         private String to; // Who memo is for

//         // Constructor that initializes Memo-specific fields along with Note fields
//         public Memo(String name, String body, String from, String to) 
//         {
//             super(name, body);
//             this.from = from;
//             this.to = to;
//         }

//         // Override toString() to include Memo-specific details
//         public String toString() 
//         {
//             return "From: " + from + "\nTo: " + to + "\nName: " + name + "\nBody: " + body + "\nNote#: " + noteNumber + "\n" + FOOTER;
//         }
//     }

//     // TimedMemo class extending Memo and adds creation date
//     static class TimedMemo extends Memo 
//     {
//         private String date;

//         public TimedMemo(String name, String body, String from, String to) 
//         {
//             super(name, body, from, to);
//             this.date = LocalDate.now().toString();
//         }

//         // Override toString() to include the creation date
//         public String toString() 
//         {
//             return "Date: " + date + "\n" + super.toString();
//         }
//     }

//     // PoliteTimedMemo class extends TimedMemo and adds greeting and closing
//     static class PoliteTimedMemo extends TimedMemo 
//     {
//         private static final String DEFAULT_GREETING = "Dear";
//         private static final String DEFAULT_CLOSING = "Yours truly,";

//         public PoliteTimedMemo(String name, String body, String from, String to) 
//         {
//             super(name, body, from, to);
//         }

//         // Override toString() to include greeting and closing
//         public String toString() 
//         {
//             return DEFAULT_GREETING + " " + super.to + ",\n\n" + body + "\n\n" + DEFAULT_CLOSING + "\n" + super.from + "\n" + super.toString();
//         }
//     }

//     // NoteCollection class manages a collection of Note objects
//     static class NoteCollection 
//     {
//         private ArrayList<Note> noteList;

//         public NoteCollection() 
//         {
//             noteList = new ArrayList<>();
//         }

//         public void add(Note note) 
//         {
//             noteList.add(note);
//         }

//         public ArrayList<Note> getAllNotes() 
//         {
//             return noteList;
//         }

//         public Note getNoteByNumber(int number) 
//         {
//             for (Note note : noteList) {
//                 if (note.getNoteNumber() == number) 
//                 {
//                     return note;
//                 }
//             }
//             return null;
//         }

//         public ArrayList<Note> getNoteByName(String name) 
//         {
//             ArrayList<Note> matchingNotes = new ArrayList<>();
//             for (Note note : noteList) 
//             {
//                 if (note.name.equalsIgnoreCase(name)) 
//                 {
//                     matchingNotes.add(note);
//                 }
//             }
//             return matchingNotes;
//         }
//     }

//     // main()
//     //      Display the main menu, get a choice
//     //      Create: get information for a new Memo
//     //      Submenus: tbd
//     public static void main(String[] args) 
//     {

//         // Create an empty NoteCollection
//         NoteCollection noteCollection = new NoteCollection();
//         // Menu choice
//         int choice;
//         // Memo values
//         String name = null, body = null, from = null, to = null;
//         // Note object to be new-ed up below
//         Note note = null;
//         // Submenu choice
//         int subchoice;

//         // Loop until the user chooses quit
//         do 
//         {

//             // Get the main menu choice
//             choice = getMenuChoice(mainMenu);

//             // What did they choose?
//             switch (choice) 
//             {

//                 // Create a new Note
//                 case 1:

//                     // Loop until the user chooses quit
//                     do 
//                     {

//                         // Get the create submenu choice
//                         subchoice = getMenuChoice(createMenu);

//                         // For now, create only a Memo
//                         if (subchoice == 1 || subchoice == 2 || subchoice == 3) 
//                         {
//                             System.out.print("Enter memo name: ");
//                             name = keyboard.nextLine();
//                             System.out.print("Enter memo body: ");
//                             body = keyboard.nextLine();
//                             System.out.print("Enter who this is from: ");
//                             from = keyboard.nextLine();
//                             System.out.print("Enter who this is to: ");
//                             to = keyboard.nextLine();
//                         }
//                         switch (subchoice) 
//                         {
//                             // Create a Memo
//                             case 1:
//                                 // Create a Memo object and add it to the Notecollection
//                                 note = new Memo(name, body, from, to);
//                                 noteCollection.add(note);
//                                 System.out.println("Memo created successfully!");
//                                 break;

//                             // Create a TimedMemo
//                             case 2:
//                                 note = new TimedMemo(name, body, from, to);
//                                 noteCollection.add(note);
//                                 System.out.println("Timed Memo created successfully!");
//                                 break;

//                             // Create a PoliteTimedMemo
//                             case 3:
//                                 note = new PoliteTimedMemo(name, body, from, to);
//                                 noteCollection.add(note);
//                                 System.out.println("Polite Timed Memo created successfully!");
//                                 break;

//                             // Quit
//                             case 4:
//                                 break;
//                         }
//                     } while (subchoice != 4);
//                     break;

//                 // Display Notes
//                 case 2:

//                     // Loop until the user chooses quit
//                     do 
//                     {

//                         // Get the display submenu choice
//                         subchoice = getMenuChoice(displayMenu);
//                         switch (subchoice) 
//                         {

//                             // Display all notes
//                             case 1:
//                                 ArrayList<Note> notes = noteCollection.getAllNotes();
//                                 if (notes.isEmpty()) 
//                                 {
//                                     System.out.println("No notes to display.");
//                                 } else {
//                                     for (Note n : notes) 
//                                     {
//                                         System.out.println(n);
//                                     }
//                                 }
//                                 break;

//                             // Display a note by number
//                             case 2:
//                                 System.out.print("Enter the note number: ");
//                                 int noteNumber = Integer.parseInt(keyboard.nextLine());
//                                 Note foundNote = noteCollection.getNoteByNumber(noteNumber);
//                                 if (foundNote != null) {
//                                     System.out.println(foundNote);
//                                 } else {
//                                     System.out.println("No note found with that number.");
//                                 }
//                                 break;

//                             // Display notes by name
//                             case 3:
//                                 System.out.print("Enter the note name: ");
//                                 String noteName = keyboard.nextLine();
//                                 ArrayList<Note> matchingNotes = noteCollection.getNoteByName(noteName);
//                                 if (matchingNotes.isEmpty()) {
//                                     System.out.println("No notes found with that name.");
//                                 } else {
//                                     for (Note n : matchingNotes) 
//                                     {
//                                         System.out.println(n);
//                                     }
//                                 }
//                                 break;

//                             // Quit
//                             case 4:
//                                 System.out.println("Returning to main menu");
//                                 break;
//                         }
//                     } while (subchoice != 4);
//                     break;

//                 // Quit the main menu
//                 case 3:
//                     System.out.println("Exiting the program.");
//                     break;
//             }

//         } while (choice != 3);
//     }
// }
