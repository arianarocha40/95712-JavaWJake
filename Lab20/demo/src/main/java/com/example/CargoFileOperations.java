package com.example;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class CargoFileOperations {
    protected String filename;

    // Overloaded Constructor (Part 3)
    public CargoFileOperations(String filename) {
        this.filename = filename;
    }

    // Method to write the cargoList to a file
    public void writeList(ArrayList<Cargo> cargoList) {
        try (FileOutputStream FOS = new FileOutputStream(filename);
            ObjectOutputStream OOS = new ObjectOutputStream(FOS)) {
            for (Cargo cargo : cargoList) {
                try {
                    OOS.writeObject(cargo);
                } catch (IOException e) {
                    System.out.println("Failed to write object: " + e.getMessage());
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Output file failed to open: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Failed to create Object OutputStream: " + e.getMessage());
        }

    }

    // Method to read cargo list from a file
    public ArrayList<Cargo> readList() {
        ArrayList<Cargo> cargoList = new ArrayList<>();

        try (FileInputStream FIS = new FileInputStream(filename);
            ObjectInputStream OIS = new ObjectInputStream(FIS)) {
            while (FIS.available() > 0) {
                try {
                    Cargo cargo = (Cargo) OIS.readObject();
                    cargoList.add(cargo);
                } catch (ClassNotFoundException | IOException e) {
                    System.out.println("Failed to read object: " + e.getMessage());
                    return cargoList;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Failed to create ObjectInputStream: " + e.getMessage());
        }
        return cargoList;
    }

    // PART 5 
    public void display() {
        Path path = Paths.get(filename);
        System.out.println("Path: " + path.toString());
        System.out.println("Absolute Path: " + path.toAbsolutePath());
        System.out.println("Root: " + path.getRoot());

        File file = path.toFile();
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Is executable: " + Files.isExecutable(path));
        System.out.println("Is readable: " + Files.isReadable(path));
        System.out.println("Is writable: " + Files.isWritable(path));
    }
}
