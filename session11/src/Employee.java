import java.util.Date;

public class Employee extends Person{
    private int empId;
    private double basicSalary;
    private double salaryRate;
    private double bonus;

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public double getSalaryRate() {
        return salaryRate;
    }

    public void setSalaryRate(double salaryRate) {
        this.salaryRate = salaryRate;
    }

    public Employee(Date birthday, String name, double basicSalary, double bonus, int empId, double salaryRate) {
        super(birthday, name);
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.empId = empId;
        this.salaryRate = salaryRate;
    }

    public Employee() {
    }

    @Override
    public double calculateSalary() {
        return basicSalary*salaryRate+bonus;
    }

    @Override
    public double calculateScholarship() {
        return 0;
    }
}
