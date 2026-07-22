package com.fileexplorer.interfaces;

import java.util.Scanner;

public interface FileInterface {


        void createNewFile(Scanner sc);

        void createFolder(Scanner sc);

        void delete(Scanner sc);

        void rename(Scanner sc);

        void searchFile(Scanner sc);

        void showFolders(Scanner sc);

        void showFiles(Scanner sc);

        void Filedetails(Scanner sc);

        void changeDirectory(Scanner sc);

        void CopyFile(Scanner sc);

        void MoveFile(Scanner sc);

        void sortFiles(Scanner sc);

        void showCurrentDirectory();

}
