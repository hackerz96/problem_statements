

public class UniqueDigits {
    int n;
    
    public UniqueDigits(int n) {
        this.n = n;
    }

    public int countUniqueDigits(){
       int [] digitOccurrenceCount = new int[10];
       int uniqueCount = 0;
       int num = n;
       while(num > 0){
            int digit = num%10;
            digitOccurrenceCount[digit]++;
            num /= 10;
       }
       for(int count : digitOccurrenceCount){
            if(count == 1){
                uniqueCount++;
            }
       }
         
       return uniqueCount;
    }

    public static void main(String[] args) {
        UniqueDigits uniqueDigits = new UniqueDigits(22342);
        int result = uniqueDigits.countUniqueDigits();
        System.out.println("Count of unique digits: " + result);
        System.out.println();

        
        UniqueDigits uniqueDigits2 = new UniqueDigits(99677);
        int result2 = uniqueDigits2.countUniqueDigits();
        System.out.println("Count of unique digits: " + result2);
    }
}
