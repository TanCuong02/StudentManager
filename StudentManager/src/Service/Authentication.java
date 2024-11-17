package Service;

import entities.Infomation;
import entities.Student;
import entities.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authentication {
    public void Login(){
        List<Infomation> infomations = new ArrayList<>();
        infomations.add(new Student("Student", "13-12-2002", "Male", "Hoa Sen University", "student@hoasen.edu.vn", "123"));
        infomations.add(new Teacher("Teacher", "13-12-2002", "Female", "Hoa Sen University", "teacher@hoasen.edu.vn", "123"));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Infomation logged = Infomation.login(email, password, infomations);

        if(logged != null){
            System.out.println("Login successful! Welcome, " + logged.getName());
        } else {
            System.out.println("Login failed. Please check your email and password.");
        }
    }
}
