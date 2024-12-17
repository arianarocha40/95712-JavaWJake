package NotePackage;
public class PoliteTimedMemo extends TimedMemo {
    private static final String DEFAULT_GREETING = "Dear";
    private static final String DEFAULT_CLOSING = "Yours truly,";

    public PoliteTimedMemo(String name, String body, String from, String to) {
        super(name, body, from, to);
    }

    @Override
    public String toString() {
        return DEFAULT_GREETING + " " + to + ":\n" + body + "\n" + DEFAULT_CLOSING + "\n" + from + "\n" + super.toString();
    }
}
