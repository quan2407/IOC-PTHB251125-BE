import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        FullTimeEmployee emp1 = new FullTimeEmployee(1,"A",34000000);
        employees.add(emp1);
        PartTimeEmployee emp2 = new PartTimeEmployee(2,"B",200000,6);
        employees.add(emp2);
        for (Employee employee : employees) {
            System.out.println(employee.calculateSalary());
            if (employee instanceof FullTimeEmployee) {
                System.out.println(((FullTimeEmployee) employee).calculateBonus());
            }
        }
    }
}