public class Rectangle extends Shape implements Drawable {
    private double width;
    private double height;

    public Rectangle(String name, double height, double width) {
        super(name);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
