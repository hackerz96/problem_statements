import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLFinder {
    // Private field
    private String url;

    // Constructor
    public URLFinder(String url){
        this.url = url;
    }

    // Method to check if input URL is valid
    public boolean urlChecker(String inputUrl){
        String urlRegex = "^(http|https)://[a-zA-Z0-9\\-._]+\\.[a-zA-Z]{2,6}(/\\S*)?$";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(inputUrl);
        return matcher.matches();
    }

    // Main method as TestURLFinder
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a URL to check:");
        String userInput = scn.nextLine();

        URLFinder finder = new URLFinder(userInput);
        boolean isValid = finder.urlChecker(userInput);

        if (isValid){
            System.out.println("The URL is valid.");
        } else {
            System.out.println("The URL is NOT valid.");
        }

        scn.close();
    }
}
