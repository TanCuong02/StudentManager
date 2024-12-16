package Config;

import Service.Authentication;
import Service.SubjectManagement;
import Service.UserManagement;
import entities.Role;
import entities.User;

import java.util.List;
import java.util.Scanner;

public class SystemManage {

    List<User> users;
    UserManagement userService;
    SubjectManagement subjectService;
    Authentication authentication;
    public SystemManage(List<User> users, Authentication authentication){
        this.users = users;
        this.userService = new UserManagement(users);
        this.authentication = authentication;
    }


    public void menuFunctionForTeacher(){
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do{
            System.out.println("\tDANH SÁCH LỰA CHỌN CHỨC NĂNG\t");
            System.out.println("1. Xem danh sách học sinh");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Cập nhật thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Thêm môn học");
            System.out.println("6. Thêm điểm cho học sinh");
            System.out.println("7. Đăng xuất");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon){
                case 1:
                    userService.displayAllStudents();
                    break;
                case 2:
                    userService.createNewStudent();
                    break;
                case 3:
                    userService.updateStudentInfomation();
                    break;
                case 4:
                    userService.deleteStudent();
                    break;
                case 5:
                    subjectService.addSubject();
                    break;
                case 6:

                    break;
                case 7:
                    authentication.Logout();
                    break;
                case 8:
                    authentication.exit();
                    break;
                default:
                    System.out.println("Không hợp lệ.Vui lòng chọn lại!!!");
                    break;
            }
        }while (chon != 7);

    }

    public void menuFunctionForStudent(String userCode){
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do{
            System.out.println("\tDANH SÁCH LỰA CHỌN CHỨC NĂNG\t");
            System.out.println("1. Xem điểm");
            System.out.println("2. Cập nhật thông tin");
            System.out.println("3. Đăng xuất");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon){
                case 1:
                    userService.displayStudentScore(userCode);
                    break;
                case 2:
                    userService.updateStudentInfomationByCode(userCode);
                    break;
                case 3:
                    authentication.Logout();
                    break;
                case 4:
                    authentication.exit();
                    break;

                default:
                    System.out.println("Không hợp lệ.Vui lòng chọn lại!!!");
                    break;
            }
        }while (chon != 4);
    }

}
