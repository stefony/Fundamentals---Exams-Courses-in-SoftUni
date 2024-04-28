package AditionalTaskFinalExam;

import java.util.*;

public class ThePianistMAP {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> collections = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] pieces = input.split("\\|");
            String piece = pieces[0];
            String composer = pieces[1];
            String key = pieces[2];
            collections.put(piece, new ArrayList<>());
            collections.get(piece).add(composer);
            collections.get(piece).add(key);
        }

        String actions = scanner.nextLine();
        while (!actions.equals("Stop")) {
            String[] action = actions.split("\\|");
            String command = action[0];
            String piece = action[1];

            switch (command) {
                case "Add":
                    if (!collections.containsKey(piece)) {
                        collections.put(piece, new ArrayList<>());
                        collections.get(piece).add(action[2]);
                        collections.get(piece).add(action[3]);

                        System.out.printf("%s by %s in %s added to the collection!%n", piece, action[2], action[3]);
                    } else {
                        System.out.printf("%s is already in the collection!%n", piece);
                    }
                    break;
                case "Remove":
                    if (collections.containsKey(piece)) {
                        collections.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    if (collections.containsKey(piece)) {
                        collections.get(piece).set(1, action[2]);
                        System.out.printf("Changed the key of %s to %s!%n", piece, action[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            actions = scanner.nextLine();
        }
        collections.entrySet().stream().forEach(abc ->
                System.out.printf("%s -> Composer: %s, Key: %s%n", abc.getKey(), abc.getValue().get(0)
                        , abc.getValue().get(1)));
    }
}
