package Service;

import entities.Subject;
import entities.User;

import java.util.List;
import java.util.Scanner;

public class Menu {

    List<User> users;
    UserService userService;

    SubjectService subjectService;
    public Menu(List<User> users){
        this.users = users;
        this.userService = new UserService(users);
        this.subjectService = new SubjectService();
    }

    public void teacherMenu(){
        Scanner sc = new Scanner(System.in);
        int chon = 0;

        do{
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Xem danh sách học sinh");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Cập nhật thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Thêm môn học");
            System.out.println("6. Thêm điểm cho học sinh");
            System.out.println("7. Thoát");
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
                    System.out.println("n");
                    break;
                case 3:
                    System.out.println("Cập nhật thông tin học sinh");
                    // Gọi phương thức cập nhật thông tin học sinh
                    break;
                case 4:
                    System.out.println("Xóa học sinh");
                    // Gọi phương thức xóa học sinh
                    break;
                case 5:
                    subjectService.addSubject();
                    break;
                case 6:
                    System.out.println("Nhập mã học sinh");
                    String code = sc.nextLine();
                    System.out.println("Nhập mã môn");
                    String subCode = sc.nextLine();
                    System.out.println("Nhập điểm");
                    float score = sc.nextFloat();
                    sc.nextLine();
                    subjectService.assignScore (subjectService.getSubjectByCode(subCode), userService.loadUserByCode(code), score);
                case 7:
                    break;
                default:
                    System.out.println("Không hợp lệ");
                    break;
            }
        }while (chon != 7);

    }
public void Diem(){}
}
