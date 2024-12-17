// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA LAB8

import java.util.ArrayList;

// SensorCollection Class
public class SensorCollection 
{
    // Attribute to hold sensor objects
    ArrayList<Sensor> sensors;

    //Constructor to init. sensor list
    SensorCollection() 
    {
        sensors = new ArrayList<>(); // creating new instance of the ArrayList
    }
     

    //Method required to add a Sensor to the collection
    void add(Sensor s) 
    {
        sensors.add(s);
    }

    // Method required to display all sensors in collection
    void display() 
    {
        for (Sensor sensor : sensors) 
        {
            System.out.println(sensor.toString()); 
        }
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! Welcome to Lab8, Sensor Colleciton Class");
    }
}