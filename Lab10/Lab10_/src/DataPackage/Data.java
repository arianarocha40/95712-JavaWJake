package DataPackage;

//import java.util.ArrayList;
//import java.util.Arrays;

public class Data {
    //fields to be private to make encapsulation
    private int iValue = 10;
    private String sValue = "a string";
    private int[] iList = {12, 15, 20};
    private ContainedClass cc;
    //ArrayList<Integer> aList = new ArrayList<>();
    //DataPackage.ContainedClass cc = new DataPackage.ContainedClass();

    //Constructor
    public Data() 
    {
        // iList = new int[4];
    }

    //Getter
    public int getiValue() {return iValue;}

    //Setter
    public void setiValue(int Value)
    {
        if(Value > 0) {this.iValue = Value;}
    }

    //Getter for sValue
    public String getsValue() {return sValue;}

    //Setter for sValue
    public void setsValue(String sValue)
    {
        if (sValue.length() <= 10) {this.sValue = sValue;}
    }


    public int[] getIList() 
        {return iList.clone();}
    
    public void setIList(int[] iList)  
    {
        if (iList.length <=4)
        {
            for (int i : iList) 
            { 
                if (i<10 || i>20) {return;}
            }
            this.iList = iList.clone();
        } 
    }

    // Getter for CC
    public ContainedClass getCc() 
        {return new ContainedClass(cc);}
    
    // Setter for CC
    public void setCc(ContainedClass cc) 
    {
        if (cc != null) {
            this.cc = new ContainedClass(cc);  
        }
    }



    // Data() {
    //     for (int i=0; i<iList.length; i++) {
    //         aList.add(iList[i]);
    //     }
    //     cc.ccString = "a contained string";
    // }

    // Data(Data d) {
    //     this.iValue = d.iValue;
    //     this.sValue = d.sValue;
    //     this.iList = d.iList;
    //     this.aList = d.aList;
    //     this.cc  = d.cc;
    // }

    // @Override
    // public String toString() {
    //     return "DataPackage.Data{" +
    //             "iValue=" + iValue +
    //             ", sValue='" + sValue + '\'' +
    //             ", iList=" + Arrays.toString(iList) +
    //             ", aList=" + aList +
    //             ", cc = " + cc.ccString +
    //             '}';
    // }

    // public void setiValue(int iValue) {
    //     this.iValue = iValue;
    // }

    // public void setsValue(String sValue) {
    //     this.sValue = sValue;
    // }

    // public void setiList(int[] iList) {
    //     this.iList = iList;
    // }

    // public void setaList(ArrayList<Integer> aList) {
    //     this.aList = aList;
    // }

    // public void setCc(DataPackage.ContainedClass cc) {
    //     this.cc = cc;
    // }
}
