
public class Printer {
    // Synchronized to prevent interleaved output
    public synchronized void printNumbers() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println(); // Move to next line after printing numbers
    }
    public static void main(String[] args) {
        // Create a shared Printer object to ensure synchronization
        Printer printer = new Printer();

        // Thread 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printNumbers();
            }
        });

        // Thread 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printNumbers();
            }
        });

        // Start both threads
        t1.start();
        t2.start();
    }
}
