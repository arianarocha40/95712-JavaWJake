// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA LAB8

public class Lab8 
{
    public static void main(String[] args) 
    {
        //System.out.println("Hello, World! Welcome to Lab8");
        Room room1 = new Room(12.0, 15.0, "kitchen", 1);

        Device extinguisher = new Device("fire extinguisher", "kitchen", 1);
        room1.addDevice(extinguisher);

        for (int i = 1; i<= 5; i++) 
        {
            Sensor sensor = new Sensor(0.0, 120.0, 68.0, 1.0, "kitchen", "temperature", i);
            room1.addSensor(sensor);
        }

        for (int i = 1; i <=3; i++)
        {
            Alarm alarm = new Alarm("Ding! Ding!", i);
            room1.addAlarm(alarm);
        }

        room1.display();

        Device chemicalFoamer = new Device("chemical foamer", "kitchen", 2);
        room1.addDevice(chemicalFoamer);
        room1.display();
    }
}
