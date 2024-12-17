//PART 3
//Name: Ariana Rocha
//Andrew ID: afrocha

public class Device 
{
    private String type;
    private String location;
    private int ID;

    //Default constructor sets these values to something initially
    public Device()
    {
        this.type = "";
        this.location = "";
        this.ID = 0;
    }

    // Overload Constructor 
    public Device(String type, String location, int ID)
    {
        this.type = type;
        this.location = location;
        this.ID = ID; 
    }

    // Getters & Setters; Lets class talk to other classes (privat esp)
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}
    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}

    //Prints toString() but in ALL CAPS
    public void actuate()
    {
        System.out.println("Type: " + type.toUpperCase());
        System.out.println("Location: " + location.toUpperCase());
        String SID = Integer.toString(ID);
        System.out.println("ID: " + SID.toUpperCase());
    }

    //toString()
    public String toString() 
        {
            return String.format("Device[type=%s, location=%s, ID=%d]", type, location, ID);
        }
    
    // public static void main(String[] args) throws Exception 
    // {
    //     System.out.println("Hello, World! This is the Device Class");
    // }
}
