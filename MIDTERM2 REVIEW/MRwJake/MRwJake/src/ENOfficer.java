public class ENOfficer extends Soldier{
    public String complain() {
        return "sapper school sucks";
    }

    //default
    public ENOfficer() {
        this.MOS = "12A";
        this.rank = "2LT";
    }

    //Overload
    public ENOfficer(String rank) {
        this.MOS = "12A"; //hard coded
        this.rank = rank;
    }
}
