// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 2

package com.example;

public class UserFactory {

    public static User createUser(int id, String userType, String name, String other) {
        switch (userType.toLowerCase()) {
            case "officer":
                // Parse 'other' as Rank for Officer
                Rank rank;
                try {
                    rank = Rank.valueOf(other.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid rank specified, defaulting to REGULAR.");
                    rank = Rank.REGULAR; // Default rank
                }
                return new Officer(id, name, rank);

            case "administrator":
                // 'other' represents department for Administrator
                return new Administrator(id, name, other);

            case "courtofficial":
                // 'other' represents title for CourtOfficial
                return new CourtOfficial(id, name, other);

            default:
                throw new IllegalArgumentException("Unknown user type: " + userType);
        }
    }
}
