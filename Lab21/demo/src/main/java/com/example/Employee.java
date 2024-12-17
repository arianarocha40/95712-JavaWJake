package com.example;

public class Employee {
    private String firstName;
    private String lastName;
    private String id;
    private double salary;
 
    public Employee(String firstName, String lastName, String id, double salary) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.id = id;
       this.salary = salary;
    }
 
    public Employee() {
       this.firstName = "";
       this.lastName = "";
       this.id = "";
       this.salary = 0.0;
    }
 
    public String getFirstName() {
       return this.firstName;
    }
 
    public void setFirstName(String firstName) {
       this.firstName = firstName;
    }
 
    public String getLastName() {
       return this.lastName;
    }
 
    public void setLastName(String lastName) {
       this.lastName = lastName;
    }
 
    public String getId() {
       return this.id;
    }
 
    public void setId(String id) {
       this.id = id;
    }
 
    public double getSalary() {
       return this.salary;
    }
 
    public void setSalary(double salary) {
       this.salary = salary;
    }
 
    public void giveRaise(double percent) {
       this.salary += this.salary * percent;
    }
 
    public String toString() {
       return String.format("%8s %10s %6s %10.2f\n", this.firstName, this.lastName, this.id, this.salary);
    }
 }
 