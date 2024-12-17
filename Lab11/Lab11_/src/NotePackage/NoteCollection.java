package NotePackage;
import java.util.ArrayList;
import java.util.Collections;

public class NoteCollection {
    private ArrayList<Note> noteList;

    public NoteCollection() {
        noteList = new ArrayList<>();
    }

    public void add(Note note) {
        noteList.add(note);
    }

    public ArrayList<Note> getAllNotes() {
        return noteList;
    }

    public Note getNoteByNumber(int number) {
        for (Note note : noteList) {
            if (note.getNoteNumber() == number) {
                return note;
            }
        }
        return null;
    }

    public ArrayList<Note> getNoteByName(String name) {
        ArrayList<Note> matchingNotes = new ArrayList<>();
        for (Note note : noteList) {
            if (note.name.equals(name)) {
                matchingNotes.add(note);
            }
        }
        return matchingNotes;
    }

    public void sortByName() 
    {
        Collections.sort(noteList);
    }

    public void sortByNumber() 
    {
        Collections.sort(noteList, new NumberSorter());
    }

    public void sortBySize() 
    {
        Collections.sort(noteList, new SizeSorter());
    }
    
}
