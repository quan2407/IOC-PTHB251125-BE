public class Student {
    public static final double MIN_GPA = 0.0;
    public static final double MAX_GPA = 4.0;
    private static int count = 0;

    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        if (gpa < MIN_GPA || gpa > MAX_GPA) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is not valid");
        }

        this.id = id;
        this.name = name;
        this.gpa = gpa;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Student.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', gpa=" + gpa + "}";
    }

    public void printInfo() {
        System.out.println(this);
    }
}
