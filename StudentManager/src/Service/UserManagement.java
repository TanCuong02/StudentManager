package Service;

import entities.Role;
import entities.Subject;
import entities.User;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserManagement {

    List<User> users;

    private Map<String, Subject> subjects;
    public UserManagement(List<User> users){
        this.users = users;
    }


    public void displayAllStudents(){
        System.out.println("==============================================");
        System.out.println("Danh sách học sinh");
        for(User user: users) {
            if (!displayStudentByCode(user.getCode()).isEmpty()) {
                if (user.getRole() == Role.Student) {
                    System.out.println("Tên: " + user.getName() + "  Mã:" + user.getCode() + "  Ngày sinh: " + user.getBirthDay() + "  Giới tính: " + user.getGender() + "  Địa chỉ: " + user.getAddress() + "  Email: " + user.getEmail());
                    System.out.println();
                }
                if (user.isDeleted()) {
                    System.out.println("Người dùng không tồn tại hoặc đã bị xóa.");
                }
            }
        }
        }

    public String displayStudentByCode(String code){
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
public void deleteStudentByCode(String code)
{
    boolean found=false;
    for (User user:users)
    {
        if(user.getCode().equals(code)&&user.getRole()== Role.Student)
        {
            user.setDeleted(true);
            found=true;
            System.out.println("Học sinh với mã "+ code +" đã bị xóa!!!");
            break;
        }
    }
    if(!found)
    {
        System.out.println("Không tìm thấy học sinh với mã "+code);
    }
}
    public void addNewStudent(User newUser ) {
        // Kiểm tra xem học sinh đã tồn tại chưa
        for (User  user : users) {
            if (user.getCode().equalsIgnoreCase(newUser .getCode()) && user.getRole() == Role.Student && !user.isDeleted()) {
                System.out.println("Mã học sinh đã tồn tại.");
                return; // Thoát khỏi phương thức nếu học sinh đã tồn tại
            }
        }
        // Nếu không tìm thấy, thêm học sinh mới vào danh sách
        users.add(newUser );
        System.out.println("Đã thêm học sinh mới: " + newUser.getName());
    }

    public void displayStudentInfomation(String userCode){
        for (User user : users) {
            if (user.getCode().equals(userCode)) {
                System.out.println("Thông tin của bạn");
                System.out.println("Tên: " + user.getName());
                System.out.println("Ngày sinh: " + user.getBirthDay());
                System.out.println("Giới Tính: " + user.getGender());
                System.out.println("Địa chỉ: " + user.getAddress());
                System.out.println("Email: " + user.getEmail());
                System.out.println();
            }
        }
    }

    public void displayStudentScore(String userCode){
        for (User user : users) {
            if (user.getCode().equals(userCode)) {
                System.out.println("Điểm của bạn");
                System.out.println("Toán: " + user.getMathScore());
                System.out.println("Văn: " + user.getLiteratureScore());
                System.out.println("Tiếng Anh: " + user.getEnglishScore());
                System.out.println();
            }
        }
    }

    public void updateStudentInfomationByCode(String userCode) {
        Scanner sc = new Scanner(System.in);
        boolean updateCheck = false;
        for(User user: users) {
            if (user.getCode().equals(userCode)) {
                displayStudentInfomation(userCode);
                System.out.println("Nhập thông tin cá nhân bạn muốn sửa: ");
                System.out.println("Tên: ");
                user.setName(sc.nextLine());
                System.out.println("Email: ");
                user.setEmail(sc.nextLine());
                System.out.println("Password: ");
                user.setPassword(sc.nextLine());
                System.out.println("Giới Tính: ");
                user.setGender(sc.nextLine());
                System.out.println("Ngày sinh: ");
                user.setBirthDay(sc.nextLine());
                System.out.println("Địa chỉ: ");
                user.setAddress(sc.nextLine());
                updateCheck = true;
                System.out.println("Cập nhật thành công");
                System.out.println();
            }
        }
        if(!updateCheck){
            System.out.println("Cập nhật không thành công");
        }
    }


    public void createNewStudent() {
        Scanner sc = new Scanner(System.in);
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
        User newUser  = new User(newCode, newFullName, newBirthDay, newGender, newAddress, newEmail, newPassword, Role.Student, status,0,0,0);

        // Add the new user to the UserService
        addNewStudent(newUser );
    }

    public void updateStudentInfomation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Cập nhật thông tin học sinh");
        System.out.print("Nhập mã học sinh cần cập nhật:");
        String updateCode=sc.nextLine();
        boolean updated=false;
        for(User user:users)
        {
            if(user.getCode().equals(updateCode)&&user.getRole()== Role.Student)
            {
                System.out.print("Nhập tên:");
                user.setName(sc.nextLine());
                System.out.print("Nhập ngày sinh(YYYY-MM-DD):");
                user.setBirthDay(sc.nextLine());
                System.out.print("Nhập giới tính:");
                user.setGender(sc.nextLine());
                System.out.print("Nhập địa chỉ:");
                user.setAddress(sc.nextLine());
                System.out.print("Nhập email:");
                user.setEmail(sc.nextLine());
                System.out.print("Nhập mật khẩu:");
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
    }

    public void deleteStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Xóa học sinh");
        System.out.print("Nhập mã học sinh cần xóa:");
        String studentCode=sc.nextLine();
        deleteStudentByCode(studentCode);
    }

}

