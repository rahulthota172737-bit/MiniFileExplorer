package com.fileexplorer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileManager {
    private static File currentDirectory =new File(System.getProperty("user.dir"));


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
    public static void Filedetails(Scanner sc){
        System.out.print("Enter file/folder path: ");
        String path = sc.nextLine().trim();

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File or Folder does not exist.");
            return;
        }


        System.out.println("Name: " + file.getName());

        if (file.isFile()) {
            System.out.println("Type: File");
        } else {
            System.out.println("Type: Directory");
        }

        if (file.isFile()) {
            String name = file.getName();
            int index = name.lastIndexOf('.');

            if (index != -1) {
                System.out.println("Extension : " + name.substring(index + 1));
            } else {
                System.out.println("Extension : No Extension");
            }
        } else {
            System.out.println("Extension : N/A");
        }

        if (file.isFile()) {
            long size = file.length();

            if (size < 1024) {
                System.out.println("Size: " + size + " Bytes");
            } else if (size < 1024 * 1024) {
                System.out.printf("Size: %.2f KB%n", size / 1024.0);
            } else {
                System.out.printf("Size: %.2f MB%n", size / (1024.0 * 1024));
            }
        } else {
            System.out.println("Size: --");
        }

        System.out.println("Absolute Path  : " + file.getAbsolutePath());

        Instant instant = Instant.ofEpochMilli(file.lastModified());

        ZonedDateTime dateTime = instant.atZone(ZoneId.systemDefault());

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a");

        System.out.println("Last Modified  : " + dateTime.format(formatter));
    }
    public static void changeDirectory(Scanner sc) {

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

    public static void showCurrentDirectory() {
        System.out.println("\n===== Current Directory =====");
        System.out.println(currentDirectory.getAbsolutePath());
    }
}


