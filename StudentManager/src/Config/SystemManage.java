package Config;

import Service.Authentication;
import Service.UserManagement;
import entities.Semester;
import entities.User;

import java.util.List;
import java.util.Scanner;

public class SystemManage {

    List<User> users;
    UserManagement userService;
    Authentication authentication;

    public SystemManage(List<User> users, Authentication authentication) {
        this.users = users;
        this.userService = new UserManagement(users);
        this.authentication = authentication;
    }
    public void menuFunctionForTeacher() {
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do {
            System.out.println("\tDANH SÁCH LỰA CHỌN CHỨC NĂNG\t");
            System.out.println("1. Xem danh sách học sinh");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Cập nhật thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Xem danh sách môn");
            System.out.println("6. Thêm môn học đặc biệt");
            System.out.println("7. Sửa môn học đặc biệt");
            System.out.println("8. Thêm môn học đặc biệt cho học sinh");
            System.out.println("9. Xoá môn học đặc biệt cho học sinh");
            System.out.println("10. Thêm điểm môn học đặc biệt cho học sinh");
            System.out.println("11. Sửa điểm môn học cho học sinh");
            System.out.println("12. Đăng xuất");
            System.out.println("13. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    userService.displayAllStudents();
                    break;
                case 2:
                    userService.createNewStudent();
                    break;
                case 3:
                    userService.updateStudentInfomation();
                    break;
                case 4:
                    userService.deleteStudent();
                    break;
                case 5:
                    startDisplayStudyingListSubjects();
                    break;
                case 6:
                    startAddSpecialSubject();
                    break;
                case 7:
                    startUpdateSpecialSubject();
                    break;
                case 8:
                    System.out.print("Nhập mã học sinh để thêm môn đặc biệt: ");
                    String studentCodeForSpecialSubjectAdd = sc.nextLine();
                    userService.addSpecialSubjectToStudent(studentCodeForSpecialSubjectAdd);
                    break;
                case 9:

                    break;
                case 10:
                    System.out.print("Nhập mã học sinh để thêm điểm môn đặc biệt: ");
                    String studentCodeForScore = sc.nextLine();
                    userService.addScoreSpecialSubjectForStudent(studentCodeForScore);
                    break;
                case 11:
                    System.out.print("Nhập mã học sinh để sửa điểm môn đặc biệt: ");
                    String studentCodeForEdit = sc.nextLine();
                    userService.editScoreSpecialSubjectForStudent(studentCodeForEdit);
                    break;
                case 12:
                    authentication.displayLogout();
                    break;
                case 13:
                    authentication.exit();
                    break;
                default:
                    System.out.println("Không hợp lệ.Vui lòng chọn lại!!!");
                    break;
            }
        } while (chon != 13);

    }

    public void menuFunctionForStudent(String userCode) {
        Scanner sc = new Scanner(System.in);
        int chon = 0;
        do {
            System.out.println("\tDANH SÁCH LỰA CHỌN CHỨC NĂNG\t");
            System.out.println("1. Xem điểm");
            System.out.println("2. Cập nhật thông tin");
            System.out.println("3. Đăng xuất");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    userService.displayStudentScore(userCode);
                    break;
                case 2:
                    userService.updateStudentInfomationByCode(userCode);
                    break;
                case 3:
                    authentication.displayLogout();
                    break;
                case 4:
                    authentication.exit();
                    break;

                default:
                    System.out.println("Không hợp lệ.Vui lòng chọn lại!!!");
                    break;
            }
        } while (chon != 4);


    }

    public Integer requireInputSemester(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Hay chon hoc ki cu the:");
        System.out.println("Nhap 1 neu la hk1");
        System.out.println("Nhap 2 net la hk2");
        int semesterInput;
        do{
            System.out.print("Hay nhap lua chon chon cua ban: ");
            semesterInput = scanner.nextInt();
            scanner.nextLine();
            if(semesterInput < 1 || semesterInput > 2){
                System.out.println(" ");
                System.out.println("Hoc ky KHONG HOP LE. HAY NHAP LAI (1 hoac 2)");
            }
        } while(semesterInput < 1 || semesterInput > 2);

        return semesterInput;
    }


    public Integer requireInputYear(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Sau day la cac nam hoc hien co: 2022, 2023, 2024");
        System.out.println("Ban muon xem hoc ki cua nam nao?");
        System.out.print("Hay nhap vao lua chon cua ban: ");
        int yearInput;
        do{
            yearInput = scanner.nextInt();
            scanner.nextLine();

            if (yearInput < 2022 || yearInput > 2024){
                System.out.println(" ");
                System.out.println("Nam hoc KHONG HOP LE. HAY NHAP LAI (2021-2024)");
            }
        } while (yearInput < 2022 || yearInput > 2024);

        return yearInput;
    }


    public void implementDisplayStudyingListSubjects(int yearInput, int semesterInput){
        switch(yearInput){
            case 2022:
                if (semesterInput == 1){
                    Semester.hk122.showSujectList();
                } else if (semesterInput == 2){
                    Semester.hk222.showSujectList();
                }
                break;

            case 2023:
                if (semesterInput == 1){
                    Semester.hk123.showSujectList();
                } else if (semesterInput == 2){
                    Semester.hk223.showSujectList();
                }
                break;

            case 2024:
                if (semesterInput == 1){
                    Semester.hk124.showSujectList();
                } else if (semesterInput == 2){
                    Semester.hk224.showSujectList();
                }
                break;
        }
    }

    public void startDisplayStudyingListSubjects(){
        int yearInput = requireInputYear();
        int semesterInput = requireInputSemester();
        implementDisplayStudyingListSubjects(yearInput, semesterInput);
    }



    public void implementUpdateSpecialSubject(int yearInput, int semesterInput){
        switch(yearInput){
            case 2022:
                if (semesterInput == 1){
                    Semester.hk122.updateSpecialSubject();
                } else if (semesterInput == 2){
                    Semester.hk222.updateSpecialSubject();
                }
                break;

            case 2023:
                if (semesterInput == 1){
                    Semester.hk123.updateSpecialSubject();
                } else if (semesterInput == 2){
                    Semester.hk223.updateSpecialSubject();
                }
                break;

            case 2024:
                if (semesterInput == 1){
                    Semester.hk124.updateSpecialSubject();
                } else if (semesterInput == 2){
                    Semester.hk224.updateSpecialSubject();
                }
                break;
        }
    }

    public void startUpdateSpecialSubject(){
        int yearInput = requireInputYear();
        int semesterInput = requireInputSemester();
        implementUpdateSpecialSubject(yearInput, semesterInput);
    }

    public void implementAddSpecialSubject(int yearInput, int semesterInput){
        switch(yearInput){
            case 2022:
                if (semesterInput == 1){
                    Semester.hk122.addSpecialSubject();
                } else if (semesterInput == 2){
                    Semester.hk222.addSpecialSubject();
                }
                break;

            case 2023:
                if (semesterInput == 1){
                    Semester.hk123.addSpecialSubject();
                } else if (semesterInput == 2){
                    Semester.hk223.addSpecialSubject();
                }
                break;

            case 2024:
                if (semesterInput == 1){
                    Semester.hk124.addSpecialSubject();
                } else if (semesterInput == 2){
                    Semester.hk224.addSpecialSubject();
                }
                break;
        }
    }

    public void startAddSpecialSubject(){
        int yearInput = requireInputYear();
        int semesterInput = requireInputSemester();
        implementAddSpecialSubject(yearInput, semesterInput);
    }

}
