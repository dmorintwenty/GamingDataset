package Project1;
//@Author Dax Morin
public class DataAnalysis {

    private MyArrayList<GamingRecord> records;

    private MyLinkedList<GamingRecord> analysisRecords;

    private MyStack<GamingRecord> recordStack;

    private MyQueue<GamingRecord> recordQueue;

    /**
     * creates a DataAnalysis object using the provided records
     *
     * @param records the gaming records to analyze
     */
    public DataAnalysis(MyArrayList<GamingRecord> records) {

        this.records = records;

        analysisRecords = new MyLinkedList<GamingRecord>();

        recordStack = new MyStack<GamingRecord>();

        recordQueue = new MyQueue<GamingRecord>();
    }

    /**
     * analyzes the relationship between daily gaming hours
     * and addiction level
     *
     * @return an array containing the average gaming hours
     * and average addiction level
     */
    public double[] analyzeGamingAndAddiction() {

        double totalGamingHours = 0;
        double totalAddictionLevel = 0;

        // move the records into the linked list
        for (int i = 0; i < records.size(); i++) {

            GamingRecord record = records.get(i);

            analysisRecords.add(record);
        }

        // move the records from the linked list into the stack
        while (!analysisRecords.isEmpty()) {

            GamingRecord record = analysisRecords.get(0);

            recordStack.push(record);

            analysisRecords.remove(0);
        }

        // move the records from the stack into the queue
        while (!recordStack.isEmpty()) {

            GamingRecord record = recordStack.pop();

            recordQueue.offer(record);
        }

        // calculate the totals using the queue
        while (!recordQueue.isEmpty()) {

            GamingRecord record = recordQueue.poll();

            totalGamingHours += record.getDailyGamingHours();

            totalAddictionLevel += record.getAddictionLevel();
        }

        double averageGamingHours =
                totalGamingHours / records.size();

        double averageAddictionLevel =
                totalAddictionLevel / records.size();

        return new double[] {
            averageGamingHours,
            averageAddictionLevel
        };
    }

    /**
     * analyzes the relationship between daily gaming hours
     * and total screen time
     *
     * @return an array containing the average gaming hours
     * and average screen time
     */
    public double[] analyzeGamingAndSleepHours() {

        double totalGamingHours = 0;
        double totalScreenTime = 0;

        // move the records into the linked list
        for (int i = 0; i < records.size(); i++) {

            GamingRecord record = records.get(i);

            analysisRecords.add(record);
        }

        // move the records from the linked list into the stack
        while (!analysisRecords.isEmpty()) {

            GamingRecord record = analysisRecords.get(0);

            recordStack.push(record);

            analysisRecords.remove(0);
        }

        // move the records from the stack into the queue
        while (!recordStack.isEmpty()) {

            GamingRecord record = recordStack.pop();

            recordQueue.offer(record);
        }

        // calculate the totals using the queue
        while (!recordQueue.isEmpty()) {

            GamingRecord record = recordQueue.poll();

            totalGamingHours += record.getDailyGamingHours();

            totalScreenTime += record.getSleepHours();
        }

        double averageGamingHours =
                totalGamingHours / records.size();

        double averageScreenTime =
                totalScreenTime / records.size();

        return new double[] {
            averageGamingHours,
            averageScreenTime
        };
    }
}