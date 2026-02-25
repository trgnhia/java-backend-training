package task_4;

public class Circle extends Shape{
    private double radius;
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
