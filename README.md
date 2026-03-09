# Playlist Manager

## Original Authors
This project is created and maintained by:

* **Akmal Hakimi Bin Abd Rashid**
* **Khairul Naqib Bin Kushaini**
* **Batrisha Elyani Fakhira Binti Roslee**
* **Syed Muhammad Akil Bin Syed Ali**

---

## Introduction
**Playlist Manager** is a Java Swing desktop application developed as part of a **ISB30503 - Data Structures & Algorithms** course at **Universiti Kuala Lumpur (UniKL MIIT)** during the October 2024 session. The project demonstrates the implementation of a **doubly linked list** through a practical music playlist management system with a graphical user interface.

The goal of this project is to provide a hands-on application of linked list operations — insertion, deletion, and traversal — while delivering a user-friendly GUI experience built with Java Swing.

---

## Problem Statements & Objectives

### Problem Statements
- **Manual List Management**: Managing ordered collections of data manually is inefficient and error-prone without a proper data structure.
- **Understanding Linked Lists**: Students need practical projects to reinforce doubly linked list concepts such as node pointers, head/tail management, and traversal.
- **Lack of Visual Feedback**: Console-based programs can be difficult to interact with; a GUI improves usability and engagement.

### Objectives
- Implement a fully functional **doubly linked list** to manage a playlist of songs
- Apply OOP principles including **encapsulation**, **classes**, **objects**, and **methods**
- Build an interactive **Swing-based GUI** with real-time feedback
- Support core operations: **add**, **remove** (by title, case-insensitive), **display**, and **clear all**
- Validate user input to prevent empty or invalid submissions

---

## Program Scope
The Playlist Manager allows users to:
- **Add Songs** with a title and artist, appended to the end of the playlist
- **Remove Songs** by title using case-insensitive matching
- **Display All Songs** in a numbered, scrollable list
- **Clear All Songs** with a confirmation dialog

The application is written in **Java** and uses **Swing** for the GUI. Internally, the playlist is stored as a **doubly linked list** using custom `Node` and `Song` classes.

---

## Data Structure

The playlist is implemented as a **doubly linked list**, where each node holds a `Song` object and pointers to the previous and next nodes.

```
[head] <-> [Node: Song A] <-> [Node: Song B] <-> [Node: Song C] <-> [tail]
```

### Class Diagram

```
Main (GUI - Swing)
 └── Playlist (Doubly Linked List)
      └── Node
           ├── Song (title, artist)
           ├── next → Node
           └── prev → Node
```

| Class      | Responsibility                                              |
|------------|-------------------------------------------------------------|
| `Song`     | Data model storing `title` and `artist`                     |
| `Node`     | Linked list node wrapping a `Song` with `next`/`prev` links |
| `Playlist` | Doubly linked list operations (add, remove, display, size)  |
| `Main`     | Swing GUI with input fields, buttons, and playlist display  |

---

## Prerequisites

- **Java JDK 8** or higher

Verify your installation:

```bash
java -version
javac -version
```

---

## How to Run

### Compile

```bash
javac *.java
```

### Launch the Application

```bash
java Main
```

A GUI window will open on your screen.

### Run Tests

```bash
javac PlaylistTest.java
java PlaylistTest
```

---

## Sample Input and Output

### Adding Songs

| Field  | Input               |
|--------|---------------------|
| Title  | Bohemian Rhapsody   |
| Artist | Queen               |

Click **Add Song**.

**Status Bar Output:**
```text
Added song: Bohemian Rhapsody  |  Total: 1 song(s)
```

**Playlist Display:**
```text
1. Song [Title: Bohemian Rhapsody, Artist: Queen]
```

---

### After Adding Multiple Songs

| #  | Title               | Artist          |
|----|---------------------|-----------------|
| 1  | Bohemian Rhapsody   | Queen           |
| 2  | Stairway to Heaven  | Led Zeppelin    |
| 3  | Hotel California    | Eagles          |

**Playlist Display:**
```text
1. Song [Title: Bohemian Rhapsody, Artist: Queen]
2. Song [Title: Stairway to Heaven, Artist: Led Zeppelin]
3. Song [Title: Hotel California, Artist: Eagles]
```

**Status Bar Output:**
```text
Added song: Hotel California  |  Total: 3 song(s)
```

---

### Removing a Song

| Field  | Input              |
|--------|--------------------|
| Title  | Stairway to Heaven |

Click **Remove Song**.

**Status Bar Output:**
```text
Removed song: Stairway to Heaven  |  Total: 2 song(s)
```

**Playlist Display:**
```text
1. Song [Title: Bohemian Rhapsody, Artist: Queen]
2. Song [Title: Hotel California, Artist: Eagles]
```

---

### Removing a Non-Existent Song

| Field  | Input        |
|--------|--------------|
| Title  | Imagine      |

Click **Remove Song**.

**Status Bar Output:**
```text
Song not found: Imagine  |  Total: 2 song(s)
```

---

### Empty Playlist

**Playlist Display:**
```text
The playlist is empty.
```

---

## Test Results

```text
[PASS] Add song returns confirmation
[PASS] Display contains first song
[PASS] Display contains second song
[PASS] Display shows order (A before B)
[PASS] Remove existing song returns confirmation
[PASS] Playlist empty after removing only song
[PASS] Remove from empty playlist
[PASS] Remove non-existent song
[PASS] Playlist unchanged after failed remove
[PASS] Remove head - first gone
[PASS] Remove head - rest intact
[PASS] Remove head - size correct
[PASS] Remove tail - last gone
[PASS] Remove tail - rest intact
[PASS] Remove tail - size correct
[PASS] Remove middle - middle gone
[PASS] Remove middle - ends intact
[PASS] Remove middle - size correct
[PASS] Remove only element - empty
[PASS] Remove only element - display shows empty
[PASS] Case-insensitive remove works
[PASS] Case-insensitive remove - playlist empty
[PASS] Empty playlist size is 0
[PASS] Size is 1 after one add
[PASS] Size is 3 after three adds
[PASS] Size is 2 after one remove

===== RESULTS =====
Passed: 26
Failed: 0
ALL TESTS PASSED
```

---

## Project Structure

```
├── Main.java           # Entry point & Swing GUI
├── Playlist.java       # Doubly linked list implementation
├── Node.java           # Linked list node
├── Song.java           # Song data model
├── PlaylistTest.java   # Automated test suite (26 tests)
└── package.bluej       # BlueJ project metadata
```

---

## License

This project is for educational purposes.
