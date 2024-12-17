//Lab7
//Name: Ariana Rocha
//Andrew ID: afrocha
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;

//PART 1 && PART 3
public class Lab7Main 
{
    public Integer labYear;
    public double density;
    
    private File myFile = null;
    private Scanner fileScanner = null;
    private ArrayList<YearPop> data = null;
    
    public boolean openFile(String myFileName)
    {
        this.myFile = new File(myFileName);
        try 
        {
            this.fileScanner = new Scanner(myFile);
            return true;
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("Error: File not found -" + myFileName);
            return false;
        }
    }

    public YearPop makeData(String line) 
    {
        try
        {
            String[] parts = line.split(",");
            int year = Integer.parseInt(parts[0].trim());
            double populationDensity = Double.parseDouble(parts[1].trim());
            return new YearPop(year,populationDensity);
        }
        catch(NumberFormatException | ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Error: Invalid line format - " + line);
            return null;
        }
    }

    public void createList() 
    {
        this.data = new ArrayList<>();
        try
        {
            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                YearPop yearPop = makeData(line);
                if (yearPop !=null) {
                    data.add(yearPop);
                }
            }
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Error: Issue reading file.");
        }
    }

    public double findYear(int year) // error here to look into. Have to return double but returns int in most cases. still runs. Why double?
    {
        for (YearPop yp : data)
        {
            if (yp.getPopYear().equals(year)) 
            { 
                return yp.getPop();
            }
        }
        return -1.0;
    }

    public static void main(String[] args)
    {
        Lab7Main lab = new Lab7Main();
        Scanner inputScanner = new Scanner(System.in);

        if (lab.openFile("paPop.csv")) 
        {
            System.out.println("File opened successfully.");
            lab.createList();
            String choice; 

            do
            {
                System.out.println("Enter a year to find the popluation density: ");
                int year = inputScanner.nextInt();
                double density = lab.findYear(year);
                
                if (density != -1.0) 
                {
                    System.out.println("Year: " + year + "\nPopulation Density: " + density + "\n");
                }
                else
                {
                    System.out.println("Year" + year + "not found.\n");
                }

                System.out.println("Do you want to look up another year? (Y/N)");
                choice = inputScanner.next();
            }
            while (choice.equalsIgnoreCase("Y"));
            System.out.println("Exiting program.");
            //inputScanner.close();
        }
        else
        {
            System.out.print("Failed to open file.");
        }

        //PART 4: RANDOM RECUURSIVE METHOD -- FIBONACCI FUN TIMES!
        int first = 0;
        int second = 1;
        int n = 7;

        int result = computeFibonacci(first, second, n-1);
        System.out.println("Fibonacci #" + n + " = " + result);
        System.out.println("This is the end of Lab 7 requirements. Do you want to stay for a bit and have some fun with Fibonacci? (Y/N): ");
        String choice2 = inputScanner.next();

        while(choice2.equalsIgnoreCase("Y"))
        {
            System.out.println("For reference the 'nth' value is the degree to which you want to run the Fibonacci sequence. \n For the sake of this (due to overflow) your n must be less than 48\n Let's do some cool math, go ahead and enter a value for n (less than 47): ");
            n = inputScanner.nextInt();

            result = computeFibonacci(first, second, n-1);
            System.out.println("*Drums roll* The " + n + "th number in the Fibonacci sequence is: " + result + "!");
            System.out.println("Do you wanna have more fun with Fibonacci?? (Y/N)");
            choice2 = inputScanner.next();
        }
        System.out.println("Exiting progam -- Thanks for grading and / or playing!");
        inputScanner.close();
    }

    //PART 4: RANDOM RECURSIVE METHOD -- FIBONACCI FUN TIMES!
    public static int computeFibonacci(int first, int second, int n)
    {
        if (n == 0) 
        {
            return first;
        }
        else if (n == 1)
        {
            return second;
        }
        else
        {
            return computeFibonacci(second, first + second, n-1);
        }
    }
}
