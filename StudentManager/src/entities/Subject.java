
package entities;
import java.util.HashMap;
import java.util.Map;

public class Subject {
    private String code; // Subject code
    private String name; // Subject name
    private Map<String, Float> studentScores; // Key: Student code, Value: Grade

    // Constructor
    public Subject(String code, String name) {
        this.code = code;
        this.name = name;
        this.studentScores = new HashMap<>();
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Map<String, Float> getStudentScores() {
        return studentScores;
    }

    // Add or update a student's score
    public void addOrUpdateScore(String studentCode, float grade) {
        studentScores.put(studentCode, grade); // Add or overwrite the score
    }

    // View a student's score
    public Float viewScore(String studentCode) {
        return studentScores.getOrDefault(studentCode, null);
    }

    // Remove a student's score
    public boolean removeScore(String studentCode) {
        if (studentScores.containsKey(studentCode)) {
            studentScores.remove(studentCode);
            return true;
        }
        return false;
    }

    public Map<String, Float> getAllScores() {
        return studentScores;
    }


    @Override
    public String toString() {
        return "Mã môn học: " + code + ", Tên môn học: " + name + ", Số sinh viên: " + studentScores.size();
    }

}
