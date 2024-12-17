public class INOfficer extends Soldier {

    public String complain() {
        return "Too much running";
    }

    //default
    public INOfficer() {
        this.MOS = "11A";
        this.rank = "2LT";
    } 

    //Overloaded
    public INOfficer(String rank) {
        this.MOS = "11A";
        this.rank = rank;
    }

}
