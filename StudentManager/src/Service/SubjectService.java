package Service;

import entities.Role;
import entities.Subject;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectService {
    private List<Subject> subjects;



    // Constructor to initialize the subjects list
    public SubjectService() {
        subjects = new ArrayList<>();
        Subject math = new Subject("MATH01","Math");
        Subject english = new Subject("ENG01", "English");

        subjects.add(math);
        subjects.add(english);

        math.addOrUpdateScore("S1", 5);
        english.addOrUpdateScore("S1", 7);
    }

    // Method to add a new subject
    public void addSubject() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Thêm môn học mới:");
        System.out.print("Mã môn học: ");
        String subjectCode = scanner.nextLine();
        System.out.print("Tên môn học: ");
        String subjectName = scanner.nextLine();

        // Check if the subject already exists
        for (Subject subject : subjects) {
            if (subject.getCode().equals(subjectCode)) {
                System.out.println("Môn học với mã " + subjectCode + " đã tồn tại.");
                return;
            }
        }

        // Add the new subject to the list
        Subject newSubject = new Subject(subjectCode, subjectName);
        subjects.add(newSubject);
        System.out.println("Đã thêm môn học: " + subjectName + " (Mã: " + subjectCode + ")");
    }

    // Method to assign a score to a student for a specific subject
    public void assignScore(String subjectCode, String studentCode, float grade) {
        List<User> users = new ArrayList<>();
        users.add(new User("S1","TC", "2002-12-13","Nam","HCM","a@gmail.com","123", Role.valueOf("Student")));
        subjects.add(new Subject("Math1", "Math"));
        for (Subject subject : subjects) {
            if (subject.getCode().equals(subjectCode)) {
                subject.addOrUpdateScore(studentCode, grade);
                System.out.println("Đã thêm hoặc cập nhật điểm cho sinh viên " + studentCode + " trong môn học " + subjectCode);
                return;
            }
        }
    }

    // Method to view a student's score for a specific subject
    public void viewScore(String subjectCode, String studentCode) {
        for (Subject subject : subjects) {
            if (subject.getCode().equals(subjectCode)) {
                Float score = subject.viewScore(studentCode);
                if (score != null) {
                    System.out.println("Điểm của sinh viên " + studentCode + " trong môn học " + subjectCode + ": " + score);
                } else {
                    System.out.println("Sinh viên " + studentCode + " chưa có điểm trong môn học này.");
                }
                return;
            }
        }

    }

    public String getSubjectByCode(String code){
        boolean find = false;
        for(Subject subject: subjects){
            if(subject.getCode().equals(code)){
                return subject.getCode();
            }
        }
        if(!find){
            System.out.println("Không tìm thấy môn học");
        }
        return code;
    }
    public void viewAllScores(String studentCode) {
        System.out.println("Điểm của sinh viên :");
        boolean hasScores = false;

        for (Subject subject : subjects) {
            Float score = subject.viewScore(studentCode);
            if (score != null) {
                System.out.println("Môn học: " + subject.getCode() + " - Điểm: " + score);
                hasScores = true;
            }
        }

        if (!hasScores) {
            System.out.println("Sinh viên chưa có điểm trong bất kỳ môn học nào.");
        }
    }
}
