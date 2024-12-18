package Service;

import entities.Role;
import entities.User;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class UserManagement {
    List<User> users;
    Set<String> subjects;

    public UserManagement(List<User> users) {
        this.users = users;
        this.subjects = new HashSet<>();
    }

    public void displayAllStudents() {
        System.out.println("==============================================");
        System.out.println("Danh sách học sinh");
        for (User user : users) {
            if (!user.isDeleted()) {
                if (user.getRole() == Role.Student) {
                    System.out.println("Tên: " + user.getName() + "  Mã:" + user.getCode() + "  Ngày sinh: " + user.getBirthDay() + "  Giới tính: " + user.getGender() + "  Địa chỉ: " + user.getAddress() + "  Email: " + user.getEmail() + "   Điểm Văn:" + user.getLiteratureScore() + "   Điểm Toán:" + user.getMathScore() + "   Điểm Anh:" + user.getEnglishScore());
                    System.out.println();
                }
            }
        }
        }

    public void displayStudentInfomation(String userCode) {
        for (User user : users) {
            if (user.getCode().equals(userCode)) {
                System.out.println("Thông tin của bạn");
                System.out.println("Tên: " + user.getName());
                System.out.println("Ngày sinh: " + user.getBirthDay());
                System.out.println("Giới Tính: " + user.getGender());
                System.out.println("Địa chỉ: " + user.getAddress());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Điểm Văn:" + user.getLiteratureScore());
                System.out.println("Điểm Toán:" + user.getMathScore());
                System.out.println("Điểm Anh:" + user.getEnglishScore());
                System.out.println();
            }
        }
    }
    public void displayStudentScore(String userCode) {
        for (User user : users) {
            if (user.getCode().equals(userCode)) {
                System.out.println("Điểm của bạn");
                System.out.println("Toán: " + user.getMathScore());
                System.out.println("Văn: " + user.getLiteratureScore());
                System.out.println("Tiếng Anh: " + user.getEnglishScore());
                Map<String, Double> score = user.getAdditionalScores();
                if(score == null || score.isEmpty()) {
                    System.out.println("Không có môn đặc biệt");
                }else {
                    for (Map.Entry<String, Double> entry : score.entrySet()) {
                        String subject = entry.getKey();
                        Double spsScore = entry.getValue();
                        System.out.println("Môn " + subject + ": " + spsScore);
                    }
                }
                System.out.println("Điểm trung bình: " + user.calculateAverageScore());

                System.out.println();
            }
        }
    }

    public void addNewStudent(User newUser) {
        // Kiểm tra xem học sinh đã tồn tại chưa
        for (User user : users) {
            if (user.getCode().equalsIgnoreCase(newUser.getCode())) {
                System.out.println("Mã học sinh đã tồn tại.");
                return; // Thoát khỏi phương thức nếu học sinh đã tồn tại
            }
        }
        // Nếu không tìm thấy, thêm học sinh mới vào danh sách
        users.add(newUser);
        System.out.println("Đã thêm học sinh mới");
        displayStudentScore(newUser.getCode());
    }
    public void createNewStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Thêm mới học sinh");
        System.out.print("Nhập mã học sinh:");
        String newCode = sc.nextLine();
        System.out.print("Nhập họ và tên học sinh:");
        String newFullName = sc.nextLine();
        System.out.print("Nhập ngày tháng năm sinh(YYYY-MM-DD):");
        String newBirthDay = sc.nextLine();
        System.out.print("Nhập giới tính:");
        String newGender = sc.nextLine();
        System.out.print("Nhập địa chỉ:");
        String newAddress = sc.nextLine();
        System.out.print("Nhập email:");
        String newEmail = sc.nextLine();
        System.out.print("Nhập mật khẩu:");
        String newPassword = sc.nextLine();
        System.out.println("Nhâp điểm môn Văn:");
        double newScoreLiterature = sc.nextDouble();
        System.out.println("Nhâp điểm môn Toán:");
        double newScoreMath = sc.nextDouble();
        System.out.println("Nhâp điểm môn Anh:");
        double newScoreEnglish = sc.nextDouble();
        boolean status = false;
        User newUser = new User(newCode, newFullName, newBirthDay, newGender, newAddress, newEmail, newPassword, Role.Student, status, newScoreMath, newScoreEnglish, newScoreLiterature);

        // Add the new user to the UserService
        addNewStudent(newUser);
    }

    public void updateStudentInfomationByCode(String userCode) {
        Scanner sc = new Scanner(System.in);
        boolean updateCheck = false;
        for (User user : users) {
            if (user.getCode().equals(userCode)) {
                displayStudentInfomation(userCode);
                System.out.println("Nhập thông tin cá nhân bạn muốn sửa: ");
                System.out.println("Tên: ");
                user.setName(sc.nextLine());
                System.out.println("Email: ");
                user.setEmail(sc.nextLine());
                System.out.println("Password: ");
                user.setPassword(sc.nextLine());
                System.out.println("Giới Tính: ");
                user.setGender(sc.nextLine());
                System.out.println("Ngày sinh: ");
                user.setBirthDay(sc.nextLine());
                System.out.println("Địa chỉ: ");
                user.setAddress(sc.nextLine());
                updateCheck = true;
                System.out.println("Cập nhật thành công");
                System.out.println();
            }
        }
        if (!updateCheck) {
            System.out.println("Cập nhật không thành công");
        }
    }
    public void updateStudentInfomation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cập nhật thông tin học sinh");
        System.out.print("Nhập mã học sinh cần cập nhật:");
        String updateCode = sc.nextLine();
        boolean updated = false;
        for (User user : users) {
            if (user.getCode().equals(updateCode) && user.getRole() == Role.Student) {
                System.out.print("Nhập tên:");
                user.setName(sc.nextLine());
                System.out.print("Nhập ngày sinh(YYYY-MM-DD):");
                user.setBirthDay(sc.nextLine());
                System.out.print("Nhập giới tính:");
                user.setGender(sc.nextLine());
                System.out.print("Nhập địa chỉ:");
                user.setAddress(sc.nextLine());
                System.out.print("Nhập email:");
                user.setEmail(sc.nextLine());
                System.out.print("Nhập mật khẩu:");
                user.setPassword(sc.nextLine());
                updated = true;
                System.out.println("Thông tin học sinh đã được cập nhật!!!");
                break;
            }
        }
        if (!updated) {
            System.out.println("Không tìm thấy học sinh với mã đã nhập!!!");
        }
    }

    public void deleteStudentByCode(String code) {
        boolean found = false;
        for (User user : users) {
            if (user.getCode().equals(code) && user.getRole() == Role.Student) {
                user.setDeleted(true);
                found = true;
                System.out.println("Học sinh với mã " + code + " đã bị xóa!!!");
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy học sinh với mã " + code);
        }
    }
    public void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Xóa học sinh");
        System.out.print("Nhập mã học sinh cần xóa:");
        String studentCode = sc.nextLine();
        deleteStudentByCode(studentCode);
    }

    public void addSpecialSubjectToStudent(String userCode) {
        Scanner sc = new Scanner(System.in);
        boolean found = false;

        System.out.print("Nhập mã môn học đặc biệt để thêm: ");
        String subjectCode = sc.nextLine(); // Trim whitespace

        // Check for empty input
        if (subjectCode.isEmpty()) {
            System.out.println("Mã môn học không được để trống.");
            return;
        }

        // Find the student by user code
        for (User user : users) {
            if (user.getCode().equals(userCode) && user.getRole() == Role.Student) {
                found = true;
                // Add the special subject to the user's list of special subjects
                user.addSpecialSubject(subjectCode);
                // Add the special subject with an initial score of 0.0
                user.setAdditionalScore(subjectCode, 0.0);
                System.out.println("Môn " + subjectCode + " đã được thêm cho học sinh " + user.getName());
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy học sinh với mã " + userCode);
        }
    }
    public void addScoreSpecialSubjectForStudent(String userCode) {
        Scanner sc = new Scanner(System.in);
        boolean found = false;

        System.out.print("Nhập mã môn học đặc biệt: ");
        String subjectCode = sc.nextLine();

        // Find the student by user code
        for (User user : users) {
            if (user.getCode().equals(userCode) && user.getRole() == Role.Student) {
                found = true;

                // Check if the subject exists in the user's special subjects
                if (!user.getAdditionalScores().containsKey(subjectCode)) {
                    System.out.println("Môn học " + subjectCode + " không tồn tại cho học sinh này. Vui lòng thêm môn học trước.");
                    return;
                }

                System.out.print("Nhập điểm cho môn " + subjectCode + ": ");
                String input = sc.nextLine();

                try {
                    double score = Double.parseDouble(input);
                    user.setAdditionalScore(subjectCode, score); // For additional subjects
                    System.out.println("Điểm cho môn " + subjectCode + " đã được thêm cho học sinh " + user.getName());
                    System.out.println("Điểm Văn:"+user.getLiteratureScore());
                    System.out.println("Điểm Toán:"+user.getMathScore());
                    System.out.println("Điểm Anh:"+user.getEnglishScore());
                    Map<String, Double> spsScore = user.getAdditionalScores();
                    if(spsScore == null || spsScore.isEmpty()) {
                        System.out.println("Không có môn đặc biệt");
                    }else {
                        for (Map.Entry<String, Double> entry : spsScore.entrySet()) {
                            String subject = entry.getKey();
                            Double point = entry.getValue();
                            System.out.println("Môn " + subject + ": " + point);
                        }
                    }
                    // Calculate and display average score
                    double averageScore = user.calculateAverageScore();
                    System.out.println("Điểm trung bình của học sinh " + user.getName() + ": " + averageScore);
                } catch (NumberFormatException e) {
                    System.out.println("Điểm không hợp lệ!");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy học sinh với mã " + userCode);
        }
    }

    // Method to update score for a special subject for a specific student
    public void editScoreSpecialSubjectForStudent(String userCode) {
        Scanner sc = new Scanner(System.in);
        boolean found = false;

        System.out.print("Nhập mã môn học đặc biệt để sửa điểm: ");
        String subjectCode = sc.nextLine();

        // Check if the subject exists in the predefined list or as an additional score
        if (!subjects.contains(subjectCode) && !additionalScoresExist(userCode, subjectCode)) {
            System.out.println("Môn học " + subjectCode + " không tồn tại hoặc chưa được thêm cho học sinh.");
            return;
        }

        // Find the student by user code
        for (User user : users) {
            if (user.getCode().equals(userCode) && user.getRole() == Role.Student) {
                found = true;

                System.out.print("Nhập điểm mới cho môn " + subjectCode + " (hoặc để trống để xem điểm trung bình): ");
                String input = sc.nextLine();

                if (!input.isEmpty()) {
                    try {
                        double newScore = Double.parseDouble(input);

                        // Update the score based on whether it is a fixed or additional subject
                        if (subjectCode.equalsIgnoreCase("Toán")) {
                            user.setMathScore(newScore);
                        } else if (subjectCode.equalsIgnoreCase("Văn")) {
                            user.setLiteratureScore(newScore);
                        } else if (subjectCode.equalsIgnoreCase("Anh")) {
                            user.setEnglishScore(newScore);
                        } else {
                            user.setAdditionalScore(subjectCode, newScore); // For additional subjects
                        }

                        System.out.println("Điểm cho môn " + subjectCode + " đã được cập nhật cho học sinh " + user.getName());
                        System.out.println("Điểm Văn:"+user.getLiteratureScore());
                        System.out.println("Điểm Toán:"+user.getMathScore());
                        System.out.println("Điểm Anh:"+user.getEnglishScore());
                    } catch (NumberFormatException e) {
                        System.out.println("Điểm không hợp lệ! Hiện tại sẽ hiển thị điểm trung bình.");
                    }
                }

                // Display average score regardless of input validity
                double averageScore = user.calculateAverageScore();
                System.out.println("Điểm trung bình của học sinh " + user.getName() + ": " + averageScore);
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy học sinh với mã " + userCode);
        }
    }
    private boolean additionalScoresExist(String userCode, String subjectName) {
        for (User user : users) {
            if (user.getCode().equals(userCode)) {
                return user.getAdditionalScores().containsKey(subjectName);
            }
        }
        return false;
    }
}


