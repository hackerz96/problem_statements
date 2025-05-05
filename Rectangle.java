public class Rectangle {
    int length;
    int breadth;

    public Rectangle(int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }

    public void compareArea(Rectangle otherRectangle){
        int area1 = this.length * this.breadth;
        int area2 = otherRectangle.length * otherRectangle.breadth;

        if(area1 > area2){
            System.out.println("The first rectangle has a larger area: " + area1);
        } else if(area1 < area2){
            System.out.println("The second rectangle has a larger area: " + area2);
        } else {
            System.out.println("Both rectangles have the same area.");
        }
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(5, 10);
        Rectangle rect2 = new Rectangle(7, 8);

        rect1.compareArea(rect2);
        rect2.compareArea(rect1);
    }
}
