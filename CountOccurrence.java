public class CountOccurrence {
    public static void main(String[] args) {
        String str = "Hello World! Welcome to The World of Wierdness of Java Programming where we learn many wierd things!";
        char charToCount = 'W';
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == charToCount){
                count++;
            }
        }
        System.out.println("The character '" + charToCount + "' occurs " + count + " times in the string.");
    }    
}
