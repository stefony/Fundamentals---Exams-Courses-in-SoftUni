package AditionalTaskFinalExam;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());

       String[] commandLine = scanner.nextLine().split("\\|");

        while(!commandLine[0].equals("Decode")) {
            String command = commandLine[0];
             switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(commandLine[1]);
                    String substring = message.substring(0, numberOfLetters);
                     message.replace(0, numberOfLetters, "");
                    message.append(substring);
                    break;

                case "Insert":
                    int index = Integer.parseInt(commandLine[1]);
                    String value = commandLine[2];
                     message.insert(index, value);
                    break;

                case "ChangeAll":
                    String replaced = commandLine[1];
                    String replacement = commandLine[2];
                    String messageString = message.toString();
                    if (messageString.contains(replaced)) {
                        messageString = messageString.replace(replaced, replacement);
                    }
                    message = new StringBuilder(messageString);
                    break;
            }

            commandLine = scanner.nextLine().split("\\|");
        }

       System.out.printf("The decrypted message is: %s", message);
    }
}
