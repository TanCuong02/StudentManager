package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Semester {
    private int year;
    private int semesterCode;
    private List<Subject> fixedSubjects;
    private Subject specialSubject;

    // Base list of special subjects that all semesters can access
    public static final List<Subject> specialSubjectsBase = new ArrayList<>();

    static {
        specialSubjectsBase.add(new Subject("MUS", "Am nhac", true));
        specialSubjectsBase.add(new Subject("ART", "My thuat", true));
        specialSubjectsBase.add(new Subject("PE", "The duc", true));
        specialSubjectsBase.add(new Subject("PB", "Pickle Ball", true));
    }

    public Semester(int semesterCode, int year){
        this.semesterCode = semesterCode;
        this.year = year;

        fixedSubjects = new ArrayList<>();
        fixedSubjects.add(new Subject("MATH", "toan", false));
        fixedSubjects.add(new Subject("LIT", "van", false));
        fixedSubjects.add(new Subject("ENG", "anh", false));

        this.specialSubject = null;
    }


    //initialize base hoc ky
    public static final Semester hk122 = new Semester(1, 2022);
    public static final Semester hk222 = new Semester(2, 2022);
    public static final Semester hk123 = new Semester(1, 2023);
    public static final Semester hk223 = new Semester(2, 2023);
    public static final Semester hk124 = new Semester(1, 2024);
    public static final Semester hk224 = new Semester(2, 2024);

    public Semester() {

    }

    //xem mon hoc method
    public void showSujectList(){

        //confirm with user
        System.out.println(" ");
        System.out.println("Danh sách môn học");


        //Annouce success
        announceSuccess();

        //implement switch sign
        displayStudyingListSubjects();


        //show what's next instruction
        displayMenu(specialSubject);
    }

    //them mon hoc dac biet methods
    public void addSpecialSubject() {
        //confirm with user
        System.out.println(" ");
        System.out.println("Ban dang thuc hien chuc nang THEM mon hoc dac biet");

        // Show list of special subjects
        displayListSpecialSubjects();

        // Require user to input decision and validate
        Subject selectedMonHoc = requireInputAndValidatePickSpecialSubJect();

        //implement add special subject
        implementAddSpecialSubject(selectedMonHoc);

        //Annouce success
        announceSuccess();

        //display the list of studying
        displayStudyingListSubjects();

        //show what's next instruction
        displayMenu(specialSubject);

        System.out.println(" ");
    }

    // Method to edit the special subject of the semester
    public void updateSpecialSubject() {
        //confirm with user
        System.out.println(" ");
        System.out.println("Ban dang thuc hien chuc nang SUA mon hoc");

        // Show list of special subjects
        displayListSpecialSubjects();

        // Require user to input decision and validate
        Subject selectedMonHoc = requireInputAndValidatePickSpecialSubJect();

        //implement add special subject
        implementAddSpecialSubject(selectedMonHoc);


        //Annouce success
        announceSuccess();

        //display the list of studying
        displayListSpecialSubjects();

        //show what's next instruction
        displayMenu(specialSubject);

    }

    public void deleteSpecialSubject() {
        //confirm with user
        System.out.println(" ");
        System.out.println("Ban dang thuc hien chuc nang XOA mon hoc");

        //implement deletesubject
        implementAddSpecialSubject(specialSubject);

        //Annouce success
        announceSuccess();

        //display the list of studying
        displayListSpecialSubjects();

        //show what's next instruction
        displayMenu(specialSubject);

        System.out.println(" ");
    }


    //mini functions
    //display List of fixed subjects(studying)
    public void displayStudyingFixedSubjects(){
        System.out.println("DANH SACH MON HOC TRONG HOC KY " + semesterCode + " NAM " + year);
        for (Subject monHoc : fixedSubjects){
            System.out.println(monHoc);
        }
    }


    //display the special subject studying
    public void displayStudyingSpecialSubject(){
        if (specialSubject != null){
            System.out.println("Mon hoc dac biet dang hoc la: " + specialSubject);
        } else{
            System.out.println("Chua co mon hoc dac biet trong hoc ky nay");
        }
    }

    //display the list of studying subjects
    public void displayStudyingListSubjects(){
        displayStudyingFixedSubjects();
        displayStudyingSpecialSubject();
    }


    //display the list of available special subjects
    public void displayListSpecialSubjects(){
        System.out.println(" ");
        System.out.println("Danh sach cac mon hoc dac biet co san:");
        for (int i = 0; i < specialSubjectsBase.size(); i++) {
            System.out.println((i + 1) + ". " + specialSubjectsBase.get(i));
        }
    }


    //Require input pick special subject to add into semester
    public Subject requireInputAndValidatePickSpecialSubJect(){
        Scanner scanner = new Scanner(System.in);
        //require input
        int choice;
        //validate
        do {
            System.out.println(" ");
            System.out.println("Chon so thu tu cua mon hoc dac biet ban muon them (1-" + specialSubjectsBase.size() + "): ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < 1 || choice > specialSubjectsBase.size()){
                System.out.println(" ");
                System.out.println("Lua chon khong hop le. Hay thu lai.");
            }
        } while (choice < 1 || choice > specialSubjectsBase.size());

        Subject selectedMonHoc = specialSubjectsBase.get(choice - 1);
        return selectedMonHoc;
    }


    //implement add special subject into semester
    public void implementAddSpecialSubject(Subject selectedMonHoc){
        specialSubject = selectedMonHoc;
    }


    //implement delete subject
    public void implementdeleteSpecialSubject(){
        specialSubject = null;
    }


    //Announce successful add special subject
    public void announceSuccess(){
        System.out.println(" ");
        System.out.println("Thao tac tanh cong!");
    }

    //what's next instructions
    public void displayMenu(Subject specialSubject){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Ban muon lam gi tiep theo?");

        if(specialSubject == null){
            System.out.println("1. Them mon hoc dac biet");
            System.out.println("2. Ket thuc");
        } else {
            System.out.println("1. Sua mon hoc dac biet");
            System.out.println("2. Xoa mon hoc dac biet");
            System.out.println("3. Ket thuc");
        }

        int nextChoice;
        //validate decision input
        if (specialSubject == null){
            do {
                System.out.print("Hay nhap lua chon cua ban: ");
                nextChoice = scanner.nextInt();
                scanner.nextLine();
                if (nextChoice < 1 || nextChoice > 2){
                    System.out.println(" ");
                    System.out.println("Chi co 2 lua chon. Xin nhap lai");
                }
            } while (nextChoice < 1 || nextChoice > 2);
        } else {
            do {
                System.out.print("Hay nhap lua chon cua ban: ");
                nextChoice = scanner.nextInt();
                scanner.nextLine();
                if (nextChoice < 1 || nextChoice > 3){
                    System.out.println(" ");
                    System.out.println("Chi co 3 lua chon. Xin nhap lai");
                }
            } while (nextChoice < 1 || nextChoice > 3);
        }


        //thuc thi lua chon
        System.out.println(" ");
        if (nextChoice == 1 && specialSubject == null){
            addSpecialSubject();
        } else if (nextChoice == 2 && specialSubject == null){
            System.out.println("Hoan thanh!!!");
        } else if (nextChoice == 1 && specialSubject != null){
            updateSpecialSubject();
        } else if (nextChoice == 2 && specialSubject != null){
            deleteSpecialSubject();
        } else if (nextChoice == 3 && specialSubject != null){
            System.out.println("Hoan thanh!!!");
        }
    }

    @Override
    public String toString() {
        return "HocKy{" + "namHoc=" + year + ", maHocKy=" + semesterCode + '}';
    }
}
