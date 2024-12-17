package entities;

public class Subject {
    private String subjectCode;
    private String subjectName;
    private boolean isSpecialSubject;


    public Subject(String subjectCode, String subjectName, boolean isSpecialSubject) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.isSpecialSubject = isSpecialSubject;
    }


    // toString method to display information about the subject
    @Override
    public String toString() {
        return "Mã môn học: " + subjectCode + ", Tên môn học: " + subjectName +
                (isSpecialSubject ? ", là môn học đặt biệt" : ", là môn học cố định");
    }
}
