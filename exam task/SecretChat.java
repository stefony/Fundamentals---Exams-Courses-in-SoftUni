package AditionalTaskFinalExam;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] command = input.split(":\\|:");
            switch (command[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(command[1]);
                    text.insert(index, " ");
                    System.out.println(text);
                    break;
                case "Reverse":
                    String textToReverse = command[1];
                    StringBuilder reversedText = new StringBuilder();
                    if (text.toString().contains(textToReverse)) {
                        for (int i = textToReverse.length()-1; i >= 0; i--) {
                            char symbol = textToReverse.charAt(i);
                            reversedText.append(symbol);
                        }
                        int startIndex = text.toString().indexOf(command[1]);
                        text.delete(startIndex, startIndex + textToReverse.length());
                        text.insert(startIndex, reversedText);
                        System.out.println(text);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String toReplace = text.toString();
                    int indexToRemove = toReplace.indexOf(command[1]);
                    while (indexToRemove != -1) {
                        toReplace = toReplace.replace(command[1], command[2]);
                        indexToRemove = toReplace.indexOf(command[1]);
                        text.delete(0, text.length());
                        text.append(toReplace);
                    }
                    System.out.println(text);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", text);
    }
}
