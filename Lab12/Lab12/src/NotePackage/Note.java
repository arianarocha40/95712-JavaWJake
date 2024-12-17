//Done

package NotePackage;

public abstract class Note implements Comparable<Note> {
    protected String name;
    protected String body;
    protected static int noteCount = 0;
    protected int noteNumber;
    //protected static final String FOOTER = "***** Powered by Make-A-Note *****";

    public Note() {
        noteCount++;
        this.noteNumber = noteCount;
    }

    Note(String name, String body) {
        this();
        this.name = name;
        this.body = body;
    }

    public int getNoteNumber() {
        return noteNumber;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        //return "Name: " + name + "\nBody: " + body + "\nNote# " + noteNumber + "\n" + FOOTER;
        return "Note: " + name + "\nBody: " + body;
    }

    @Override
    public int compareTo(Note other) 
        {
            return this.name.compareTo(other.name);
        }

    // Abstract methods to be implemented by subclasses
    public abstract String getFrom();
    public abstract String getTo();
}
