import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> wordMap = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ");
            String command = parts[0];

            if (command.equals("add")) {
                String word = parts[1];
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);

            } else if (command.equals("remove")) {
                String word = parts[1];
                if (wordMap.containsKey(word)) {
                    int count = wordMap.get(word);
                    if (count == 1) {
                        wordMap.remove(word);
                    } else {
                        wordMap.put(word, count - 1);
                    }
                }

            } else if (command.equals("query")) {
                String word = parts[1];
                int count = wordMap.getOrDefault(word, 0);
                System.out.println("Frequency of '" + word + "': " + count);

            } else if (command.equals("mostFrequent")) {
                if (wordMap.isEmpty()) {
                    System.out.println("No words present");
                } else {
                    String mostWord = "";
                    int max = -1;

                    for (String word : wordMap.keySet()) {
                        int count = wordMap.get(word);
                        if (count > max || (count == max && word.compareTo(mostWord) < 0)) {
                            max = count;
                            mostWord = word;
                        }
                    }

                    System.out.println("Most frequent word: " + mostWord);
                }

            } else {
                System.out.println("Unknown command.");
            }
        }

        scanner.close();
    }
}
