//Done

package NotePackage;

import java.time.LocalDate;

public class TimedMemo extends Memo {
    //private String today;
    private LocalDate today;

    //public TimedMemo(String name, String body, String from, String to) {
    TimedMemo(String name, String body, String from, String to) {
        super(name, body, from, to);
        this.today = LocalDate.now(); //.toString();
    }

    public LocalDate getToday() {
        return today;
    }

    @Override
    public String toString() {
        //return "Date: " + today + "\n" + super.toString();
        return super.toString() + "\nDate: " + today;
    }
}
