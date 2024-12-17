import java.util.Collection;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
    public static void main(String[] args) { //throws Exception { should never have on main method, fine on other methods
        System.out.println("Welcome to BDE HQ. Let's assign you to a new unit.");

        Collection<Soldier> InfBN = new ArrayList<>();
        Collection<Soldier> SQDN = new ArrayList<>(); // struggled here
        Collection<Soldier> BEB = new ArrayList<>(); // used sheet crushed it

        
        InfBN.add(new MIOfficer("CPT"));
        InfBN.add(new INOfficer("1LT"));

        SQDN.add(new MIOfficer("CPT"));
        SQDN.add(new AVOfficer("CW5"));

        BEB.add(new MIOfficer("1LT"));
        BEB.add(new ENOfficer("MAJ"));// used sheet crushed it

        try {
            for (Soldier s: InfBN) {
                System.out.println(s.rank);
                if (s.rank == "CPT") {
                    throw new Exception("CPT's suck");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{ // struggled with this trycatch block a bit 
            for (Soldier s: SQDN) {
                System.out.println(s.rank);
                if(s.rank == "CW5") {
                    throw new IOException("OMG A UNICORN"); // handled locally
                } // only things that handle exceptions == try catch blocks
            }
        } catch (Exception e) { // struggled here
            e.printStackTrace();
        }

        // used sheet crushed it
        //try{ 
            for(Soldier s: BEB) {
                System.out.println(s.rank);
                if (s.rank == "MAJ") {
                    throw new RuntimeException("IRON MAJOR!"); // passing it to the caller
                } // don't have to mark method with unchecked
            }
        
        //} catch(Exception e) {
        //    e.printStackTrace();
        //}
    }
}
