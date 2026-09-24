package Project1;
//@Author Dax Morin
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class myCSVreader {

	//all of the newly created primitive data structures
    private MyArrayList<GamingRecord> records;

    private MyArrayList<String[]> arrayList;

    private MyLinkedList<String[]> linkedList;

    private MyStack<String[]> stack;

    private MyQueue<String[]> queue;

    private String[] headers;

    /**
     * creates a csv reader and initializes all four data structures
     */
    public myCSVreader() {

        records = new MyArrayList<GamingRecord>();

        arrayList = new MyArrayList<String[]>();

        linkedList = new MyLinkedList<String[]>();

        stack = new MyStack<String[]>();

        queue = new MyQueue<String[]>();
    }

    /**
     * reads the first 100 rows of the gaming csv file
     * and stores each row in all four custom data structures
     *
     * @param filePath the path to the csv file
     * @throws IOException if the file cannot be read
     */
    public void readFile(String filePath) throws IOException {

        BufferedReader reader =
                new BufferedReader(new FileReader(filePath));

        // store the column titles from the header row
        String headerLine = reader.readLine();

        headers = headerLine.split(",");

        String line;

        int rowCount = 0;

        while ((line = reader.readLine()) != null
                && rowCount < 100) {

            String[] values = line.split(",");

            // create a GamingRecord for data analysis
            GamingRecord record = new GamingRecord(values);

            records.add(record);

            // store the row in all four data structures
            arrayList.add(values);

            linkedList.add(values);

            stack.push(values);

            queue.offer(values);

            rowCount++;
        }

        reader.close();
    }

    /**
     * adds the column title to each value in a row
     *
     * @param row the row of values to format
     * @return the row with column titles added
     */
    private String[] formatRow(String[] row) {

        String[] formattedRow = new String[row.length];

        for (int i = 0; i < row.length; i++) {

            formattedRow[i] = headers[i] + ": " + row[i];
        }

        return formattedRow;
    }

    /**
     * returns a row from the arraylist with column titles
     *
     * @param row the row number
     * @return the selected row with column titles
     */
    public String[] getArrayListRow(int row) {

        String[] selectedRow = arrayList.get(row - 1);

        return formatRow(selectedRow);
    }

    /**
     * returns a row from the linkedlist with column titles
     *
     * @param row the row number
     * @return the selected row with column titles
     */
    public String[] getLinkedListRow(int row) {

        String[] selectedRow = linkedList.get(row - 1);

        return formatRow(selectedRow);
    }

    /**
     * returns a row from the stack with column titles
     *
     * @param row the row number
     * @return the selected row with column titles
     */
    public String[] getStackRow(int row) {

        String[] selectedRow = null;

        if (row > stack.size()) {

            System.out.println(
                "The selected row is no longer available because "
                + "the stack has already removed values from the dataset."
            );

            return null;
        }

        for (int i = 0; i < row; i++) {

            selectedRow = stack.pop();
        }

        System.out.println(
            "Due to this data structure's removal of values when "
            + "checking them, the value you selected has been deleted."
        );

        return formatRow(selectedRow);
    }

    /**
     * returns a row from the queue with column titles
     *
     * @param row the row number
     * @return the selected row with column titles
     */
    public String[] getQueueRow(int row) {

        String[] selectedRow = null;

        if (row > queue.size()) {

            System.out.println(
                "The selected row is no longer available because "
                + "the queue has already removed values from the dataset."
            );

            return null;
        }

        for (int i = 0; i < row; i++) {

            selectedRow = queue.poll();
        }

        System.out.println(
            "Due to this data structure's removal of values when "
            + "checking them, the value you selected has been deleted."
        );

        return formatRow(selectedRow);
    }

    /**
     * returns the number of rows currently loaded
     *
     * @return the number of rows
     */
    public int size() {

        return arrayList.size();
    }

    /**
     * returns the gaming records used for data analysis
     *
     * @return the gaming records
     */
    public MyArrayList<GamingRecord> getRecords() {

        return records;
    }
}