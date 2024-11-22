package Service;

import entities.Infomation;
import entities.Role;
import entities.Subject;
import entities.User;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authentication {

    private List<User> users;

    Menu menu;

    private SubjectService subjectService;
    private UserService userService;

    public Authentication(SubjectService subjectService) {
        users = new ArrayList<>();
        users.add(new User("HS1", "Student", "2002-12-13", "Nữ", "HCM", "s@gmail.com", "123", Role.Student));
        users.add(new User("GV2", "Teacher", "2001-11-11", "Nam", "HN", "t@gmail.com", "123", Role.Teacher));
        users.add(new User("HS2", "Minh", "2004-12-13", "Nam", "Bình Chánh", "minh@gmail.com", "123", Role.Student));
        users.add(new User("GV2", "Hoàng", "2005-11-11", "Nam", "Quận 12", "hoang@gmail.com", "123", Role.Teacher));
        this.subjectService = subjectService;
        this.userService = new UserService(users);
        this.menu = new Menu(users);

    }



    public  void Login(){

            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập email: ");
            String inputEmail = scanner.nextLine();
            System.out.print("Nhập mật khẩu: ");
            String inputPassword = scanner.nextLine();
             User logged = null;
            for (User user : users) {
                if (user.login(inputEmail, inputPassword)) {
                    logged = user;
                }
            }

            if(logged != null){
                System.out.println("Đăng nhập thành công!");
                switch (logged.getRole()) {
                    case Student:
                        System.out.println("Welcome " + logged.getName());
                        subjectService.viewAllScores(logged.getCode());
                        break;
                    case Teacher:
                        System.out.println("Welcome " + logged.getName());
                        menu.teacherMenu();
                        break;
                    default:
                        System.out.println("Error!!!");
                        break;
                }
            }else{
                System.out.println("Đăng nhập không thành công!");
                Login();
            }

    }


}
