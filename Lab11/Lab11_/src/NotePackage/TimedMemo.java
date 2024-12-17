package NotePackage;
import java.time.LocalDate;

public class TimedMemo extends Memo {
    private String today;

    public TimedMemo(String name, String body, String from, String to) {
        super(name, body, from, to);
        this.today = LocalDate.now().toString();
    }

    @Override
    public String toString() {
        return "Date: " + today + "\n" + super.toString();
    }
}
