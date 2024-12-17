package DataPackage;

public class ContainedClass {
    //private encapsulation fields
    private int x;
    private int y;

    //Constructor
    public ContainedClass(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    //Copy Constructor
    public ContainedClass(ContainedClass other)
    {
         this.x = other.x;
         this.y = other.y;
    }

    //X Getter
    public int getX() {return x;}

    //X Setter
    public void setX(int x) {this.x = x;}

    //Y Getter
    public int getY() {return y;}

    //Y Setter
    public void setY(int y) {this.y = y;}

    //Override
    public String toString() 
    {
        return "ContainedClass [x=" + x + ", y=" + y + "]";
    }

    //String ccString = "";
    // public void setCcString(String ccString) {
    //     this.ccString = ccString;
    // }
}
