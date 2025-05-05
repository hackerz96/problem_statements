import java.util.Scanner;



//finding gcd of two numbers
public class GCD{

    // function to find gcd of two numbers
    static int gcd(int x, int y){
        // both divisible by 0
        if(x==0) return y;
        if(y==0) return x;
    
        // both nums equal
        if (x==y) return x;
    
        // x is greater than y
        if(x > y) return gcd(x-y, y);
    
        // y is greater than x
        return gcd(x, y-x);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the 1st num: ");
        int a = scn.nextInt();
        System.out.println("Enter the 2nd num: ");
        int b = scn.nextInt();
        int resultGCD = 1;
        // finding gcd
        resultGCD = gcd(a, b);
        System.out.println("The GCD of " + a + " and " + b + " is: " + resultGCD);
    }
}
