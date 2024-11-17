package entities;

public class Student extends Infomation {

    @Override
    public String getRole() {
        return "Student";
    }

    public Student(String name, String birthDay, String gender, String address, String email, String password) {
        super(name, birthDay, gender, address, email, password);
    }
}
