package com.vdx;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by gupta.g on 31/01/21
 */
public class StatisticsCalculator {
    public static void main(String[] args) throws Exception {
        System.out.println("Statistics Calculator Documentation");
        System.out.println("Enter 1 for adding a new event followed by value. Format: 1 {value}");
        System.out.println("Enter 2 for calculating mean");
        System.out.println("Enter 3 for calculating variance");
        System.out.println("Enter 4 for calculating Max");
        System.out.println("Enter 5 for calculating Min");
        System.out.println("Enter 6 for exit");

        Statistic statistic = new Statistic();
        boolean stopExecution = false;
        while (!stopExecution) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String inputString = bufferedReader.readLine().trim();
            if (inputString.length() == 0)
                throw new InvalidInputException("Malformed Input. Please read the documentation for possible inputs");

            String[] input = inputString.split("\\s+");
            int option = Integer.parseInt(input[0]);
            switch (option) {
                case 1:
                    if (input.length != 2)
                        throw new InvalidInputException("Wrong event Input. Please provide in following format. Format: 1 {value}.");
                    statistic.event(Integer.parseInt(input[1]));
                    break;
                case 2:
                    System.out.println("Mean = " + statistic.mean());
                    break;
                case 3:
                    System.out.println("Variance = " + statistic.variance());
                    break;
                case 4:
                    System.out.println("Max = " + statistic.maximum());
                    break;
                case 5:
                    System.out.println("Min = " + statistic.minimum());
                    break;
                case 6:
                    stopExecution = true;
                    System.out.println("Stopping Statistics Calculator Execution");
                    break;
                default:
                    throw new InvalidInputException("Malformed Input. Please read the documentation for possible inputs");
            }
        }
    }
}
