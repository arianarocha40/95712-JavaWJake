// Lab3
// Your name: Ariana Rocha 
// Your Andrew id: afrocha

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// class IOSTuff
// Tests some issues of input and output

//PART 1: Run and Break Stuff. Ran it well and ran it into an error when I put 100K as the salary. 
///////// It's not a double so the terminal came back with an error.

public class IOStuff {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // String firstName, lastName;
        // String id;
        // int age;
        // double salary;

        // System.out.print("Enter first name: ");
        // firstName = scanner.nextLine();

        // System.out.print("Enter last name: ");
        // lastName = scanner.nextLine();

        // System.out.print("Enter id: ");
        // id = scanner.nextLine();

        // //PART 2: Change and Try to Break Again. I can in fact still break it...

        // // PART 3: Surround Code and Try to Break. In fact it was unbreakable this time... cool!

        // try {
        // System.out.print("Enter age: ");
        // //age = scanner.nextInt();
        // String ageString = scanner.nextLine();
        // age = Integer.parseInt(ageString);

        // System.out.print("Enter salary: ");
        // // salary = scanner.nextDouble();
        // String salaryString = scanner.nextLine();
        // salary = Double.parseDouble(salaryString);
        
        // } catch (NumberFormatException e ) {
        // System.out.println(e);
        // age = 0;
        // salary = 0.0;
        // }

        // //PART 4: IDK about the intelliJ Code->Comment with Block Comment BUT I do know that CTRL+/ comments out a block... 

        // System.out.println("First Name = " + firstName);
        // System.out.println("Last Name = " + lastName);
        // System.out.println("Age = " + age);
        // System.out.println("ID = " + id);
        // System.out.println("Salary = " + salary);

        System.out.printf("%-15s %-15s %-15s %-5s %-10s %-5s%n", "First Name", "Last Name", "ID", "Age", "Salary", "Category"); 
        // System.out.printf("%-15s %-15s %-15s %-5d %-10.2f%n", firstName, lastName, id, age, salary);
 
        //Copy it into the project directory (the root Lab3 directory, *not* the src folder). "

        // PART 5. FROM A FILE... Major Confusion here ***NEED MORE PRACTICE 
        // Does the below violate the don't do a try catch thing?
        File file = new File("employee.csv");
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine(); // Reading from file
                String[] fields = line.split(","); // splitting on the comma

                String firstName = fields[0];
                String lastName = fields[1];
                String id = fields [2];
                int age =Integer.parseInt(fields[3]);
                double salary = Double.parseDouble(fields[4]);

                //PART 6
                String category = null;
                if (salary < 0 || salary > 150000) { 
                    category = "Error";
                } else if (salary >= 0 && salary <35000) {
                    category = "Low";
                } else if (salary >= 35000 && salary < 70000) {
                    category = "Medium";
                } else if (salary >= 70000 && salary <= 150000) {
                    category = "High";
                } 

                System.out.printf("%-15s %-15s %-15s %-5d %-10.2f %-10s%n", firstName, lastName, id, age, salary, category);
            }
        } catch (FileNotFoundException e) {
            System.out.println("404 File Note Found, check path, troubleshoot, and pray");
            e.printStackTrace();
        } finally {
            if(fileScanner !=null){
                fileScanner.close();
            }
        }

    }
}
