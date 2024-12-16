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


    public void loadAllStudents(){
        for(User user: users) {
            if (!loadUserByCode(user.getCode()).isEmpty()) {
                if (user.getRole() == Role.Student) {
                    System.out.println("Tên:" + user.getName() + "  Mã:" + user.getCode() + "  Ngày sinh:" + user.getBirthDay() + "  Giới tính:" + user.getGender() + "  Địa chỉ:" + user.getAddress() + "  Email:" + user.getEmail());
                }
                if (user.isDeleted()) {
                    System.out.println("Người dùng không tồn tại hoặc đã bị xóa.");
                }
            }
            System.out.println("==================================================");
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
public void deleteStudent(String code)
{
    boolean found=false;
    for (User user:users)
    {
        if(user.getCode().equals(code)&&user.getRole()== Role.Student)
        {
            user.setDeleted(true);
            found=true;
            System.out.println("Học sinh với mã "+code+" đã được ẩn!!!");
            break;
        }
    }
    if(!found)
    {
        System.out.println("Không tìm thấy học sinh với mã "+code);
    }
}
    public void addStudent(User newUser ) {
        // Kiểm tra xem học sinh đã tồn tại chưa
        for (User  user : users) {
            if (user.getCode().equalsIgnoreCase(newUser .getCode()) && user.getRole() == Role.Student && !user.isDeleted()) {
                System.out.println("Mã học sinh đã tồn tại.");
                return; // Thoát khỏi phương thức nếu học sinh đã tồn tại
            }
        }
        // Nếu không tìm thấy, thêm học sinh mới vào danh sách
        users.add(newUser );
        System.out.println("Đã thêm học sinh mới: " + newUser .getName());
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
            }
        }
    }

    public void updateStudentInfomation(String userCode) {
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
            }
        }
        if(!updateCheck){
            System.out.println("Cập nhật không thành công");
        }
    }


}

