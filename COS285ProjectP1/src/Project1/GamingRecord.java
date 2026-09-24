package Project1;
//@Author Dax Morin
public class GamingRecord {

    /*
     * represents one row
     * stores fields
     * provides access to those fields
     */

    private int age;
    private String gender;
    private double income;
    private double dailyGamingHours;
    private double addictionLevel;
    private double sleepHours;

    /**
     * creates a gaming record from one csv row with parse function
     *
     * @param values the values from one csv row
     */
    public GamingRecord(String[] values) {

        age = Integer.parseInt(values[0]);

        gender = values[1];

        income = Double.parseDouble(values[2]);

        dailyGamingHours = Double.parseDouble(values[3]);

        addictionLevel = Double.parseDouble(values[4]);
        
        sleepHours = (Double.parseDouble(values[6]));
    }

    /**
     * returns the age of the person
     *
     * @return the person's age
     */
    public int getAge() {
        return age;
    }

    /**
     * returns the gender of the person
     *
     * @return the person's gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * returns the income of the person
     *
     * @return the person's income
     */
    public double getIncome() {
        return income;
    }

    /**
     * returns the person's daily gaming hours
     *
     * @return the daily gaming hours
     */
    public double getDailyGamingHours() {
        return dailyGamingHours;
    }

    /**
     * returns the person's addiction level
     *
     * @return the addiction level
     */
    public double getAddictionLevel() {
        return addictionLevel;
    }

	/**
	 * returns person's sleep in hours
	 * 
	 * @return sleep in hours
	 */
	public double getSleepHours() {
		return sleepHours;
	}

}