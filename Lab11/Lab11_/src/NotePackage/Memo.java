package NotePackage;
public class Memo extends Note {
    protected String from;
    protected String to;

    public Memo(String name, String body, String from, String to) {
        super(name, body);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "From: " + from + "\nTo: " + to + "\n" + super.toString();
    }
}
