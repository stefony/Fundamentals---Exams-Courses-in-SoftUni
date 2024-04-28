package AditionalTaskFinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetectorRegex {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("((:{2}|\\*{2}))(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);
        int count = 0;

        StringBuilder stringNumbers = new StringBuilder(getNumbers(text));
        int threshold = getSum(stringNumbers);

        List<String> emojiList = new ArrayList<>();

        while (matcher.find()) {
            count++;
            String emoji = matcher.group("emoji");
            int sumElements = getSumElements(emoji);

            if (sumElements > threshold) {
                emojiList.add(matcher.group());
            }
        }
        System.out.println("Cool threshold: " + threshold);
        System.out.println(count + " emojis found in the text. The cool ones are:");
        emojiList.forEach(System.out::println);

    }

    private static int getSumElements(String emoji) {
        int sum = 0;
        for (char symbol : emoji.toString().toCharArray()) {
            sum += (char) symbol;
        }
        return sum;
    }

    private static int getSum(StringBuilder stringNumbers) {
        int sum = 1;
        for (char symbol : stringNumbers.toString().toCharArray()) {
            int number = Integer.parseInt(String.valueOf(symbol));
            sum *= number;
        }
        return sum;
    }

    private static String getNumbers(String text) {
        StringBuilder numbers = new StringBuilder();
        for (char symbol : text.toCharArray()) {
            char currentSymbol = symbol;
            if (Character.isDigit(currentSymbol)) {
                numbers.append(currentSymbol);
            }
        }
        return numbers.toString();
    }
}
