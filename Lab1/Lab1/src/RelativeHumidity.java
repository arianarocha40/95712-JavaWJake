import java.util.Scanner;

// Your name: Ariana Rocha
// Your Andrew id: afrocha

// class RelativeHumidity
// Prompts the user for the temperature and dewpoint in Fahrenheit.
// Converts them to Celsius.
// Computes the saturation for each.
// Computes and displays the relative humidity.
public class RelativeHumidity {

	public static void main(String[] args) {

        // Don't change this code
		RelativeHumidity relativeHumidity = new RelativeHumidity();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the temperature in Fahrenheit: ");
		double temperature = scanner.nextDouble();
		System.out.print("Enter the dewpoint in Fahrenheit: ");
		double dewpoint = scanner.nextDouble();
		System.out.println("You entered:");
		System.out.println("temperature: " + temperature);
		System.out.println("dewpoint: " + dewpoint);
		
        // Converting from Farenheit Value Given to Celsius
        double temperatureInCelsius = (temperature-32)*(5.0/9.0);
		System.out.println("Your Temperature in Celcius:" + temperatureInCelsius);
		
        // Computing the saturations sT (temperature) and sD (dewpoint)
        double saturationValueTemperature = Math.pow(((17.625*temperatureInCelsius)/(243.05+temperatureInCelsius)), 2);
        double saturationValueDewPoint = Math.pow(((17.625*dewpoint)/(243.05+dewpoint)), 2);
		System.out.println("Your Saturation Value of the Temperature: " + saturationValueTemperature);
		System.out.println("Your Saturation Value of the Dew Point: " + saturationValueDewPoint);
        
		// Computing the relative humidity
        double relativeHumidity2 = 100*(saturationValueDewPoint/saturationValueTemperature);
		System.out.println("Your Relative Humidity given your inputs: " + relativeHumidity2);

		//Final requirement from the Lab1 prompt is to run the code with today's weather information (27AUG2024):
		// Tempurature = 75 F 
		// Dew Point = 66.2
		
	}
	
}
