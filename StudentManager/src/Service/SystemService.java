package Service;


import entities.Role;
import entities.User;
import java.util.ArrayList;
import java.util.List;

public class SystemService {
    public void start(){
        List<User> users = new ArrayList<>();
        users.add(new User("HS1", "Student", "2002-12-13", "Nữ", "HCM", "s@gmail.com", "123", Role.Student, false));
        users.add(new User("GV2", "Teacher", "2001-11-11", "Nam", "HN", "t@gmail.com", "123", Role.Teacher, false));
        users.add(new User("HS2", "Minh", "2004-12-13", "Nam", "Bình Chánh", "minh@gmail.com", "123", Role.Student, false));
        users.add(new User("GV2", "Hoàng", "2005-11-11", "Nam", "Quận 12", "hoang@gmail.com", "123", Role.Teacher, false));
        SubjectService subjectService = new SubjectService();
        Authentication auth = new Authentication(subjectService);
        auth.Login();
    }
}
