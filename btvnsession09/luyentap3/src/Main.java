//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "A", 2.9);
        Student student2 = new Student(2, "B", 1.9);
        Student student3 = new Student(3, "C", 3.9);
        student1.printInfo();
        student2.printInfo();
        student3.printInfo();
        System.out.println(Student.getCount());
    }
}