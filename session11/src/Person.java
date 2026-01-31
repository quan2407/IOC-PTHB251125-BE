import java.util.Date;

public abstract class Person {
private String name;
private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(Date birthday, String name) {
        this.birthday = birthday;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "birthday=" + birthday +
                ", name='" + name + '\'' +
                '}';
    }

    public Person() {
    }
    public abstract double calculateSalary();
    public abstract double calculateScholarship();
}
