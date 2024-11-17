package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Infomation {
    protected String name;
    protected String birthDay;
    protected String gender;
    protected String address;
    protected String email;
    protected String password;


    public abstract String getRole();

    public String getName() {
        return name;
    }

    public Infomation(String name, String birthDay, String gender, String address, String email, String password) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public static Infomation login(String email, String password, List<Infomation> list) {
        for (Infomation infomation : list) {
            if (infomation.email.equals(email) && infomation.password.equals(password)) {
                return infomation;
            }
        }
        return null;
    }

}
