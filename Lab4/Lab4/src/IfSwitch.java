// Lab4
// Your name: Ariana Rocha
// Your Andrew id: afrocha
// PART 1 & 2: CREATE & TEST RUN

import java.util.Scanner;

public class IfSwitch {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int feet, inches;
        int height;
        String gender;
        int heightInches;

        System.out.println("Height Comparison");
        System.out.println("You'll be asked for your height as feet and inches");
        System.out.print("Enter the feet part of your height: ");
        feet = scanner.nextInt();
        System.out.print("Enter the inches part of your height: ");
        inches = scanner.nextInt();
        System.out.println("You entered " + feet + " ft " + inches + " inches");

        //PART 3: Compute & Display Height in Inches
        heightInches = (feet*12)+inches;
        System.out.println("Your height in inches is: " + heightInches);
        
        //PART 4: Gender Inputs
        //Next INT and Next line double methods leave a character in the buffer
        //this leads to errors with user inputting data because the program thinks they already did
        scanner.nextLine();
        System.out.println("Enter your gender (M or F): ");
        gender = scanner.nextLine();
        if (gender.equalsIgnoreCase("M")) {
            System.out.println("Your gender is: " + gender);
        }
        else if (gender.equalsIgnoreCase("F")) {
            System.out.println("Your gender is: " + gender);
        }
        else {
            System.out.println("Your gender is: F");
        }

        //PART 6: ERROR CHECK W/ IF STATEMENTS

        if (heightInches < 21 || heightInches > 107) {
            System.out.println("ERROR INVALID HEIGHT INPUT:\nUnless you are the shortest or tallest person on record, \nyou are not the height you inputted.\nWe are recording that you are the average height for your gender");
            if (gender.equalsIgnoreCase("F")) {
                height = 69;
                System.out.println("Your height is recorded as " + height); 
            }
            else if (gender.equalsIgnoreCase("M")) {
                height = 64;
                System.out.println("Your height is recorded as " + height); 
            }
        }

        //PART 5: Height & Gender Comment
        if (heightInches < 64 && gender.equalsIgnoreCase("F")) {
            System.out.println("You're shorter than average");
        }
        else if (heightInches >= 64 && gender.equalsIgnoreCase("F")) {
            System.out.println("You're taller than average");
        }
        else if (heightInches < 69 && gender.equalsIgnoreCase("M")) {
            System.out.println("You're shorter than average");
        }
        else if (heightInches >= 69 && gender.equalsIgnoreCase("M")) {
            System.out.println("You're taller than average");
        }

        //PART 7: SAME AS 5 USING SWITCH STATEMENT
        //Tested this by commenting out part 5, it all still worked :)
        switch (gender.toUpperCase()) {
            case "F": System.out.println("Your height is: " + heightInches);
                if (heightInches < 64) {
                    System.out.println("You're shorter than average");
                }
                else if (heightInches >= 64) {
                    System.out.println("You're taller than average");
                }
                break;
            case "M": System.out.println("Your height is: " + heightInches);
                if (heightInches < 69) {
                    System.out.println("You're shorter than average");
                }
                else if (heightInches >= 69) {
                    System.out.println("You're taller than average");
                }
                break;
            default: System.out.println("ERROR:INVALID GENDER INPUT, CONGRATS! You're now registered as Female");
                gender = "F";
                break;
        }

        //PART 8: TEST SCORES & SWITCHES
        System.out.print("Enter your grade in the form of a numerical score: ");
        Scanner scanner = new Scanner(System.in); 
        int grade = scanner.nextInt( ); 
        String letterGrade;
        double GPA;

        switch ( grade /10) {
            case 10: 
            case 9: 
                letterGrade = "A";
                System.out.println("Your letter grade is: " + letterGrade); 
                break;
            case 8: 
                letterGrade = "B";
                System.out.println("Your letter grade is: " + letterGrade); 
                break;
            case 7: 
                letterGrade = "C";
                System.out.println("Your letter grade is: " + letterGrade); 
                break;
            case 6: 
                letterGrade = "D";
                System.out.println("Your letter grade is: " + letterGrade); 
                break;
            default: 
                letterGrade = "F";
                System.out.println("Your letter grade is: " + letterGrade); 
                break;
        }

        switch ( letterGrade ) { 
            case "A": 
                GPA = 4.0;
                System.out.println("Your GPA is: " + GPA); 
                break;
            case "B": 
                GPA = 3.0;
                System.out.println("Your GPA is: " + GPA); 
                break;
            case "C": 
                GPA = 2.0;
                System.out.println("Your GPA is: " + GPA); 
                break;
            case "D": 
                GPA = 1.0;
                System.out.println("Your GPA is: " + GPA); 
                break;
            default: 
                GPA = 0.0;;
                System.out.println("Your GPA is: " + GPA); 
                break;
        }
    }
}
