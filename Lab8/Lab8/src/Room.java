// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA LAB8

public class Room {
    private double length, width;
    private String name;
    private int id;
    SensorCollection sensors;
    AlarmCollection alarms;
    Device device;


    public Room() {
        this.length = 0.0;
        this.width = 0.0;
        this.name = "";
        this.id = 0;
        sensors = new SensorCollection();
        alarms = new AlarmCollection();
        //Required no instance of Device
    }

    void addSensor(Sensor s)
    {
        sensors.add(s);
    }
    
    void addAlarm(Alarm a)
    {
        alarms.add(a);
    }

    void addDevice(Device d)
    {
        device = d;
    }

    void display()
    {
        System.out.println(this.toString());
        if (device != null)
        {
            System.out.println(device.toString());
        }
        sensors.display();
        alarms.display();
    }

    public Room(double length, double width, String name, int id) {
        this.length = length;
        this.width = width;
        this.name = name;
        this.id = id;
    }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "Room{" +
                "length=" + length +
                ", width=" + width +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public double getArea( ) {
        return length*width;
    }
}