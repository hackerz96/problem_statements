
public class PascalsTriangle {
   public static void main(String[] args) {
    int n = 5;

    System.out.println("Pascal's Triangle:");
    for(int i=0; i<n+1; i++){
        int num = 1;
        for(int j=n-i; j>0; j--){
            System.out.print(" ");
        }
        for(int j=0; j<=i; j++){
            System.out.print(num + " ");
            num = num * (i - j) / (j + 1);
        }
        System.out.println();
    }

    System.out.println("Number Triangle: ");
    for(int i=0; i<n+1; i++){
        for(int j=n-i; j>0; j--){
            System.out.print(" ");
        }
        for(int j=0; j<=i; j++){
            System.out.print((i+1) + " ");
        }
        System.out.println();
    }
   } 
}
