package Service;

import entities.Role;
import entities.User;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authentication {

    List<User> users;

    public  void Login(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập email: ");
            String inputEmail = scanner.nextLine();
            System.out.print("Nhập mật khẩu: ");
            String inputPassword = scanner.nextLine();
            boolean logged = false;
            for (User user : users) {
                if (user.login(inputEmail, inputPassword)) {
                    logged = true;
                    System.out.println("Đăng nhập thành công!");
                    switch (user.getRole()) {
                        case Student:
                            System.out.println("Welcome " + user.getName());
                            //xemDiem
                            break;
                        case Teacher:
                            System.out.println("Welcome " + user.getName());

                            break;
                        default:
                            System.out.println("Error!!!");
                            break;
                    }
                }
            }
            if(!logged){
                System.out.println("Đăng nhập thất bại. Email hoặc mật khẩu không đúng.");
            }

    }

}
