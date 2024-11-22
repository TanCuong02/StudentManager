package Service;


public class SystemService {
    public void start(){
        SubjectService subjectService = new SubjectService();
        Authentication auth = new Authentication(subjectService);
        auth.Login();
    }
}
