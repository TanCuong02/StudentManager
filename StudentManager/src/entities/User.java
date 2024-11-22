package entities;


import java.util.ArrayList;
import java.util.List;

public class User extends Infomation{

    private Role role;


    public User(String code, String name, String birthDay, String gender, String address, String email, String password, Role role) {
        super(code, name, birthDay, gender, address, email, password);
        this.role = role;
    }

    public Role getRole(){
        return role;
    }

}
