package com.example;

import java.io.FileOutputStream;

public class Account {
    String firstName;
    String lastName;
    int ID;
    double balance;
    int userName;

    public String getfirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public int getID() {return ID;}
    public int setID(int ID) {this.ID = ID;}


    //Writes arrayList of accounts to a file 
    public static void writeAccountsToFile(ArrayList<Account> accounts, String filename) {
        try (FileOutputStream FOS = new FileOutputStream(filename);
            ObjectOutputStream OOS = new ObjectOutputStream(fileOut)) {
                for (int i = 0; i < list.size(); i++) {
                    out.write.Object(list.get(i));
                }
            }
    } void 

}
