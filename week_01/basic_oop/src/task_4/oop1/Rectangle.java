package task_4.oop1;

public class Rectangle extends Shape {
    private double width;
    private double height;


    public Rectangle(String color, double height, double width) {
        super(color);
        this.height = height;
        this.width = width;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle(width=" + width
                + ", height=" + height
                + ", color=" + getColor()
                + ", area=" + getArea() + ")";
    }
}
