// 20)
// Develop a Java program that takes a paragraph input from the user and:
// ●	Remove all vowels (a, e, i, o, u) from the paragraph using StringBuilder.

// ●	Efficiently update the paragraph after each deletion.

// ●	Finally, display the transformed paragraph along with the count of characters 

import java.util.Scanner;
public class ParagraphEditingProgram {
    String paraInput;
    StringBuilder paraOutput = new StringBuilder();

    public ParagraphEditingProgram(String paraInput) {
        this.paraInput = paraInput;
    }
    public void removeVowels(){
        for (int i = 0; i < paraInput.length(); i++) {
            char currentChar = paraInput.charAt(i);
            if (!isVowel(currentChar)) {
                paraOutput.append(currentChar);
            }
        }
    }

    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }
        return false;
    }

    public void displayTransformedParagraph(){
        System.out.println("Transformed Paragraph: " + paraOutput.toString());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a paragraph: ");
        String inputParagraph = scanner.nextLine();
        
        ParagraphEditingProgram editor = new ParagraphEditingProgram(inputParagraph);
        editor.removeVowels();
        editor.displayTransformedParagraph();
        
        scanner.close();
    }
}
