package com.fileexplorer;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static com.fileexplorer.FileManager.Filedetails;

public class Main {
    public static void displayMenu(){
        System.out.println("========== MINI FILE EXPLORER ==========");
        System.out.println("1. Create File");
        System.out.println("2. Create Folder");
        System.out.println("3. Delete");
        System.out.println("4. Rename");
        System.out.println("5. ShowFiles");
        System.out.println("6. ShowFolders");
        System.out.println("7. SearchFiles");
        System.out.println("8. File Details");
        System.out.println("9. Change Directory");
        System.out.println("10. Show Current Directory");
        System.out.println("11. Exit");
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
                fileManager.showFiles(sc);
                System.out.println();
                break;
            case 6:
                fileManager.showFolders(sc);
                System.out.println();
                break;
            case 7:
                fileManager.searchFile(sc);
                System.out.println();
                break;
            case 8:
                fileManager.Filedetails(sc);
                System.out.println();
                break;
            case 9:
                fileManager.changeDirectory(sc);
                System.out.println();
                break;
            case 10:
                fileManager.showCurrentDirectory();
                System.out.println();
                break;
            case 11:
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
        while(choice!=8){
            displayMenu();
            System.out.print("Enter your choice:");
            choice=sc.nextInt();
            sc.nextLine();

            processChoice(choice,sc,fileManager);
        }
        sc.close();
    }
}
