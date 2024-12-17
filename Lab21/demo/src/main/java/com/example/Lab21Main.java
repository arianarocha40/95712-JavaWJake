package com.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Lab21Main {
    public static void main(String[] args) {
        // 2. Instantiate Lab21Main and use Reflection to get Class<?> for Employee
        try {
            Lab21Main lab = new Lab21Main();                    // Create instance of Lab21Main
            Class<?> c = Class.forName("com.example.Employee"); // had issues with class so just put it into lab format used previously (probably messed up step 1 somehow)
            lab.classFun(c);                                    // Call classFun with Employee class object as parameter
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. Define classFun() to work with Reflection on the Employee class
    void classFun(Class<?> c) {
        try {
            //3b. Canonical Name
            System.out.println("Canonical Name: " + c.getCanonicalName());

            //3c. Member data
            System.out.println("Fields: ");
            Field[] fields = c.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                System.out.println((i+1) + ": " + fields[i]);
            }

            //3d. Constructors
            System.out.println("Declared Constructors: ");
            Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();
            for (int i = 0; i < declaredConstructors.length; i++) {
                System.out.println((i+1) + ": " + declaredConstructors[i]);
            }
            
            System.out.println("Public Constructors: ");
            Constructor<?>[] constructors = c.getConstructors();
            for (int i = 0; i < constructors.length; i++) {
                System.out.println((i+1) + ": " + constructors[i]);
            }
            
            //3e. Methods
            System.out.println("Declared Methods: ");
            Method[] declaredMethods = c.getDeclaredMethods();
            for(int i = 0; i < declaredMethods.length; i++) {
                System.out.println((i + 1) + ": " + declaredMethods[i]);
            }

            System.out.println("Public Methods: ");
            Method[] publicMethods = c.getMethods(); //*****************************//
            for(int i = 0; i < publicMethods.length; i++) {
                System.out.println((i + 1) + ": " + publicMethods[i]);
            }
          
            //4. Instantiating employee OBJ with default constructor
            Object employeeInstance = c.getDeclaredConstructor().newInstance(); 
            System.out.println("Is Enum: " + c.isEnum());
            System.out.println("Is Interface: " + c.isInterface());
            System.out.println("Employee toString(): " + employeeInstance.toString());

            //(5.) Salary Stuff
            Method setSalaryMethod = find(publicMethods, "setSalary"); //*****************************//
            if (setSalaryMethod != null) {
                setSalaryMethod.invoke(employeeInstance, 1000.0); // Set salary to 1000.0
            }

            Method getSalaryMethod = find(publicMethods, "getSalary"); //*****************************//
            if (getSalaryMethod !=null) {
                System.out.println("Updated Salary: " + getSalaryMethod.invoke(employeeInstance));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Helper method - fine method 
    private static Method find(Method[] methods, String what) {
        for (Method m: methods) {
            if(m.toString().contains(what)) {
                return m;
            }
        } 
        return null;
    }
}
