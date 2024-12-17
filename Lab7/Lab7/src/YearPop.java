//Lab7
//Name: Ariana Rocha
//Andrew ID: afrocha

//PART 2
public class YearPop {

    private Integer popYear;
    private double pop;

    public YearPop() 
    {
        //default constructor
        this.popYear = 0;
        this.pop = 0.0;
    }

    public YearPop(Integer popYear, double pop)
    {
        //overload constructot
        this.popYear = popYear;
        this.pop =pop;
    }
        //getter NO setter
        public Integer getPopYear() {return popYear;}
        public double getPop () {return pop;}
        

    public static void main(String[] args)
    {
        YearPop yp = new YearPop(1995, 179.2);
        System.out.println("Year: " + yp.getPopYear() + ", Population Density: " + yp.getPop());
    }
}
