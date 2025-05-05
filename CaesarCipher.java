import java.util.Scanner;

public class CaesarCipher {
    private String inputAlphabets;
    private String shiftedAlphabets;
    private int mainKey;

    // Constructor
    public CaesarCipher(int key){
        this.mainKey = key % 52;
        this.inputAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        this.shiftedAlphabets = inputAlphabets.substring(this.mainKey) + inputAlphabets.substring(0, this.mainKey);
    }

    // Encrypt method
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder();
        for (char ch : input.toCharArray()){
            int idx = inputAlphabets.indexOf(ch);
            if(idx != -1){
                encrypted.append(shiftedAlphabets.charAt(idx));
            } else {
                encrypted.append(ch); // Keep non-alphabet characters
            }
        }
        return encrypted.toString();
    }

    // Decrypt method
    public String decrypt(String input){
        CaesarCipher reverseCipher = new CaesarCipher(52 - mainKey);
        return reverseCipher.encrypt(input); // Reuse encrypt logic
    }

    // Main method (TestCaesarCipher logic)
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a message to encrypt:");
        String message = scn.nextLine();

        int key = 18;
        CaesarCipher cc = new CaesarCipher(key);

        String encrypted = cc.encrypt(message);
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted Text: " + decrypted);

        scn.close();
    }
}
