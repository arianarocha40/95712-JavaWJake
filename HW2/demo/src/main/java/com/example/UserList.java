// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 2

package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UserList {
    private ArrayList<User> listOfUsers;

    // Constructor
    public UserList() {
        listOfUsers = new ArrayList<>();
    }

    // Method to read users from a CSV file
    public void readUserFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String userType = parts[1].trim();
                    String name = parts[2].trim();
                    String other = parts[3].trim();

                    User user = UserFactory.createUser(id, userType, name, other);
                    listOfUsers.add(user);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user file: " + e.getMessage());
        }
    }

    // Getter to access the list of users
    public ArrayList<User> getListOfUsers() {
        return listOfUsers;
    }

    // Method to retrieve a user by ID
    public User getUserByID(int userID) {
        for (User user : listOfUsers) {
            if (user.getID() == userID) {
                return user;
            }
        }
        return null; // Return null if user not found
    }

    // Method to display all users
    public void displayUsers() {
        for (User user : listOfUsers) {
            System.out.println(user); // Assumes User has a toString() method
        }
    }

    // toString method to display all users
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (User user : listOfUsers) {
            sb.append(user.toString()).append("\n");
        }
        return sb.toString();
    }
}
