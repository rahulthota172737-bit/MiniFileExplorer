package com.fileexplorer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.io.File;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

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
    public static void CopyFile(Scanner sc){
        System.out.println("Enter Source File Path:");
        String source = sc.nextLine().trim();

        if(source.isEmpty()){
            System.out.println("File Cannot be empty");
            return;
        }

        File first = new File(source);

        if(!first.exists()){
            System.out.println("File doesnt exist");
            return;
        }

        if(!first.isFile()){
            System.out.println("The current path is not a file");
            return;
        }

        System.out.println("Enter Destination path");
        String destination = sc.nextLine().trim();

        if(destination.isEmpty()){
            System.out.println("Destination cannot be empty");
            return;
        }

        File second = new File(destination);

        if(!second.exists()){
            System.out.println("Folder Does not exist");
            return;
        }

        if(!second.isDirectory()){
            System.out.println("The given path is not Folder");
            return;
        }

        File destinationFile = new File(destination, first.getName());

        try{
            Files.copy(first.toPath(),destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully");
            System.out.println("New File Path is:"+destinationFile.getAbsolutePath());
        }catch(IOException e){
            System.out.println("Error Message:"+e.getMessage());
        }
    }
    public static void MoveFile(Scanner sc){
        System.out.println("Enter the source path:");
        String sourcepath = sc.nextLine().trim();

        if(sourcepath.isEmpty()){
            System.out.println("File Path Cannot be empty");
            return;
        }

        File source = new File(sourcepath);

        if(!source.exists()){
            System.out.println("Source not exist");
            return;
        }

        if(!source.isFile()){
            System.out.println("It is not a file");
            return;
        }

        System.out.println("Enter the Destination path:");
        String destinationpath = sc.nextLine().trim();

        if(destinationpath.isEmpty()){
            System.out.println("File Path Cannot be empty");
            return;
        }

        File destination = new File(destinationpath);

        if(!destination.exists()){
            System.out.println("Destination folder does not exist.");
            return;
        }

        if(!destination.isDirectory()){
            System.out.println("The Path is not a folder");
            return;
        }

        File destinationfilepath = new File(destination,source.getName());

        try{
            Files.move(source.toPath(),destinationfilepath.toPath(),StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved Successfully");
            System.out.println("New File Path:"+destinationfilepath.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error Message:"+e.getMessage());
        }

    }
    public static void sortFiles(Scanner sc) {

        System.out.print("Enter folder path: ");
        String folderPath = sc.nextLine().trim();

        if (folderPath.isEmpty()) {
            System.out.println("Folder path cannot be empty.");
            return;
        }

        File folder = new File(folderPath);

        if (!folder.exists()) {
            System.out.println("Folder does not exist.");
            return;
        }

        if (!folder.isDirectory()) {
            System.out.println("The given path is not a folder.");
            return;
        }

        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Folder is empty.");
            return;
        }

        System.out.println("\nSort By");
        System.out.println("1. Name");
        System.out.println("2. Size");
        System.out.println("3. Last Modified Date");
        System.out.print("Enter your choice: ");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {

            case 1:
                Arrays.sort(files, Comparator.comparing(File::getName));
                break;

            case 2:
                Arrays.sort(files, Comparator.comparingLong(File::length));
                break;

            case 3:
                Arrays.sort(files, Comparator.comparingLong(File::lastModified));
                break;

            default:
                System.out.println("Invalid Choice");
                return;
        }

        System.out.println("\nSorted Files:");

        for (File file : files) {

            if (file.isFile()) {
                System.out.printf("%-25s %10d Bytes%n",
                        file.getName(),
                        file.length());
            }
        }
    }
}


