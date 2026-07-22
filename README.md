# 📁 Mini File Explorer

A console-based File Explorer application built in **Java** that allows users to perform common file and directory operations from the command line. This project was developed to practice **Core Java**, **Object-Oriented Programming (OOP)**, **Java File Handling**, and **clean project organization**.

---

## 🚀 Features

- 📄 Create File
- 📁 Create Folder
- 🗑️ Delete File/Folder
- ✏️ Rename File/Folder
- 🔍 Search File/Folder
- 🔄 Recursive Search
- 📂 List Files
- 📁 List Folders
- ℹ️ View File Details
- 📋 Copy File
- 🚚 Move File
- 🔤 Sort Files by Name
- 📏 Sort Files by Size
- 📅 Sort Files by Last Modified Date
- 📍 Change Current Directory
- 🖥️ Show Current Directory
- ⚠️ Exception Handling for Invalid Operations

---

## 🛠️ Technologies Used

- Java
- Java NIO (`java.nio.file`)
- Java IO (`java.io`)
- Object-Oriented Programming (OOP)

---

## 🏗️ Project Structure

```
MiniFileExplorer/
│
├── src/
│   └── fileexplorer/
│       ├── Main.java
│       ├── interfaces/
│       │     └── FileInterface.java
│       └── manager/
│             ├── FileManager.java
│             ├── SearchManager.java
│             ├── DirectoryManager.java
│             └── AdvancedFileManager.java
│
├── README.md
└── .gitignore
```

---

## 📚 OOP Concepts Used

### Encapsulation
- Organized code into multiple classes with clear responsibilities.

### Abstraction
- Implemented using the `FileInterface`.

### Polymorphism
- Used interface reference:

```java
FileInterface fileManager = new FileManager();
```

### Composition
- `FileManager` delegates responsibilities to:
  - `SearchManager`
  - `DirectoryManager`
  - `AdvancedFileManager`

---

## 📂 Functional Modules

### FileManager
Handles core file operations:
- Create File
- Create Folder
- Delete
- Rename
- File Details

### SearchManager
Handles:
- Search
- Recursive Search
- List Files
- List Folders

### DirectoryManager
Handles:
- Change Directory
- Show Current Directory

### AdvancedFileManager
Handles:
- Copy File
- Move File
- Sort Files

---

## ▶️ How to Run

1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/MiniFileExplorer.git
```

2. Open the project in IntelliJ IDEA (or any Java IDE).

3. Compile and run:

```
Main.java
```

4. Use the menu displayed in the console.

---

## 📖 What I Learned

- Java File Handling
- Java NIO API
- Object-Oriented Programming
- Interfaces
- Package Organization
- Composition
- Exception Handling
- Clean Code Practices
- Git & GitHub

---

## 🔮 Future Improvements

- File Compression
- File Permissions Management
- Recent Files History
- Favorites
- Hidden Files Support
- GUI Version using JavaFX

---

## 👨‍💻 Author

**Rahul**

B.Tech CSE (AI & ML)

Learning Java Backend Development through project-based learning.

---

## ⭐ If you found this project useful, consider giving it a star!
