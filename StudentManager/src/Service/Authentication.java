package Service;

import Config.SystemManage;
import entities.Role;
import entities.User;

import java.util.*;

public class Authentication {

    private List<User> users;

    private User logged;

    SystemManage menu;

    private UserManagement userService;

    public Authentication() {
        users = new ArrayList<>();
        users.add(new User("HS1", "Student", "2002-12-13", "Nữ", "HCM", "s@gmail.com", "123", Role.Student, false, 8,10,7));
        users.add(new User("GV2", "Teacher", "2001-11-11", "Nam", "HN", "t@gmail.com", "123", Role.Teacher, false,9,10,10));
        users.add(new User("HS2", "Minh", "2004-12-13", "Nam", "Bình Chánh", "minh@gmail.com", "123", Role.Student, false,0,0,0));
        users.add(new User("GV2", "Hoàng", "2005-11-11", "Nam", "Quận 12", "hoang@gmail.com", "123", Role.Teacher, false,0,0,0));
        this.userService = new UserManagement(users);
        this.menu = new SystemManage(users, this);

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
                if (user.checkEmailPassword(inputEmail, inputPassword)) {
                    logged = user;
                    break;
                }
            }
            if(logged != null){
                System.out.println("Đăng nhập thành công!");
                switch (logged.getRole()) {
                    case Student:
                        System.out.println("Chào " + logged.getName());
                        menu.menuFunctionForStudent(logged.getCode());
                        break;
                    case Teacher:
                        System.out.println("Chào " + logged.getName());
                        menu.menuFunctionForTeacher();
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
                logged = null;
                Login();
            } else if (response.equals("no")) {
                menu.menuFunctionForTeacher();
            } else {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập 'Yes' hoặc 'No'.");
                Logout();
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
            menu.menuFunctionForTeacher();
        } else {
            System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập 'Yes' hoặc 'No'.");
            Logout();
        }
    }

}
