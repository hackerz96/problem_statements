
public class CarAssembly implements Runnable {
   private String componentName;
   private int timeToPrepare;
   
   // constructor 
   public CarAssembly(String componentName, int timeToPrepare){
        this.componentName = componentName;
        this.timeToPrepare = timeToPrepare;
   }
    // run method to simulate the assembly process
    public void run() {
          try {
                System.out.println("Preparing " + componentName + " for " + timeToPrepare + " seconds.");
                Thread.sleep(timeToPrepare * 1000); // simulate time taken to prepare the component
                System.out.println(componentName + " is ready.");
          } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
          }
     }

     public static void main(String[] args) {
        // creating threads for 3 components;
        Thread engineThread = new Thread(new CarAssembly("Engine", 7));
        Thread bodyThread = new Thread(new CarAssembly("Body", 3));
        Thread wheelThread = new Thread(new CarAssembly("Wheel", 5));

        // starting the threads
        engineThread.start();
        bodyThread.start();
        wheelThread.start();

        // waiting for all threads to finish
        try {
            engineThread.join();
            bodyThread.join();
            wheelThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        System.out.println("All components are ready. Car assembly is complete.");

     }
}
