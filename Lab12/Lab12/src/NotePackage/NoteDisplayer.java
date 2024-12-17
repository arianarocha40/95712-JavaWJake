//Done

package NotePackage;

public class NoteDisplayer {

    // prints note's toString()
    public static void displayNote(Note note) {
        System.out.println(note.toString());
    }

    // Fancy formating
    public static void displayNoteFancy(Note note) {
        System.out.println("**************");
        System.out.println("From: " + note.getFrom());
        System.out.println("To: " + note.getTo());
        System.out.println("Body: " + note.getBody());
        
        if (note instanceof TimedMemo) {
            System.out.println("Date: " + ((TimedMemo) note).getToday());
        }

        System.out.println("**************");
    }

    // Error message
    public static void displayErrorMessage(String errorMessage) {
        System.err.println("Error: " + errorMessage);
    }
}
