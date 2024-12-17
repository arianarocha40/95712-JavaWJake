// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA LAB8

public class Device {
    private String type, location;
    private int id;

    public Device() {
        this.type = "";
        this.location = "";
        this.id = 0;
    }

    public Device(String type, String location, int id) {
        this.type = type;
        this.location = location;
        this.id = id;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "Device{" +
                "type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", id=" + id +
                '}';
    }

    public void actuate( ) {
        System.out.println(toString().toUpperCase());
    }
}
