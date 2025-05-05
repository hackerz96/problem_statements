public class RemoveWhiteSpaces{
    public static void main(String[] args) {
        String str = "Hello World! Welcome to the world of Java Programming.";
        System.out.println("Original String: " + str);

        // removing white spaces from the string
        StringBuilder removeWhiteSpace = new StringBuilder(str);
        for(int i=0; i<removeWhiteSpace.length(); i++){
            if(removeWhiteSpace.charAt(i) == ' '){
                removeWhiteSpace.deleteCharAt(i);
                i--; // Decrement i to account for the removed character
            }
        }
        System.out.println("String after removing white spaces: " + removeWhiteSpace.toString());
        
    }
}