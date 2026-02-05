package ra.edu.bussiness.impl;

import ra.edu.bussiness.IStudentService;
import ra.edu.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private static List<Student> students = new ArrayList<Student>();

    @Override
    public int getMaxId() {
        if (students.isEmpty()) {
            return 0; // Trả về 0 nếu chưa có ai, để ID đầu tiên là 1
        }
        int maxId = students.get(0).getId();
        for (Student s : students) {
            if (s.getId() > maxId) {
                maxId = s.getId();
            }
        }
        return maxId;
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void delete(Integer integer) {
        Student student = findById(integer);
        if (student != null) {
            students.remove(student);
        }
    }

    @Override
    public void update(Student student, Integer integer) {
        int index = students.indexOf(findById(integer));
        students.set(index, student);
    }

    @Override
    public Student findById(Integer integer) {
        for (Student s : students) {
            if (s.getId() == integer) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void sort() {

    }
}
