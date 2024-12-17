public class MIOfficer extends Soldier {

    public String complain() {
        return "Too many nerds";
    }

    //default
    public MIOfficer() {
        this.MOS = "35A";
        this.rank = "2LT";
    }

    //Overloaded
    public MIOfficer(String rank){
        this.MOS = "35A";
        this.rank = rank;
    }
}