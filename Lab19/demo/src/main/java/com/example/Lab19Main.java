// Java Lab19
// Name: Ariana Rocha
// AndrewID: afrocha

package com.example;
import java.io.*;
import java.util.Scanner;

public class Lab19Main {

    // Method1 for printWriterTest
    public static long printWriterTest(String fileName, int n) throws IOException {
        long startTime = System.nanoTime();
        // Using PrintWriter with BufferedWriter and FileWriter using slide13 Lesson19
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        for (int i = 0; i < n; i++) {
            writer.print('A');  // Using print(char) as specified
        }
        writer.close();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Method2 for bufferWriterTest
    public static long bufferWriterTest(String fileName, int n) throws IOException {
        long startTime = System.nanoTime();
        // Using BufferedWriter with FileWriter
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < n; i++) {
            writer.write('A');  // Using write(char) as required
        }
        writer.close();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Method3 for fileWriterTest
    public static long fileWriterTest(String fileName, int n) throws IOException {
        long startTime = System.nanoTime();
        // Using only FileWriter
        FileWriter writer = new FileWriter(fileName);
        for (int i = 0; i < n; i++) {
            writer.write('A');  // Using write(char) as specified
        }
        writer.close();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Method4 for scannerTest
    public static long scannerTest(String fileName, int n) throws IOException {
        long startTime = System.nanoTime();
        // Using Scanner with BufferedReader and FileReader as per slide13 L19
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        scanner.useDelimiter("");  // Ensures single characters are read
        for (int i = 0; i < n; i++) {
            scanner.next().charAt(0);  // Reading single characters as required
        }
        scanner.close();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Method5 for bufferedReaderTest
    public static long bufferedReaderTest(String fileName, int n) throws IOException {
        long startTime = System.nanoTime();
        // Using BufferedReader with FileReader
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        for (int i = 0; i < n; i++) {
            reader.read();  // Using read() to read single characters
        }
        reader.close();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Method6 for fileReaderTest
    public static long fileReaderTest(String fileName, int n) throws IOException {
        long startTime = System.nanoTime();
        // Using only FileReader
        FileReader reader = new FileReader(fileName);
        for (int i = 0; i < n; i++) {
            reader.read();  // Using read() to read single characters
        }
        reader.close();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Main method for testing
    public static void main(String[] args) throws IOException {
        String fileName = "test.txt";
        int[] testSizes = {10000, 1000000};

        for (int n : testSizes) {
            System.out.println("Testing with n = " + n);

            System.out.printf("printWriterTest: %15d ns\n", printWriterTest(fileName, n));
            System.out.printf("bufferWriterTest: %15d ns\n", bufferWriterTest(fileName, n));
            System.out.printf("fileWriterTest: %15d ns\n", fileWriterTest(fileName, n));
            System.out.printf("scannerTest: %15d ns\n", scannerTest(fileName, n));
            System.out.printf("bufferedReaderTest: %15d ns\n", bufferedReaderTest(fileName, n));
            System.out.printf("fileReaderTest: %15d ns\n", fileReaderTest(fileName, n));

            System.out.println();
        }
    }
}
