package Project1;
//@Author Dax Morin
import java.io.IOException;
import java.util.Scanner;

public class MySystem {

    /**
     * runs the gaming data analysis system
     *
     * @param args command line arguments containing the csv file path
     */
    public static void main(String[] args) {

        myCSVreader csvReader = new myCSVreader();

        // make sure a file path was provided
        if (args.length == 0) {

            System.out.println("Please provide the csv file path.");

            return;
        }

        String filePath = args[0];

        // load the records from the csv file
        try {

            csvReader.readFile(filePath);

        } catch (IOException e) {

            System.out.println("Could not read the file.");

            e.printStackTrace();

            return;
        }

        // create the data analysis object
        DataAnalysis analysis =
                new DataAnalysis(csvReader.getRecords());

        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        // continue displaying the menu until the user chooses exit
        while (choice != 4) {

            System.out.println();
            System.out.println("/// Gaming Data Analysis System ///");
            System.out.println("1. Analyze gaming hours and addiction level");
            System.out.println("2. Analyze gaming hours and hours of sleep");
            System.out.println("3. Print a row");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            if (choice == 1) {

                double[] results =
                        analysis.analyzeGamingAndAddiction();

                System.out.println();
                System.out.println(
                        "/// Gaming Hours and Addiction Analysis ///");

                System.out.println(
                        "Average Daily Gaming Hours: " + results[0]);

                System.out.println(
                        "Average Addiction Level: " + results[1]);

            } else if (choice == 2) {

                double[] results =
                        analysis.analyzeGamingAndSleepHours();

                System.out.println();
                System.out.println(
                        "/// Daily Gaming Hours Analytics ///");

                System.out.println(
                        "Average Daily Gaming Hours: " + results[0]);

                System.out.println(
                        "Average sleep time: " + results[1] + " Hours");

            } else if (choice == 3) {

                System.out.println();
                System.out.println("/// Choose a Data Structure ///");
                System.out.println("1. ArrayList");
                System.out.println("2. LinkedList");
                System.out.println("3. Stack");
                System.out.println("4. Queue");
                System.out.print("Enter your choice: ");

                int structureChoice = scanner.nextInt();

                System.out.print(
                        "Enter the row you would like to see (1-"
                        + csvReader.size() + "): ");

                int row = scanner.nextInt();

                String[] selectedRow = null;

                if (structureChoice == 1) {

                    selectedRow =
                            csvReader.getArrayListRow(row);

                } else if (structureChoice == 2) {

                    selectedRow =
                            csvReader.getLinkedListRow(row);

                } else if (structureChoice == 3) {

                    selectedRow =
                            csvReader.getStackRow(row);

                } else if (structureChoice == 4) {

                    selectedRow =
                            csvReader.getQueueRow(row);

                } else {

                    System.out.println(
                            "Invalid data structure choice.");
                }

                // print the selected row
                if (selectedRow != null) {

                    System.out.println();
                    System.out.println("Row " + row + ":");

                    for (int i = 0;
                         i < selectedRow.length;
                         i++) {

                        System.out.println(selectedRow[i]);
                    }
                }

            } else if (choice == 4) {

                System.out.println("Exiting program.");

            } else {

                System.out.println("Invalid menu choice.");
            }
        }

        scanner.close();
    }
}