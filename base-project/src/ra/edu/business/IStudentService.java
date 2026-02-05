package ra.edu.business;

import ra.edu.model.Student;

import java.util.List;

public interface IStudentService extends IBaseService<Student,String> {
    // các phương thức riêng
    List<Student> findByName(String name);
}
