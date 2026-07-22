package com.fileexplorer.manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AdvancedFileManager{

    public void CopyFile(Scanner sc){
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


    public void MoveFile(Scanner sc){
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


    public void sortFiles(Scanner sc) {

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
