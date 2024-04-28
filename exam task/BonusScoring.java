package AditionalTaskMidExam;

import java.util.Scanner;

public class BonusScoring {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);


        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int extraBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = Double.MIN_VALUE;
        int bestStudent = 0;

        for (int i = 1; i <= students; i++) {

            int attendance = Integer.parseInt(scanner.nextLine());
            double totalBonus = 1.0 * attendance / lectures * (5 + extraBonus);
            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                bestStudent = attendance;

            }

        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", bestStudent);
    }
}
