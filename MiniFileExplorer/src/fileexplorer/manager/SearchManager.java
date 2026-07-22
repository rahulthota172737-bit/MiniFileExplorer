package com.fileexplorer.manager;

import java.io.File;
import java.util.Scanner;

public class SearchManager {

    public void showFiles(Scanner sc){
        System.out.print("Enter the current file path: ");
        String currentPath = sc.nextLine().trim();

        if (currentPath.isEmpty()) {
            System.out.println("Path cannot be empty.");
            return;
        }

        File Parentfile = new File(currentPath);

        if (!Parentfile.exists()) {
            System.out.println("Folder does not exist.");
            return;
        }

        if (!Parentfile.isDirectory()) {
            System.out.println("The given path is not a folder.");
            return;
        }

        File[] files = Parentfile.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Folder is empty.");
            return;
        }

        System.out.println("Files:");

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

    }

    public void showFolders(Scanner sc){
        System.out.println("Enter the current file path:");
        String currentPath = sc.nextLine().trim();

        if (currentPath.isEmpty()) {
            System.out.println("Path cannot be empty.");
            return;
        }

        File Parentfile = new File(currentPath);

        if (!Parentfile.exists()) {
            System.out.println("Folder does not exist.");
            return;
        }

        if (!Parentfile.isDirectory()) {
            System.out.println("The given path is not a folder.");
            return;
        }

        File[] files = Parentfile.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Folder is empty.");
            return;
        }

        System.out.println("Folders:");
        boolean found = false;
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
                found=true;
            }
        }

        if(!found){
            System.out.println("No folders found:");
        }
    }

    public  void searchFile(Scanner sc) {
        System.out.print("Enter the root folder path: ");
        String folderPath = sc.nextLine().trim();

        if (folderPath.isEmpty()) {
            System.out.println("Path cannot be empty.");
            return;
        }

        File rootFolder = new File(folderPath);

        if (!rootFolder.exists()) {
            System.out.println("Folder does not exist.");
            return;
        }

        if (!rootFolder.isDirectory()) {
            System.out.println("The given path is not a folder.");
            return;
        }

        System.out.print("Enter the file name: ");
        String fileName = sc.nextLine().trim();

        if (fileName.isEmpty()) {
            System.out.println("File name cannot be empty.");
            return;
        }

        boolean found = search(rootFolder, fileName);

        if (!found) {
            System.out.println("File not found.");
        }
    }

    public static boolean search(File folder, String fileName) {
        File[] files = folder.listFiles();

        if (files == null) {
            return false;
        }

        for (File file : files) {

            if (file.isFile() && file.getName().equals(fileName)) {
                System.out.println("File found:");
                System.out.println(file.getAbsolutePath());
                return true;
            }

            if (file.isDirectory()) {
                if (search(file, fileName)) {
                    return true;
                }
            }
        }

        return false;
    }
}
