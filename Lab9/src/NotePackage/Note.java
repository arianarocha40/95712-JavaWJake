package NotePackage;
public abstract class Note {
    protected String name;
    protected String body;
    protected static int noteCount = 0;
    protected int noteNumber;
    protected static final String FOOTER = "***** Powered by Make-A-Note *****";

    public Note() {
        noteCount++;
        this.noteNumber = noteCount;
    }

    public Note(String name, String body) {
        this();
        this.name = name;
        this.body = body;
    }

    public int getNoteNumber() {
        return noteNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nBody: " + body + "\nNote# " + noteNumber + "\n" + FOOTER;
    }
}
