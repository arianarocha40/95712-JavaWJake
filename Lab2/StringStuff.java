// Lab2
// Your name: Ariana Rocha
// Your Andrew id: afrocha
// STEP 2 of lab told me to run it with Gopher, I did that. TRUE & FALSE

import java.util.Scanner;

// class StringStuff
// Tests a few issues of String equality

public class StringStuff {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int j = 15;
        double x = 1.004;
        String s1 = "gopher", s2;
        s2 = s1;

        System.out.println(j==15);
        System.out.println(x==1.004);
        System.out.println(s1=="gopher");
        System.out.println(s1 == s2);

        s2 = "gopher";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.print("Enter a string: ");
        s2 = scanner.next();
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        //STEP 3//
        String s3 = "The name of my pet";
        System.out.println(s3);
        String ups3 = s3.toUpperCase(); // this assigns ups3 to a value that makes s3 uppercase
        System.out.println(ups3); // prints the uppercase value as required 

        s2 = s3 + " " + s1;
        System.out.println(s2);

        s2 = s2 + " is Fluffy Face"; 
        System.out.println(s2);

        String lows2 = s2.toLowerCase();
        System.out.println(lows2);

        String interrupteds2 = s2.replace("e","XYZ");
        System.out.println(interrupteds2);        

        //STEP 4//
        String s4 = "Barret,Sales,#44132,8/22/2018";
        System.out.println(s4);
        String[] slist = s4.split(",");
        for (String str: slist) {
            System.out.println(str);
        }
        //Lines printed: 4//
        String date = "8/22/2018";
        String[] slistdate = date.split("/");
        for (String str: slistdate) {
            System.out.println(slistdate);
        }
    }
}
