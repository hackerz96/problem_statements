interface Shape{
    double calculateArea();
}

class Circle implements Shape{
    double radius;
        
        public Circle(double radius) {
            this.radius = radius;
        }
        
        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
}

class Rectangle implements Shape{
    double length, width;
        
        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }
        
        @Override
        public double calculateArea() {
            return length * width;
        }
}

class Triangle implements Shape{
    double base, height;
        
        public Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }
        
        @Override
        public double calculateArea() {
            return 0.5 * base * height;
        }
}

public class ShapeAreas {
    public static void main(String[] args) {
        // using polymorphism to create an array of Shape references and calling calculateArea method on each
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Triangle(3.0, 4.0);

        System.out.println("Areas of shapes:");
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
        }
    }   
}
