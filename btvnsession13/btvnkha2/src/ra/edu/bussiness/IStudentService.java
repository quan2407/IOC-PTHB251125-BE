package ra.edu.bussiness;

import ra.edu.model.Student;

public interface IStudentService extends IBaseService<Student,Integer> {
    int getMaxId();
}
