COS 285 Project 1 — Gaming Dataset Analysis
Overview

This project is a Java-based (made in Eclipse IDE) gaming dataset analysis system developed for COS 285. The program reads data from a gaming and mental health CSV file, stores the data using custom-built data structures, and performs basic analysis on relationships between gaming behavior and other recorded measurements.

The project demonstrates the implementation and use of four custom data structures:

Custom ArrayList
Custom LinkedList
Custom Stack
Custom Queue

The system currently processes the first 100 data rows from the provided CSV file due to hardware restrictions. Each row is converted into a GamingRecord object for analysis while also being stored in all four custom data structures.

How to Compile and Run
Requirements
Java Development Kit (JDK)
Eclipse IDE or another Java IDE
The Gaming and Mental Health CSV dataset
All .java files located in the Project1 package

The project uses standard Java classes and does not require external libraries.

Project Structure
COS285ProjectP1/
Project1/
    MySystem.java
    myCSVreader.java
    GamingRecord.java
    DataAnalysis.java
    MyArrayList.java
    MyLinkedList.java
    MyStack.java
    MyQueue.java
    
Compiling
Open the project in Eclipse.
Make sure all Java files are located inside the Project1 package.
Make sure the project has a valid JDK configured.
Make sure the Gaming and Mental Health CSV file is available on the computer.
Running
Open MySystem.java in Eclipse.
Select Run.
Select Run Configurations.
Select the Arguments tab.
Under Program arguments, copy and paste the path to your Gaming and Mental Health CSV file.
Select Run.

The program uses the CSV file path provided through the program arguments to load the dataset.

What the System Does

The system reads a gaming and mental health dataset from a CSV file and converts each data row into a GamingRecord. The GamingRecord class stores information including:

Age
Gender
Income
Daily gaming hours
Addiction level
Sleep hours

These values are parsed from each CSV row when the GamingRecord is created.

The CSV reader stores the records in a custom MyArrayList<GamingRecord> for use by the analysis system. At the same time, the original CSV rows are stored separately in a custom ArrayList, LinkedList, Stack, and Queue.

The CSV reader currently reads a maximum of 100 data rows, excluding the header row.

Data Structures
MyArrayList

MyArrayList is a custom generic array-based list implementation. It stores elements in an internal array and starts with a default capacity of 10.

When the array becomes full, its capacity is doubled and the existing elements are copied into the larger array.

The class provides:

add()
remove()
get()
clear()
size()
contains()
isEmpty()
iterator()

The class also implements Iterable<T>, allowing the data structure to be traversed using an iterator.

MyLinkedList

MyLinkedList is a custom singly linked list implementation. Each node stores an element and a reference to the next node.

The class provides:

add()
remove()
get()
set()
clear()
size()
contains()
isEmpty()
iterator()

Index validation is handled through a private checkIndex() method.

MyStack

MyStack is a custom generic stack implemented using linked nodes.

The stack follows the LIFO (Last In, First Out) structure. New elements are placed at the top of the stack, and pop() removes the current top element.

The class provides:

push()
pop()
peek()
size()
isEmpty()
MyQueue

MyQueue is a custom generic queue implemented using linked nodes.

The queue follows the FIFO (First In, First Out) structure. New elements are added to the rear and removed from the front.

The class provides:

offer()
poll()
peek()
size()
isEmpty()

The queue maintains references to both the front and rear nodes.

CSV Processing

The myCSVreader class handles loading the dataset.

When readFile() is called, the class:

Opens the CSV file using a BufferedReader.
Reads the first line as the column headers.
Reads up to 100 data rows.
Converts each row into a GamingRecord.
Stores the GamingRecord in the custom ArrayList.
Stores the original row in the custom ArrayList.
Stores the original row in the custom LinkedList.
Pushes the original row onto the custom Stack.
Adds the original row to the custom Queue.

The CSV reader also stores the column headers so that individual rows can be displayed with their corresponding column names.

When a row is printed, each value is displayed with its corresponding column title.

For example:

Age: 22
Gender: Male
Income: 50000
...
Data Analysis

The DataAnalysis class performs the two analysis tasks currently provided by the system.

Analysis 1 — Gaming Hours and Addiction Level

The first analysis calculates:

Average daily gaming hours
Average addiction level

The analysis demonstrates the use of all four custom data structures by moving the records through the data structures before calculating the averages.

The records are moved from the ArrayList into the LinkedList, from the LinkedList into the Stack, and from the Stack into the Queue. The totals are then calculated while removing the records from the Queue.

Analysis 2 — Gaming Hours and Sleep Hours

The second analysis calculates:

Average daily gaming hours
Average sleep hours

This analysis uses the same data-structure processing process as the first analysis.

The records are moved through the LinkedList, Stack, and Queue before the averages are calculated.

Features

The current system provides the following features:

Dataset Loading
The program accepts a CSV file path through the Eclipse program arguments and loads up to 100 data rows from the file.
Custom Data Structures
The dataset is stored and manipulated using four custom-built data structures: ArrayList, LinkedList, Stack, and Queue.
Gaming Data Representation
Each CSV row used for analysis is represented as a GamingRecord containing age, gender, income, daily gaming hours, addiction level, and sleep hours.
Gaming and Addiction Analysis
The system calculates the average daily gaming hours and average addiction level across the loaded records.
Gaming and Sleep Analysis
The system calculates the average daily gaming hours and average sleep hours across the loaded records.
Row Inspection
Users can select a data structure and a row number to inspect an individual dataset row.
Column Titles
Printed rows include the column title before each corresponding value.
Interactive Menu
The program provides an interactive command-line menu for selecting an analysis, inspecting a row, or exiting the program.
Interactive Menu

After the dataset is loaded, the program displays the following menu:

/// Gaming Data Analysis System ///
1. Analyze gaming hours and addiction level
2. Analyze gaming hours and screen time
3. Print a row
4. Exit

Selecting option 1 runs the gaming hours and addiction analysis.

Selecting option 2 runs the gaming hours and sleep analysis.

Selecting option 3 allows the user to select one of the four custom data structures and inspect a row.

Selecting option 4 exits the program.

Row Inspection

The row inspection feature allows the user to choose which custom data structure should be used to retrieve a row.

The available options are:

ArrayList
LinkedList
Stack
Queue

The ArrayList and LinkedList retain their values when a row is retrieved.

The Stack and Queue use removal operations when retrieving rows. Because of this, checking a row through either of these structures removes values from that structure. The program informs the user when the selected value has been removed.

Authors & Title

COS 285 Project Phase 1 - Gaming Data Analysis

Author: Dax Morin
