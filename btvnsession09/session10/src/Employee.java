import java.util.Date;

public class Employee extends Person {
    private String id;
    private String department;
    private String position;
    private String company;
    private Double salary;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee(String name, Boolean gender, Date birthday, String address, String company, String department, String id, String position, Double salary) {
        super(name, gender, birthday, address);
        this.company = company;
        this.department = department;
        this.id = id;
        this.position = position;
        this.salary = salary;
    }
}
