package NotePackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoteCollection {

    private List<Note> notes;

    public NoteCollection() {
        this.notes = new ArrayList<>();
    }

    // Static factory method
    public static Note createNote(String type, String name, String body, String from, String to) {
        switch (type) {
            case "Memo":
                return new Memo(name, body, from, to);
            case "TimedMemo":
                return new TimedMemo(name, body, from, to);
            case "PoliteTimedMemo":
                return new PoliteTimedMemo.Builder()
                    .setName(name)
                    .setBody(body)
                    .setFrom(from)
                    .setTo(to)
                    .build();
            default:
                throw new IllegalArgumentException("Unknown note type: " + type);
        }
    }

    // Add a note 
    public void add(Note note) {
        this.notes.add(note);
    }

    // Get all notes
    public List<Note> getAllNotes() {
        return new ArrayList<>(notes);  // Return a copy to prevent external modification
    }

    // Get a note by number
    public Note getNoteByNumber(int number) {
        if (number >= 0 && number < notes.size()) {
            return notes.get(number);
        }
        return null;
    }

    // Get notes by name
    public List<Note> getNoteByName(String name) {
        List<Note> matchingNotes = new ArrayList<>();
        for (Note note : notes) {
            if (note.getName().equals(name)) {
                matchingNotes.add(note);
            }
        }
        return matchingNotes;
    }

    // Sort notes by name
    public void sortByName() {
        Collections.sort(notes);
    }

    // Sort notes by number (assuming you mean by index)
    public void sortByNumber() {
        Collections.sort(notes, new NumberSorter());
    }

    // Sort notes by size (assuming size is body length)
    public void sortBySize() {
        Collections.sort(notes, new SizeSorter());
    }
}