//PART 6
//Name: Ariana Rocha
//Andrew ID: afrocha

import java.util.Scanner;

public class Lab6 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Instances of obbjects
        Sensor temperature = new Sensor(0.0, 120.0, 68.0, 1.0, "kitchen", "temperature", 1);
        Device extinguisher = new Device("fire extinguisher", "kitchen", 1);
        Room kitchen = new Room(12.0, 15.0, "kitchen", 1);
        Alarm bell = new Alarm("Ding! Ding!", 1);

        // PART 7 Welcome Message and all info below
        System.out.println("Hello, World! Welcome to the Lab6 Firefighter-ish Simulation. Our motto is 'if you can't take the heat, get out of the kitchen!'");
        System.out.println("Initial Room Info:");
        System.out.println(kitchen);

        // Loop as directed for interaction
        boolean continueLoop = true;
        while (continueLoop) 
        {
            // Display current temp
            System.out.println("Current kitchen temperature: " + temperature.getCurrentValue());

            // Prompt user for a new temp value
            System.out.print("Enter a new temperature value (or type 'N' to exit): ");
            String input = scanner.nextLine();

            // Check if the user wants to exit
            if (input.equalsIgnoreCase("N")) 
            {
                continueLoop = false;
                continue;
            }

            // Update the temp
            try 
            {
                double newTemperature = Double.parseDouble(input);
                double originalTemperature = temperature.getCurrentValue(); // Save original temperature
                temperature.setCurrentValue(newTemperature);

                // Check if the sensor is tripped
                if (temperature.trip()) 
                {
                    // Actuate the extinguisher and sound the alarm
                    extinguisher.actuate();
                    bell.soundTheAlarm();
                }

                // Reset temp back to original value
                temperature.setCurrentValue(originalTemperature);
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        scanner.close();

        System.out.println("Simulation Lab6 finally ended.");
    }
}

//PART 8: Considering there are four related classes:
/*  How should they be organized? And how should they communicate with eachother? 
    See code for how I believe they should be organized and how they should communicate with eachother and brief explanation below
    a.) Class Organization:
           - Sensor monitors and reacts to changes in temperature.
           - Device performs actions when certain conditions are met.
           - Room provides contextual information about the physical space but doesn't interact directly in the simulation loop.
           - Alarm provides alert functionality.
    b.) how the communication in main's loop would occur 
           - The main method directly interacts with the sensor, device, and alarn.
           - The loop checks the current temperature from the sensor.
           - New temperature inputted by user, then is set in the sensor.
           - After updating the temp, the Sensor trips to check if the temp is outside the allowed range.
           - If it trips the Device activates fire extinguisher.
           - The Alarm sound(s)TheAlarm and temp is then reset back to original value.
*/