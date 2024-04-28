package AditionalTaskFinalExam;

import java.util.*;

public class NeedForSpeedIIIMAP {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        int numbersOfCar = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> carsInfo = new LinkedHashMap<>();


        for (int i = 0; i < numbersOfCar; i++) {
            String[] cars = scanner.nextLine().split("\\|");
            String car = cars[0];
            int mileage = Integer.parseInt(cars[1]);
            int fuel = Integer.parseInt(cars[2]);
            carsInfo.putIfAbsent(car, new ArrayList<>());

            carsInfo.get(car).add(0, mileage);
            carsInfo.get(car).add(1, fuel);
        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {

            //Commands are separated by " : "
            String[] command = input.split(" : ");
            String commandType = command[0];
            String car = command[1];

            int mileage = carsInfo.get(car).get(0);
            int fuel = carsInfo.get(car).get(1);

            switch (commandType) {
                //You have a space after Drive. The program never enters this case.
                case "Drive":
                    int fuelForDrive = Integer.parseInt(command[3]);
                    int distance = Integer.parseInt(command[2]);

                    //You never ever use this String.
                    String destination = command[2];

                    //Switch places of fuelForDrive and fuel. Maybe have better variable naming :)
                    if (fuel < fuelForDrive) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carsInfo.get(car).set(0, mileage + distance);
                        carsInfo.get(car).set(1, fuel - fuelForDrive);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuelForDrive);
                    }
                    //You need to display this printf only if the car has enough fuel for the destination. Moved in the else statement above.
                    //System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuelForDrive);

                    if (distance + mileage >= 100000) {
                        System.out.printf("Time to sell the %s!%n", car);
                        carsInfo.remove(car);
                    }
                    break;
                case "Refuel":
                    int fuelForRefuel = Integer.parseInt(command[2]);
                    int allFuel = fuelForRefuel + fuel;

                    //You don't really need that diff variable.
                    int diff = 0;

                    if (allFuel > 75) {
                        fuelForRefuel = 75 - fuel;
                        fuel = 75;
                    } else {
                        fuel += fuelForRefuel;
                    }

                    //No point to set all the fuel. Imagine if allFuel = 1000 lt.? Your car can only hold a maximum of 75 lt.
                    //carsInfo.get(car).set(1, allFuel);
                    carsInfo.get(car).set(1, fuel);
                    System.out.printf("%s refueled with %d liters%n", car, fuelForRefuel);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(command[2]);
                    int totalMileage = mileage - kilometers;

                    if (totalMileage < 10000) {
                        totalMileage = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    carsInfo.get(car).set(0, totalMileage);
                    break;
            }
            input = scanner.nextLine();
        }
        carsInfo.forEach((key, value) ->System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",key, value.get(0), value.get(1)));
    }
}
