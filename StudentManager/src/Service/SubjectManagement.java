package Service;

import entities.Semester;

import java.util.Scanner;

public class SubjectManagement {

    public static Integer requireInputSemester(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Chọn học kỳ:");
        System.out.println("1. học kỳ 1: ");
        System.out.println("2. Học kỳ 2: ");
        int inputSemester;
        do{
            System.out.print("Nhập lựa chọn: ");
            inputSemester = scanner.nextInt();
            scanner.nextLine();
            if(inputSemester < 1 || inputSemester > 2){
                System.out.println(" ");
                System.out.println("Học kỳ không tồn tại.");
            }
        } while(inputSemester < 1 || inputSemester > 2);

        return inputSemester;
    }


    public static Integer requireInputYear(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Năm học hiện có: 2022, 2023, 2024");
        System.out.println("Chọn năm học: ");
        int inputYear;
        do{
            inputYear = scanner.nextInt();
            scanner.nextLine();

            if (inputYear < 2022 || inputYear > 2024){
                System.out.println(" ");
                System.out.println("Năm học không hợp lệ");
            }
        } while (inputYear < 2022 || inputYear > 2024);

        return inputYear;
    }


    public static void implementHienThiDanhSachMonHocDangHoc(int inputYear, int inputSemester){
        switch(inputYear){
            case 2022:
                if (inputSemester == 1){
                    Semester.hk122.displayStudyingListSubjects();
                } else if (inputSemester == 2){
                    Semester.hk222.displayStudyingListSubjects();
                }
                break;

            case 2023:
                if (inputSemester == 1){
                    Semester.hk123.displayStudyingListSubjects();
                } else if (inputSemester == 2){
                    Semester.hk223.displayStudyingListSubjects();
                }
                break;

            case 2024:
                if (inputSemester == 1){
                    Semester.hk124.displayStudyingListSubjects();
                } else if (inputSemester == 2){
                    Semester.hk224.displayStudyingListSubjects();
                }
                break;
        }
    }

    public  void startXemDanhSachMonHoc(){
        int inputYear = requireInputYear();
        int inputSemester = requireInputSemester();
        implementHienThiDanhSachMonHocDangHoc(inputYear, inputSemester);
    }
}
