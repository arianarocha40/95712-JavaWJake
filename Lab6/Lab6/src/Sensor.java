//PART 2
//Name: Ariana Rocha
//Andrew ID: afrocha

public class Sensor 
{    
    private double minimum;
    private double maximum;
    private double currentValue;
    private double interval;
    private String location;
    private String type;
    private int ID;
        
    // Default Constructor Requirement
    // Default constructors set the initial values of the variables defined to something. 
    public Sensor() 
    {
        this.minimum = 0.0;
        this.maximum = 0.0;
        this.currentValue = 0.0;
        this.interval = 0.0;
        this.location = "";
        this. type = "";
        this.ID = 0;
    }

    // Overloaded Constructor
    // For all the member data 
    public Sensor(double minimum, double maximum, double currentValue, double interval, String location, String type, int ID)
    {
        this.minimum = minimum;
        this.maximum = maximum;
        this.currentValue = currentValue;
        this.interval = interval;
        this.location = location;
        this.type = type;
        this.ID = ID;
    }
    
    // Getters and Setters
    // Methods used to access and update the private fields of a class. Provide a controlled way to interact with the class’s data
    public double getMinimum () {return minimum;}
    public void setMinimum (double minimum) {this.minimum = minimum;}
    public double getMaximum () {return maximum;}
    public void setMaximum (double maximum) {this.maximum = maximum;}
    public double getCurrentValue() {return currentValue;}
    public void setCurrentValue (double currentValue) {this.currentValue = currentValue;}
    public double getInterval () {return interval;}
    public void setInterval(double interval) {this.interval = interval;}
    public String getlocation() {return location;}
    public void setLocation(String location) {this.location = location;}
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}

    // toString() method: prints string with all pertinent info
    public String toString() 
    {
        return String.format("Sensor[minimum=%.1f, maximum=%.1f, currentValue=%.1f, interval=%.1f, location=%s, type=%s, ID=%d]",
        minimum, maximum, currentValue, interval, location, type, ID);
    }

    protected boolean trip()
    {
        return currentValue < minimum || currentValue > maximum;
    }
    
    
    // public static void main(String[] args)
    // {       
    //     System.out.println("Hello, World! This is the Sensor Class");
    // }
}
