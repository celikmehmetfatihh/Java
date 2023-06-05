import java.time.LocalDate;

/**
 * Medication class
 * @author Mehmet Fatih Çelik
 * @version JDK 1.7
 */
public class Medication {
    private String details;
    private int duration;
    private LocalDate startDate;
    private double dosage;
    private String notes;

    /**
     * Medication constructor without parameters
     */
    Medication() {

    }

    /**
     * Medication constructor with 5 parameters
     *
     * @param details:String
     * @param duration:int
     * @param startDate:LocalDate
     * @param dosage:double
     * @param notes:String
     */
    Medication(String details, int duration, LocalDate startDate, double dosage, String notes) {
        this.details = details;
        this.duration = duration;
        this.startDate = startDate;
        this.dosage = dosage;
        this.notes = notes;
    }

    /**
     * getter for details
     * @return String Details
     */
    public String getDetails() {
        return details;
    }

    /**
     * getter for duration
     * @return int Duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * getter for startDate
     * @return LocalDate StartDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * getter for dosage
     * @return double Dosage
     */

    public double getDosage() {
        return dosage;
    }

    /**
     * getter for notes
     * @return String Notes
     */

    public String getNotes() {
        return notes;
    }

    /**
     * setter for details
     * @param details: String
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * setter for duration
     * @param duration: int
     */

    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * setter for startDate
     * @param startDate: LocalDate
     */

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * setter for dosage
     * @param dosage: double
     */

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    /**
     * setter for notes
     * @param notes: String
     */

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
