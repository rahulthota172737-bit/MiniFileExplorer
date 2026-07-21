# 📂 Mini File Explorer

A console-based file management application built in **Java** that simulates the basic functionality of a file explorer. This project demonstrates **Object-Oriented Programming (OOP)** concepts, Java File Handling, Java NIO, recursion, sorting, and directory management.

---

## 🚀 Features

### 📁 File & Folder Operations
- Create new files
- Create new folders
- Delete files and folders
- Rename files and folders

### 📂 Directory Navigation
- Change current working directory
- Display current working directory

### 🔍 Search
- Recursive file search

### 📋 File Information
- Display file/folder details
- File name
- File type
- File extension
- File size
- Absolute path
- Last modified date

### 📄 Directory Listing
- Show all files
- Show all folders

### 📦 File Management
- Copy files
- Move files

### 📊 Sorting
- Sort files by
  - Name
  - Size
  - Last Modified Date

---

# 🛠 Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java File Handling (`java.io.File`)
- Java NIO (`Files`, `Path`)
- Java Time API
- Collections & Arrays
- Comparator
- IntelliJ IDEA
- Git & GitHub

---

# 🧱 OOP Concepts Demonstrated

✅ Encapsulation

- Private data members
- Controlled access to project data

✅ Abstraction

- Implemented using `FileInterface`

✅ Polymorphism

- Interface reference used with implementation

```java
FileInterface fileManager = new FileManager();
```

✅ Inheritance

- Extendable architecture for advanced file operations

---

# 📁 Project Structure

```
MiniFileExplorer/
│
├── src/
│   └── com/fileexplorer/
│       ├── Main.java
│       ├── FileInterface.java
│       ├── FileManager.java
│       └── AdvancedFileManager.java (optional)
│
├── README.md
└── .gitignore
```

---

# ▶️ How to Run

1. Clone the repository

```
git clone <repository-url>
```

2. Open the project in IntelliJ IDEA or Eclipse.

3. Compile and run `Main.java`.

4. Use the menu to perform file operations.

---

# 📚 Concepts Practiced

- Classes & Objects
- Interfaces
- Method Overriding
- Polymorphism
- Abstraction
- Encapsulation
- Inheritance
- Exception Handling
- File Handling
- Java NIO
- Recursion
- Arrays
- Comparator
- Directory Traversal

---

# 🎯 Learning Objectives

This project was built to strengthen:

- Java Programming
- Object-Oriented Design
- File System Operations
- Clean Code Practices
- Git & GitHub Workflow
- Console Application Development

---

# 📌 Future Improvements

- File compression (ZIP)
- Recursive folder copy
- Recursive folder delete
- File encryption/decryption
- Hidden file support
- File permissions
- Logging
- Unit testing using JUnit
- GUI using JavaFX or Swing

---

# 👨‍💻 Author

Developed as part of a Java Backend Development roadmap to master Core Java, OOP, File Handling, and Software Engineering fundamentals. License

This project is developed for learning purposes.
