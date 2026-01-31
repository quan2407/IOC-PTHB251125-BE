import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Shape rectangle = new Rectangle("A",3,4);
        shapes.add(rectangle);
        Shape circle = new Circle("C",5);
        shapes.add(circle);
        for (Shape shape : shapes) {
            shape.displayInfo();
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
        }

    }
}