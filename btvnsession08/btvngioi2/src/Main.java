//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(5, 2);
        Rectangle r3 = new Rectangle(4.5, 3.5);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        double maxArea = r1.getArea();
        if (maxArea < r2.getArea()) {
            maxArea = r2.getArea();
        }
        if (maxArea < r3.getArea()) {
            maxArea = r3.getArea();
        }
        System.out.println("Largest area: " + maxArea);
    }
}