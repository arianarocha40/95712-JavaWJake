package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab18 {
    public static ArrayList<Customer> readCustomers(String filename) throws IOException {

        // Array list of Customer objects
        ArrayList<Customer> list = new ArrayList<>();

        InputStream inputStream = Lab18.class.getClassLoader().getResourceAsStream(filename); // Solution to trouble reading CSV file
        if (inputStream == null) {
            throw new FileNotFoundException(filename + " not found");
        }
        
        // Use a BufferedReader with InputStreamReader for reading lines
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        
        // OLD CODE removed to accomodate for customers.csv located in resources folder ** ASK Q ABOUT OPTIMAL PLACEMENT OF CSV ***
        // // Create a new File object
        // File file = new File(filename);
        // // PART 2: If the file DNE throw FNF exception
        // if (!file.exists()) { throw new FileNotFoundException(filename + " not found");}
        // //PART 2: Otherwise create a new Scanner on the file object
        // Scanner scanner = new Scanner(file);

        // PART 2: While fileScanner has a next line
        String line;
        // while (scanner.hasNextLine()) { OLD CODE
        while ((line = reader.readLine()) != null) {
            // String line = scanner.nextLine(); // Read next line OLD CODE
            String[] parts = line.split(","); // Splitting it
            
            //Variables to hold converted values
            String firstName = parts[0];
            String lastName = parts[1];
            int rating = 0; // converted rating to int
            double balance = 0.0; 

            try {
                rating = Integer.parseInt(parts[2]); // convert rating to int 
            } catch (NumberFormatException e) { // throw exception
                System.out.println("Error parsing for line: " + line);
                rating = 0;
            }

            try {
                balance = Double.parseDouble(parts[3]); // convert balance to double
            } catch (NumberFormatException e) { // throw exception
                System.out.println("Error parsing balance for line: " + line);
                balance = 0.0;
            }

            //PART 2: Create new customer object & add to list
            Customer customer = new Customer(firstName, lastName, rating, balance);
            list.add(customer);
        }
        reader.close();

        return list;
    }

    public static void main(String[] args) {
        //ArrayList<Customer> clist = null; OLD CODE
    
        // Problem #3
        // Call readCustomers with the data file as a parameter
        try {
            ArrayList<Customer> customers = readCustomers("customers.csv");
            //ArrayList<Customer> customers = readCustomers("Bob.csv"); PART 8 verifying FileNotFound Exception -- VERIFIED 
 
            // Print the array list
            System.out.println("Original list: ");
            for (Customer customer : customers) {
                System.out.println(customer);
            }

            // Problem #4
            // Create PriorityQueue queue1
            PriorityQueue<Customer> queue1 = new PriorityQueue<>();
            for (Customer customer : customers) {
                try {
                    queue1.add(customer);
                } catch (Exception e) {
                    System.out.println("Error adding customer to queue1: " + customer);
                }
            }

            // Problem #5
            // Create PriorityQueue queue2
            PriorityQueue<Customer> queue2 = new PriorityQueue<>(Comparator.comparingDouble(Customer::getBalance));
            for (Customer customer : customers) {
                try {
                    queue2.add(customer);
                } catch (Exception e) {
                    System.out.println("Error adding customer to queue2: " + customer);
                }
            }

            // Problem #6
            // Remove things one at a time from queue1 and print them
            System.out.println("\nQueue 1 processing:");
            while (true) {
                try {
                    Customer customer = queue1.element(); // Get the element at the head of the queue
                    System.out.println(customer);
                    queue1.remove(); // Remove the head element
                } catch (Exception e) {
                    System.out.println("Done");
                    break;
                }
            }

            // Problem #7
            // Remove things one at a time from queue2 and print them
            System.out.println("\nQueue 2 processing:");
            while (true) {
                try {
                    Customer customer = queue2.element(); // Get the element at the head of the queue
                    System.out.println(customer);
                    queue2.remove(); // Remove the head element
                } catch (Exception e) {
                    System.out.println("Done\n");
                    break;
                }
            }
            
            // Problem #9
            problem9();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1); 
        }

        // Problem #8
        // Integer parsing failed & caught: VERIFIED
        // Double parsing failed & caught: VERIFIED
        // FileNotFound Exception thrown & caught: VERIFIED
    }
    
    public static void problem9() throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        
        // Load testdata.txt from resources
        InputStream inputStream = Lab18.class.getClassLoader().getResourceAsStream("testdata.txt");
        if (inputStream == null) {
            throw new FileNotFoundException("testdata.txt not found");
        }
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

        // Define patterns as per the requirements
        ArrayList<String> patterns = new ArrayList<>();
        patterns.add(".*\\d+.*"); // Lines containing any digit
        patterns.add(".*[a-zA-Z]+.*"); // Lines containing any letter, either case
        patterns.add("^\\d+$"); // Lines containing an integer
        patterns.add("^a.*"); // Any line that begins with the letter "a"
        patterns.add(".*s$"); // Any line that ends with the letter "s"
        patterns.add(".*\\(.*"); // Any line that contains a left parenthesis
        patterns.add(".*a.*e.*|.*e.*a.*"); // Lines containing "a" and "e" in either order
        patterns.add(".*aeiou.*"); // Lines containing lowercase vowels in order (a, e, i, o, u)
        patterns.add(".*a.*e.*i.*o.*u.*"); // Lines containing lowercase vowels in order but not necessarily adjacent

        // Loop over each pattern and find matching lines
        for (String patternStr : patterns) {
            System.out.println("Pattern: " + patternStr);
            Pattern pattern = Pattern.compile(patternStr);
            
            for (String textLine : lines) {
                Matcher matcher = pattern.matcher(textLine);
                if (matcher.find()) {
                    System.out.println("Matched: " + textLine);
                }
            }
            System.out.println(); // Print a blank line for readability between patterns
        }
    }

}
