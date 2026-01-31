import java.text.ParseException;
import java.text.SimpleDateFormat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Student student = new Student(sdf.parse("21/12/2005"),"Nguyen Tuan Anh",9.8,"s1");
Employee employee = new Employee(sdf.parse("21/12/1990"),"Nguyen Minh Quan",3000000,20000,3,4.6);
        System.out.println(student);
        System.out.println(employee);
    }
}