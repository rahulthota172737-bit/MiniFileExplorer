package com.fileexplorer;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void displayMenu(){
        System.out.println("========== MINI FILE EXPLORER ==========");
        System.out.println("1. Create File");
        System.out.println("2. Create Folder");
        System.out.println("3. Delete");
        System.out.println("4. Rename");
        System.out.println("5. Exit");
    }

    public static void processChoice(int choice,Scanner sc,FileManager fileManager){
        switch(choice){
            case 1:
                fileManager.createNewFile(sc);
                System.out.println();
                break;
            case 2:
                fileManager.createFolder(sc);
                System.out.println();
                break;
            case 3:
                fileManager.delete(sc);
                System.out.println();
                break;
            case 4:
                fileManager.rename(sc);
                System.out.println();
                break;
            case 5:
                System.out.println("Thank you for using Mini File Explorer.");
                System.out.println();
                break;
            default:
                System.out.println("Enter the correct choice");
                System.out.println();
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        int choice=0;
        while(choice!=5){
            displayMenu();
            System.out.print("Enter your choice:");
            choice=sc.nextInt();
            sc.nextLine();

            processChoice(choice,sc,fileManager);
        }
        sc.close();
    }
}
