import Service.Authentication;

public class Main {
    public static void main(String[] args) {
        SubjectManagement subjectService = new SubjectManagement();
        Authentication auth = new Authentication();
        auth.Login();
    }
}