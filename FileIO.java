import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileIO {

    public static void main(String[] args) {
        File file = new File("testFile.txt");

        if (file.exists()) {
            System.out.println("File exists: " + file.getAbsolutePath());
        } else {
            System.out.println("File does not exist.");
            return;
        }

        int charCount = 0;
        int wordCount = 0;
        StringBuilder content = new StringBuilder();

        // Reading the file
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
                charCount += line.length();

                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            System.out.println("\nOriginal File Content:");
            System.out.println(content.toString());

            System.out.println("Number of characters in the file: " + charCount);
            System.out.println("Number of words in the file: " + wordCount);

        } catch (Exception e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
