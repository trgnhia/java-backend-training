package task_4;

public class Rectangle extends Shape{
    private double width;
    private double height;
    @Override
    public double getArea() {
        return width * height;
    }
}
