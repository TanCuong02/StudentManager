package Service;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class School {
    public void start(){
        Authentication auth = new Authentication();
        auth.Login();
    }
}
