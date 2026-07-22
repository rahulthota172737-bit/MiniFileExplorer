package com.fileexplorer.manager;

import java.io.File;
import java.util.Scanner;

public class DirectoryManager{
    private static File currentDirectory =new File(System.getProperty("user.dir"));

    public void changeDirectory(Scanner sc) {

        System.out.print("Enter directory path: ");
        String path = sc.nextLine().trim();

        File directory = new File(path);

        if (!directory.isAbsolute()) {
            directory = new File(currentDirectory, path);
        }

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("The given path is not a directory.");
            return;
        }

        currentDirectory = directory.getAbsoluteFile();

        System.out.println("Current directory changed successfully.");
        System.out.println("Current Directory: " + currentDirectory.getAbsolutePath());
    }


    public void showCurrentDirectory() {
        System.out.println("\n===== Current Directory =====");
        System.out.println(currentDirectory.getAbsolutePath());
    }
}
