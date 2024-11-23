package Service;

import entities.Infomation;
import entities.Role;
import entities.Subject;
import entities.User;

import java.io.*;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authentication {

    private List<User> users;

    private User logged;

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
        this.menu = new Menu(users, this);

    }



    public  void Login(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("============= ĐĂNG NHẬP ==============");
            System.out.print("Nhập email: ");
            String inputEmail = scanner.nextLine();
            System.out.print("Nhập mật khẩu: ");
            String inputPassword = scanner.nextLine();
            logged = null;
            for (User user : users) {
                if (user.login(inputEmail, inputPassword)) {
                    logged = user;
                    break;
                }
            }

            if(logged != null){
                System.out.println("Đăng nhập thành công!");
                switch (logged.getRole()) {
                    case Student:
                        System.out.println("Chào " + logged.getName());
                        subjectService.viewAllScores(logged.getCode());
                        break;
                    case Teacher:
                        System.out.println("Chào " + logged.getName());
                        menu.teacherMenu();
                        break;
                    default:
                        System.out.println("Lỗi!!!");
                        break;
                }
            }else{
                System.out.println("Đăng nhập không thành công!");
                Login();
            }
    }

    public void Logout() {
        if (logged != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Bạn có chắc chắn muốn đăng xuất? (Yes/No): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("yes")) {
                System.out.println("Đăng xuất thành công");
                logged = null; // Đặt lại thông tin người dùng
                Login();
            } else if (response.equals("no")) {
                menu.teacherMenu();
            } else {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập 'Yes' hoặc 'No'.");
                Logout(); // Gọi lại phương thức Logout nếu lựa chọn không hợp lệ
            }
        } else {
            System.out.println("Không có người dùng nào đang đăng nhập!");
        }
    }

    public void exit(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bạn có chắc chắn muốn thoát? (Yes/No): ");
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("yes")) {
            System.exit(0);
        } else if (response.equals("no")) {
            menu.teacherMenu();
        } else {
            System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập 'Yes' hoặc 'No'.");
            Logout(); // Gọi lại phương thức Logout nếu lựa chọn không hợp lệ
        }
    }

}
