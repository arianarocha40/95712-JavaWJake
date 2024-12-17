// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA LAB8

public class Alarm {
    private String message;
    private int id;

    public Alarm() {
        this.message = "";
        this.id = 0;
    }

    public Alarm(String message, int id) {
        this.message = message;
        this.id = id;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "Alarm{" +
                "message='" + message + '\'' +
                ", id=" + id +
                '}';
    }

    public void soundTheAlarm( ) {
        System.out.println(message);
        System.out.println("Calling 911");
    }

}
