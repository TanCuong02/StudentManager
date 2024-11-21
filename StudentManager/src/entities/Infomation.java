package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Infomation {

    protected String code;

    protected String name;
    protected String birthDay;
    protected String gender;
    protected String address;
    protected String email;
    protected String password;

    public String getBirthDay() {
        return birthDay;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Infomation(String code, String name, String birthDay, String gender, String address, String email, String password) {
        this.code = code;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
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
