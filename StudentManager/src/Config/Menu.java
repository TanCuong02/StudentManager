package Config;

import Service.Authentication;
import Service.SubjectService;
import Service.UserService;
import entities.Role;
import entities.Subject;
import entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    List<User> users;
    UserService userService;

    SubjectService subjectService;

    Authentication authentication;

    public Menu(List<User> users, Authentication authentication){

        this.users = users;
        this.userService = new UserService(users);
        this.subjectService = new SubjectService();
        this.authentication = authentication;
    }

    public void teacherMenu(){
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
                    System.out.println("==============================================");
                    System.out.println("Danh sách học sinh");
                    userService.loadAllStudents();
                    break;
                case 2:
                    System.out.println("Thêm mới học sinh");
                    System.out.print("Nhập mã học sinh:");
                    String newCode=sc.nextLine();
                    System.out.print("Nhập họ và tên học sinh:");
                    String newFullName=sc.nextLine();
                    System.out.print("Nhập ngày tháng năm sinh(YYYY-MM-DD):");
                    String newBirthDay=sc.nextLine();
                    System.out.print("Nhập giới tính:");
                    String newGender=sc.nextLine();
                    System.out.print("Nhập địa chỉ:");
                    String newAddress=sc.nextLine();
                    System.out.print("Nhập email:");
                    String newEmail=sc.nextLine();
                    System.out.print("Nhập mật khẩu:");
                    String newPassword=sc.nextLine();
                    boolean status = true;
                    System.out.println("Đã thêm học sinh mới!!!");
                    User newUser  = new User(newCode, newFullName, newBirthDay, newGender, newAddress, newEmail, newPassword, Role.Student, status);

                    // Add the new user to the UserService
                    userService.addStudent(newUser );
                    break;
                case 3:
                    System.out.println("Cập nhật thông tin học sinh");
                    System.out.print("Nhập mã học sinh cần cập nhật:");
                    String updateCode=sc.nextLine();
                    boolean updated=false;
                    for(User user:users)
                    {
                        if(user.getCode().equals(updateCode)&&user.getRole()== Role.Student)
                        {
                            System.out.print("Nhập tên mới:");
                            user.setName(sc.nextLine());
                            System.out.print("Nhập ngày tháng năm sinh mới(YYYY-MM-DD):");
                            user.setBirthDay(sc.nextLine());
                            System.out.print("Nhập giới tính mới:");
                            user.setGender(sc.nextLine());
                            System.out.print("Nhập địa chỉ mới:");
                            user.setAddress(sc.nextLine());
                            System.out.print("Nhập email mới:");
                            user.setEmail(sc.nextLine());
                            System.out.print("Nhập mật khẩu mới:");
                            user.setPassword(sc.nextLine());
                            updated=true;
                            System.out.println("Thông tin học sinh đã được cập nhật!!!");
                            break;
                        }
                    }
                    if(!updated)
                    {
                        System.out.println("Không tìm thấy học sinh với mã đã nhập!!!");
                    }
                    break;
                case 4:
                    System.out.println("Xóa học sinh");
                    System.out.print("Nhập mã học sinh cần xóa:");
                    String studentCode=sc.nextLine();
                    userService.deleteStudent(studentCode);
                    break;
                case 5:
                    subjectService.addSubject();
                    break;
                case 6:
                    System.out.print("Nhập mã học sinh:");
                    String code = sc.nextLine();
                    System.out.print("Nhập mã môn:");
                    String subCode = sc.nextLine();
                    System.out.print("Nhập điểm môn:");
                    float score = sc.nextFloat();
                    sc.nextLine();
                    subjectService.assignScore (subjectService.getSubjectByCode(subCode), userService.loadUserByCode(code), score);
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

}
