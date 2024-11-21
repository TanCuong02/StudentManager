package Service;

import entities.User;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authentication {

    private  List<User> users;
    public  Authentication() {
        users = new ArrayList<>();
        loadUsers();
    }

    private void loadUsers() {
        URL resource = getClass().getResource("/user.txt");

        if (resource != null) {
            try (InputStream inputStream = resource.openStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

                String line;
                while ((line = br.readLine()) != null) {
                    // Tạo đối tượng Student từ thông tin trong tệp
                    User user = parseUser(line);
                    if (user != null) {
                        users.add(user);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Tệp user.txt không tìm thấy.");
        }
    }

    private User parseUser(String line) {
        // Giả sử mỗi sinh viên được lưu trong một dòng
        String[] parts = line.split(",");
        if (parts.length == 7) {
            String code = parts[0].trim();
            String name = parts[1].trim();
            String birthday = parts[2].trim();
            String gender = parts[3].trim();
            String address = parts[4].trim();
            String email = parts[5].trim();
            String password = parts[6].trim();
            return new User(code, name, birthday, gender, address, email, password);
        }
        return null;
    }


    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thêm sinh viên mới:");
        System.out.print("Mã sinh viên: ");
        String studentCode = scanner.nextLine();
        System.out.print("Tên: ");
        String name = scanner.nextLine();
        System.out.print("Ngày sinh (YYYY-MM-DD): ");
        String birthday = scanner.nextLine();
        System.out.print("Giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Mật khẩu: ");
        String password = scanner.nextLine();

        addStudent(studentCode, name, birthday, gender, address, email, password);
    }
    public void addStudent(String code, String name, String birthday, String gender, String address, String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                System.out.println("Sinh viên với email này đã tồn tại.");
                return;
            }
        }
        User newUSer = new User(code, name, birthday, gender, address, email, password);
        users.add(newUSer);
        URL resource = getClass().getClassLoader().getResource("user.txt");
        if (resource != null) {
            String filePath = resource.getPath();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                String dataToWrite = code + "," + name + "," + birthday + "," + gender + "," + address + "," + email + "," + password;
                System.out.println("Dữ liệu sẽ được ghi: " + dataToWrite); // In ra dữ liệu sẽ ghi
                bw.write(dataToWrite);
                bw.newLine(); // Thêm dòng mới
                System.out.println("Thêm sinh viên thành công!");
            } catch (IOException e) {
                System.out.println("Có lỗi xảy ra khi thêm sinh viên: " + e.getMessage());
            }
        }
    }

    public  void Login(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập email: ");
            String inputEmail = scanner.nextLine();
            System.out.print("Nhập mật khẩu: ");
            String inputPassword = scanner.nextLine();

            for (User user : users) {
                if (user.login(inputEmail, inputPassword)) {
                    System.out.println("Đăng nhập thành công!");
                    input();
                    return;
                }
            }

            System.out.println("Đăng nhập thất bại. Email hoặc mật khẩu không đúng.");
    }
}
