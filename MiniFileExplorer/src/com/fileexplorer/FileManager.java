package com.fileexplorer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    public static void createNewFile(Scanner sc){
        System.out.print("Enter the file name including extension:");
        String fileName=sc.nextLine().trim();

        if (fileName.isEmpty()) {
            System.out.println("File name cannot be empty.");
            return;
        }

        System.out.print("Enter the folder path:");
        String folderpath=sc.nextLine().trim();

        if (folderpath.isEmpty()) {
            System.out.println("Folder path cannot be empty.");
            return;
        }

        File folder = new File(folderpath);

        if (!folder.exists()) {
            System.out.println("Folder does not exist.");
            return;
        }

        if (!folder.isDirectory()) {
            System.out.println("The given path is not a folder.");
            return;
        }

        File targetFile = new File(folder, fileName);

        if(targetFile.exists()){
            System.out.println("File already exists.");
        }else{
            try {
                if (targetFile.createNewFile()) {
                    System.out.println("File created successfully.");
                } else {
                    System.out.println("Failed to create file.");
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void createFolder(Scanner sc){
        System.out.println("Enter folder Name");
        String folderName=sc.nextLine().trim();

        if (folderName.isEmpty()) {
            System.out.println("File name cannot be empty.");
            return;
        }

        System.out.print("Enter the folder path:");
        String folderpath=sc.nextLine().trim();

        if (folderpath.isEmpty()) {
            System.out.println("Folder path cannot be empty.");
            return;
        }

        File folder = new File(folderpath);
        if (!folder.exists()) {
            System.out.println("Folder does not exist.");
            return;
        }

        if (!folder.isDirectory()) {
            System.out.println("The given path is not a folder.");
            return;
        }

        File targetfolder = new File(folder, folderName);

        if(targetfolder.exists()){
            System.out.println("Folder already exists.");
        }else{
//            Create new folder does not need try catch because it will not throw exception
                if (targetfolder.mkdir()) {
                    System.out.println("Folder created successfully.");
                } else {
                    System.out.println("Failed to create folder.");
                }
        }

    }

    public static void delete(Scanner sc) {
        System.out.print("Enter the file/folder path: ");
        String path = sc.nextLine().trim();

        if (path.isEmpty()) {
            System.out.println("Path cannot be empty.");
            return;
        }

        File target = new File(path);

        if (!target.exists()) {
            System.out.println("File/Folder does not exist.");
            return;
        }

        if (target.delete()) {
            System.out.println("Deleted successfully.");
        } else {
            System.out.println("Failed to delete.");
            System.out.println("Note: A folder must be empty before it can be deleted.");
        }
    }

    public static void rename(Scanner sc) {
        System.out.print("Enter the current file/folder path: ");
        String currentPath = sc.nextLine().trim();

        if (currentPath.isEmpty()) {
            System.out.println("Path cannot be empty.");
            return;
        }

        File oldFile = new File(currentPath);

        if (!oldFile.exists()) {
            System.out.println("File/Folder does not exist.");
            return;
        }

        System.out.print("Enter the new name: ");
        String newName = sc.nextLine().trim();

        if (newName.isEmpty()) {
            System.out.println("New name cannot be empty.");
            return;
        }

        File newFile = new File(oldFile.getParent(), newName);

        if (newFile.exists()) {
            System.out.println("A file/folder with this name already exists.");
            return;
        }

        if (oldFile.renameTo(newFile)) {
            System.out.println("Renamed successfully.");
            System.out.println("New Path: " + newFile.getAbsolutePath());
        } else {
            System.out.println("Failed to rename.");
        }
    }
    public static void showFiles(Scanner sc){
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
    public static void showFolders(Scanner sc){
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

    public static void searchFile(Scanner sc) {
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
