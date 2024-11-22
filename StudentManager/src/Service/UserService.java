package Service;

import entities.Subject;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<User> users;

    public UserService(List<User> users){
        this.users = users;
    }


    public void loadAllStudents(){
        for(User user: users){
            if(user.getRole().toString().equals("Student")){
                System.out.println("Tên: " + user.getName());
                System.out.println("Mã: " + user.getCode());
                System.out.println("Ngày sinh: " + user.getBirthDay());
                System.out.println("Giới tính: " + user.getGender());
                System.out.println("Địa chỉ: " + user.getAddress());
                System.out.println("Email: " + user.getEmail());
                System.out.println("==============================================");
            }
        }
    }

    public void loadAllTeacher(){
        for(User user: users){
            if(user.getRole().toString().equals("Teacher")){
                System.out.println("Tên: " + user.getName());
                System.out.println("Mã: " + user.getCode());
                System.out.println("Ngày sinh: " + user.getBirthDay());
                System.out.println("Giới tính: " + user.getGender());
                System.out.println("Địa chỉ: " + user.getAddress());
                System.out.println("Email: " + user.getEmail());

            }
        }
    }
    public String loadUserByCode(String code){
        boolean find = false;
        for(User user: users){
            if(user.getCode().equals(code)){
                find = true;
                return user.getCode();
            }
        }
        if(!find){
            System.out.println("Không tìm thấy học sinh");
        }
        return code;
    }



}
