package Service;

import entities.Role;
import entities.Subject;
import entities.User;

import java.util.List;
import java.util.Map;

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

    public void loadAllTeacher(){
        for(User user: users){
            if(user.getRole().toString().equals("Teacher")){
                System.out.println("Tên: " + user.getName()+"  Mã:" + user.getCode()+"   Ngày sinh:" + user.getBirthDay()+"  Giới tính:" + user.getGender()+"  Địa chỉ:" + user.getAddress()+"  Email:" + user.getEmail());
                System.out.println("=======================================================================================================");
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
}

