package ra.edu.business.impl;

import ra.edu.business.IStudentService;
import ra.edu.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private List<Student> students = new ArrayList<Student>();

    public StudentServiceImpl() {
        students.add(new Student("SV001","Nguyen Van A","a@gmail.com","0912823882"));
        students.add(new Student("SV002","Nguyen Van B","a@gmail.com","0912823882"));
        students.add(new Student("SV003","Nguyen Van V","a@gmail.com","0912823882"));
        students.add(new Student("SV004","Nguyen Van C","a@gmail.com","0912823882"));
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void delete(String id) {
        Student s = findById(id);
        if (s != null) {
            students.remove(s);
        }
    }

    @Override
    public void update(Student student, String id) {
        int index = students.indexOf(findById(id));
        students.set(index, student);
    }

    @Override
    public Student findById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
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
        Collections.sort(students, ((o1, o2) -> o1.getName().compareTo(o2.getName())));
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> searchStudent = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().equals(name.toLowerCase())) {
                searchStudent.add(student);
            }
        }
        return searchStudent;
    }
}
