public class AVOfficer extends Soldier {
    public String complain() {
        return "Not safe A/C";
    }

    //default constructor
    public AVOfficer() { //looked at this line
        this.MOS = "15A";
        this.rank = "WO1";
    }

    //overloaded constructor 
    public AVOfficer(String rank) { //forgot String here
        this.MOS = "15A"; // hardcoded
        this.rank = rank;
    }
}
