package task_4.oop1;

public abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    abstract public double getArea();
    public void printInfo() {
        System.out.println(
                         "Color: " + color
                        + " | Area: " + getArea()
        );

    }
}
