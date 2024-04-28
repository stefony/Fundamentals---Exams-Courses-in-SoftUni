package AditionalTaskFinalExam;

import java.util.*;

public class PlantDiscoveryMap {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> collection = new LinkedHashMap<>();
        Map<String, List<Double>> rating = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String[] plants = scanner.nextLine().split("<->");
            String plant = plants[0];
            int rarity = Integer.parseInt(plants[1]);
            collection.put(plant, rarity);
            rating.putIfAbsent(plant, new ArrayList<>() );

        }
        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] command = input.split(": ");
            String[] newArray = command[1].split(" - ");
            String plant = newArray[0];
            if (!collection.containsKey(plant)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }

            switch (command[0]) {
                case "Rate":
                    double rate = Double.parseDouble(newArray[1]);
                    rating.get(plant).add(rate);
                    break;
                case "Update":
                    int rarityUpdate = Integer.parseInt(newArray[1]);
                    collection.put(plant, rarityUpdate);
                    break;
                case "Reset":
                    rating.get(plant).clear();
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        collection.forEach((key, value) -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                key, value, rating.get(key).stream()
                        .mapToDouble(Double::doubleValue).average()
                        .orElse(0.0)));
    }
}
