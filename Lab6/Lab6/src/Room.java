//PART 4
//Name: Ariana Rocha
//Andrew ID: afrocha

public class Room {
    
    private double length;
    private double width;
    private String name;
    private Integer ID; 
    
    // Default Constructor
    public Room()
    {
        this.length = 0.0;
        this.width = 0.0;
        this.name = "";
        this.ID = 0;
    }

    //Overload Constructor
    public Room(double length, double width, String name, Integer ID)
    {
        this.length = length; 
        this.width = width;
        this.name = name;
        this.ID = ID;
    }
    
    //Getters and Setters
    public double getLength() {return length;}
    public void setLength(double length) {this.length = length;}
    public double getWidth() {return width;}
    public void setWidth(double width) {this.width = width;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Integer getID() {return ID;}
    public void setID(Integer ID) {this.ID = ID;}

    // Method that computes and returns the Area LxW
    public double getArea() 
    {
        return (length*width);
    }

    public String toString() 
        {
            return String.format("Room[length=%.1f, width=%.1f, name=%s, ID=%d]", length, width, name, ID);
        }

    // public static void main(String[] args) throws Exception 
    // {
    //     System.out.println("Hello, World! This is the Room Class.");
    // }
}
