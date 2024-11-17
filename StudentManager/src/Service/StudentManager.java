package Service;

import entities.Infomation;
import entities.Student;
import entities.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    public void start(){
        Authentication auth = new Authentication();
        auth.Login();
    }
}
