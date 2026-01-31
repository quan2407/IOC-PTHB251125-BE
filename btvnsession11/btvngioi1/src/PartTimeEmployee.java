public class PartTimeEmployee extends Employee {
    private double hourSalary;
    private double workingHour;

    public PartTimeEmployee(int id, String name, double hourSalary, double workingHour) {
        super(id, name);
        this.hourSalary = hourSalary;
        this.workingHour = workingHour;
    }

    @Override
    double calculateSalary() {
        return hourSalary * workingHour;
    }
}
