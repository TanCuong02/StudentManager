package entities;

public class Teacher extends Infomation{
    public Teacher(String name, String birthDay, String gender, String address, String email, String password) {
        super(name, birthDay, gender, address, email, password);
    }

    @Override
    public String getRole() {
        return "Teacher";
    }
}
