// 2. Basic Shape Calculator:
// Create a Shape class with a method to calculate area (abstract).
// Create subclasses like Circle, Rectangle, and Triangle inheriting from Shape and implementing their respective area calculations.
// Demonstrate polymorphism by creating an array of Shape objects and calculating the area of each shape using a loop.
abstract class Shape {
    abstract double calculateArea();
}

class Circle extends Shape {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}
class Rectangle extends Shape {
    double length;
    double width;
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    double calculateArea() {
        return length * width;
    }
}
class Triangle extends Shape {
    double base;
    double height;
    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}
public class Calculator {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 7)
        };
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
        }
    }
}
