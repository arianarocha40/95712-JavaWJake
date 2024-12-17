//PART 5
//Name: Ariana Rocha
//Andrew ID: afrocha

public class Alarm {
    
    private String message;
    private Integer ID;

    // Default Constructor
    public Alarm()
    {
        this.message = "";
        this.ID = 0;
    }

    // Overload Constructor
    public Alarm(String message, Integer ID)
    {
        this.message = message;
        this.ID = ID;
    }
    
    //Getters and Setters 
    public String getMessage() {return message;}
    public void setMessage(String message){this.message = message;}    
    public Integer getID() {return ID;}
    public void setID(Integer ID) {this.ID = ID;}
    
    public void soundTheAlarm()
    {
        System.out.println(message);
    }

    public String toString() 
    {
        return String.format("Alarm[message=%s, ID=%d]", message, ID);
    }

    // public static void main(String[] args) throws Exception 
    // {
    //     System.out.println("Hello, World! This is the Alarm Class.");
    // }
}
