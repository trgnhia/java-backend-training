package task_4.oop1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle("Red",5));
        shapes.add(new Rectangle("Blue",4, 6));
        shapes.add(new Circle("Green",3.5));

        double totalArea = 0;

        for (Shape shape : shapes) {
            shape.printInfo();
            totalArea += shape.getArea();
        }

        System.out.printf("Total Area = %.2f",totalArea);
    }
}