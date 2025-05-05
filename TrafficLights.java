public class TrafficLights {
    private String color;
    private int duration; // duration in seconds

    // Constructor
    public TrafficLights(String color, int duration) {
        this.color = color;
        this.duration = duration;
    }

    // Method to change color and duration
    public void changeColor(String newColor, int newDuration) {
        this.color = newColor.toLowerCase();
        this.duration = newDuration;
    }

    // Method to check if light is red
    public boolean isRed() {
        return color.equalsIgnoreCase("red");
    }

    // Method to check if light is green
    public boolean isGreen() {
        return color.equalsIgnoreCase("green");
    }

    // Method to display current light status
    public void displayStatus() {
        System.out.println("Traffic Light Color: " + color.toUpperCase());
        System.out.println("Duration: " + duration + " seconds");
        if (isRed()) {
            System.out.println("STOP!");
        } else if (isGreen()) {
            System.out.println("GO!");
        } else {
            System.out.println("WAIT...");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        TrafficLights light = new TrafficLights("red", 30);
        light.displayStatus();

        light.changeColor("green", 45);
        light.displayStatus();

        light.changeColor("yellow", 5);
        light.displayStatus();
    }
}
