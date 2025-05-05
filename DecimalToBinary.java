// Problem: Decimal to Binary
public class DecimalToBinary {
    public static void main(String[] args) {
        int deicmalNumber = 4;
        StringBuilder binaryNumber = new StringBuilder();
        while (deicmalNumber > 0) {
            int remainder = deicmalNumber % 2;
            binaryNumber.insert(0, remainder); // Insert at the beginning
            deicmalNumber = deicmalNumber / 2;
        }
        System.out.println("Binary number is: " + binaryNumber.toString());
    }
}
