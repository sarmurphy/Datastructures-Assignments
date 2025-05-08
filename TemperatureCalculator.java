/*
  Calculate the avarage temperature, and give how many days are above the avarage temperature
  1. Take an input from the user (eg. 5)
  2. Prompt the user to enter all the 5 numbers (temperature values)
  3. Calculate the avarage temperature
  4. Given the avarage temperature, how many of the numbers in the line 2 are above the avarage temperature?
 */

import java.util.Scanner;

public class TemperatureCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. User input for 5 different temperature readings
        System.out.print("Enter the number of days for temperature readings: ");
        int numberOfTemps = scanner.nextInt();

        if (numberOfTemps <= 0) {
            System.out.println("Number of readings must be greater than 0.");
        }

        // 2. Prompting user for the temperature readings
        double[] temperatures = new double[numberOfTemps];
        double sum = 0;

        for (int i = 0; i < numberOfTemps; i++) {
            System.out.println("Enter temperature " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
            sum += temperatures[i];
        }

        // 3. Calculating average temperature
        double averageTemp = sum / numberOfTemps;
        System.out.println("Average temperature: " + averageTemp);

        // 4. Displaying the number of temperatures above the average
        int aboveAverage = 0;
        for (double temp : temperatures) {
            if (temp > averageTemp) {
                aboveAverage ++;
            }
        }

        System.out.println("Number of days with a temperature above the average: " + aboveAverage);
        System.out.println();

        scanner.close();
    }
}