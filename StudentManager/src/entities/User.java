package entities;


public class User extends Infomation{

    private Role role;
    private Subject subject;
    public User(String code, String name, String birthDay, String gender, String address, String email, String password, Role role) {
        super(code, name, birthDay, gender, address, email, password);
        this.role = role;
    }



    public Role getRole(){
        return role;
    }

}
