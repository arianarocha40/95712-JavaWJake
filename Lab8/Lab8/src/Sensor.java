// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA LAB8

public class Sensor {
    private double minimum, maximum, currentValue, interval;
    private String type, location;
    private int id;

    public Sensor() {
        this.minimum = 0.0;
        this.maximum = 0.0;
        this.currentValue = 0.0;
        this.interval = 0.0;
        this.type = "";
        this.location = "";
        this.id = 0;
    }

    public Sensor(double minimum, double maximum, double currentValue,
                  double interval, String type, String location, int id) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.currentValue = currentValue;
        this.interval = interval;
        this.type = type;
        this.location = location;
        this.id = id;
    }

    public double getMinimum() { return minimum; }
    public void setMinimum(double minimum) { this.minimum = minimum; }
    public double getMaximum() { return maximum; }
    public void setMaximum(double maximum) { this.maximum = maximum; }
    public double getCurrentValue() { return currentValue; }
    public void setCurrentValue(double currentValue) { this.currentValue = currentValue; }
    public double getInterval() { return interval; }
    public void setInterval(double interval) { this.interval = interval; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "Sensor{" +
                "minimum=" + minimum +
                ", maximum=" + maximum +
                ", currentValue=" + currentValue +
                ", interval=" + interval +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", id=" + id +
                '}';
    }

    public boolean trip( ) {
        if (currentValue < minimum || currentValue > maximum) {
            return true;
        } else {
            return false;
        }
    }

}
