package AditionalTaskFinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapperRegex {
    public static void main(String[] args) {

        Scanner   scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(=|\\/)(?<location>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> destinations = new ArrayList<>();

        int totalSum = 0;
        while (matcher.find()) {
            String destination = matcher.group("location");
            totalSum += destination.length();
            destinations.add(destination);
        }

        System.out.println("Destinations: " + String.join(", ", destinations));
        System.out.printf("Travel Points: %d", totalSum);
    }
}
