package DataPackage;

//import java.util.ArrayList;

public class DataSnooper {

    public static void main(String[] args){
    //public void snoop() {
        Data d = new Data(); // instanc eof new data
        //System.out.println("Beginning DataPackage.Data");
        // System.out.println(d.toString());

        // Problem 1- Enforce encapsulation for ivalue
        d.setiValue(-10);
        System.out.println("iValue (should be default): " + d.getiValue());

        d.setiValue(5);
        System.out.println("iValue: " + d.getiValue());
        
        //Old code
        // System.out.println("Direct access");
        // System.out.println("iValue = " + d.iValue);
        // System.out.println("sValue = " + d.sValue);
        // System.out.println("iList = ");
        // for (int i=0; i < d.iList.length; i++) {
        //     System.out.println(d.iList[i]);
        // }

        // Problem 2 - enforcing encapsulation for svalue
        d.setsValue("TooLongString:)");
        System.out.println("sValue (should be default):" + d.getsValue());

        d.setsValue("Validstr");
        System.out.println("sValue (should be default): " + d.getsValue());
        
        //Old code
        // System.out.println("Change the simple data");
        // d.iValue = -1;
        // d.sValue = "Dog";
        // d.iList[0] = 0;
        // d.iList[1] = 0;
        // d.iList[2] = 0;
        // System.out.println(d.toString());

        // Problem 3 = enforce encap for iList
        d.setIList(new int[] {9,15,19});
        System.out.println("iList: " + java.util.Arrays.toString(d.getIList()));

        d.setIList(new int[] {10, 15, 19, 20});
        System.out.println("iList: " + java.util.Arrays.toString(d.getIList()));
        
        //Old Code
        // System.out.println("Change the array");
        // int[] mylist = {-1, -2, -3, -4, -5};
        // d.setiList(mylist);
        // System.out.println(d.toString());

        // Problem 4
        ContainedClass cc = new ContainedClass(1,2);
        d.setCc(cc);
        System.out.println("ContainedClass: " + d.getCc());

        cc.setX(100);
        System.out.println("Modified original ContainedClass: " + cc);
        System.out.println("Data's ContainedClass after modification (should be unchanged): " + d.getCc());
        // Old Code
        // System.out.println("Change the ArrayList");
        // ArrayList<Integer> yourlist = new ArrayList<>();
        // yourlist.add(1000);
        // d.setaList(yourlist);
        // System.out.println(d.toString());


        // Problem 5 Testingencapsulation

        // Test Rule a: iValue must be positive; if not do not reset it
        d.setiValue(-5);  
        System.out.println("iValue after setting -5 (should be default 0): " + d.getiValue());

        d.setiValue(10);  
        System.out.println("iValue after setting 10: " + d.getiValue());

        // Test Rule b: sValue can have a maximum of 10 characters
        d.setsValue("ThisStringIsTooLong");  
        System.out.println("sValue after setting too long string (should be default null): " + d.getsValue());

        d.setsValue("ShortStr"); 
        System.out.println("sValue after setting valid string: " + d.getsValue());

        // Test Rule c: iList can have a maximum of 4 entries
        d.setIList(new int[] {5, 12, 18, 20});
        System.out.println("iList after setting invalid list (should be default): " + java.util.Arrays.toString(d.getIList()));

        d.setIList(new int[] {12, 14, 18});
        System.out.println("iList after setting valid list: " + java.util.Arrays.toString(d.getIList()));

        // Test Rule d: iList's entries must be between 10 and 20 inclusive
        d.setIList(new int[] {9, 15, 19});  // Invalid, 9 is out of range
        System.out.println("iList after setting invalid entries (should not set): " + java.util.Arrays.toString(d.getIList()));

        d.setIList(new int[] {10, 15, 19, 20});  // Valid, all entries within range
        System.out.println("iList after setting valid entries: " + java.util.Arrays.toString(d.getIList()));
        
        // Data newD = new Data(d);
        // newD.setsValue("Cat");
        // newD.cc.ccString = "Elephant";
        // System.out.println(newD.toString());
        // System.out.println(d.toString());

        // DataPackage.ContainedClass x = new DataPackage.ContainedClass();
        // x.setCcString("Gopher");
        // d.setCc(x);
        // System.out.println(d);
        // System.out.println(newD);
    }
}
