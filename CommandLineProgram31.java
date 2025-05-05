public class CommandLineProgram31 {

    static void decimalToBinary(int n) {
        if (n == 0) {
            System.out.println("Binary representation: 0");
            return;
        }

        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);
            n = n / 2;
        }
        System.out.println("Binary representation: " + binary.toString());
    }

    static void decimalToOctal(int n) {
        if (n == 0) {
            System.out.println("Octal representation: 0");
            return;
        }

        StringBuilder octal = new StringBuilder();
        while (n > 0) {
            octal.insert(0, n % 8);
            n = n / 8;
        }
        System.out.println("Octal representation: " + octal.toString());
    }

    static void decimalToHexadecimal(int n) {
        if (n == 0) {
            System.out.println("Hexadecimal representation: 0");
            return;
        }

        StringBuilder hexadecimal = new StringBuilder();
        while (n > 0) {
            int remainder = n % 16;
            if (remainder < 10) {
                hexadecimal.insert(0, remainder);
            } else {
                hexadecimal.insert(0, (char) ('A' + remainder - 10));
            }
            n = n / 16;
        }
        System.out.println("Hexadecimal representation: " + hexadecimal.toString());
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error: Please provide exactly one argument.");
            return;
        }

        int num = 0;
        try {
            num = Integer.parseInt(args[0]);
            System.out.println("The provided number is: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Error: The argument must be a valid integer.");
            return; // Prevent further execution on invalid input
        }

        decimalToBinary(num);
        decimalToOctal(num);
        decimalToHexadecimal(num);
    }
}
