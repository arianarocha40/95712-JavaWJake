// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA LAB8

import java.util.ArrayList;

public class AlarmCollection 
{
    ArrayList<Alarm> alarms; 

    AlarmCollection()
    {
        alarms = new ArrayList<>();
    }

    void add(Alarm a) 
    {
        alarms.add(a);
    }

    void display() 
    {
        for (Alarm alarm : alarms) 
            {
                System.out.println(alarm.toString());
            }
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! Welcome to Lab8, Alarm Collection Class");

    }
}
