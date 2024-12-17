import java.util.Scanner;

public class Lab13Driver {
    public static Scanner scanner = new Scanner(System.in);

    // Problem 1
    public static void problem1() {
        System.out.print("Enter a day of the week: ");
        String entry = scanner.nextLine();

        if (!BadWeekday.WEEKDAYS.contains(entry)) {
            System.out.println("Bad day entered");
        } else {
            System.out.println(entry + " - Nice job!");
        }
        System.out.println(); // Blank line as required
    }

    // Problem 2
    public static void problem2() throws BadWeekday {
        System.out.print("Enter a day of the week: ");
        String entry = scanner.nextLine();

        if (!BadWeekday.WEEKDAYS.contains(entry)) {
            throw new BadWeekday("Bad day entered");
        } else {
            System.out.println("Nice job!");
        }
    }

    // Problem 3
    public static void problem3() {
        try {
            problem2();
        } catch (BadWeekday e) {
            System.out.println(e.getMessage());
        }
    }

    // Problem 4
    public static void problem4() throws BadWeekday {
        problem2();  // Calls problem2 and throws exception up
    }

    // Problem 5
    public static void problem5() throws BadWeekday {
        try {
            problem2();
        } catch (BadWeekday e) {
            System.out.println("Caught " + e.getMessage());
            throw e;  // Re-throws the exception
        }
    }

    // Problem 6
    public static void problem6() throws BadWeekday {
        problem2();  // Calls problem2 with throws
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("Problem 1:");

        try{
            if(args.length == 0) {
            problem1();
            throw new Exception("Testing");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        problem1();  // Calls problem1

        System.out.println("Problem 2:");
        try {
            problem2();  // Calls problem2 with try-catch
        } catch (BadWeekday e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Problem 3:");
        problem3();  // Calls problem3

        System.out.println("Problem 4:");
        try {
            problem4();  // Calls problem4 with try-catch
        } catch (BadWeekday e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Problem 5:");
        try {
            problem5();  // Calls problem5
        } catch (BadWeekday e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Problem 6:");
        try {
            problem6();  // Calls problem6
        } catch (BadWeekday e) {
            System.out.println(e.getMessage());
        }
    }
}
