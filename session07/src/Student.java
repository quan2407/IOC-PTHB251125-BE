public class Student {
    String studentId;
    String studentName;
    String dateOfBirth;
    String phoneNumber;
    String email;
    SexEnum gender;

    // Phương thức khởi tạo
    public Student(){

    }
    public Student(String studentId){
        this.studentId = studentId;
    }

    public Student(String studentId, String studentName, String dateOfBirth, String phoneNumber, String email, SexEnum gender) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    public void eat(){
        System.out.println(studentName + " is eating");
    }
    public void attendance(){
        System.out.println(studentName + " is attending");
    }

}
