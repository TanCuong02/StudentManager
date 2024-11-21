package Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class School {
    public void start(){

        Authentication auth = new Authentication();
        Path fullPath = Paths.get("C:\\Users\\Admin\\OneDrive\\Desktop\\HSU\\OOP\\StudentManager");

        // Get the last part of the path
        Path shortPath = fullPath.getFileName();

        // Print the shortened path
        System.out.println("Shortened Path: " + shortPath);

    }
}
