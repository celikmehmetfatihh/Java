import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Treatment class
 * @author Mehmet Fatih Çelik
 * @version JDK 1.7
 */
public class Treatment {

    private LocalDate dateOfTreatment;
    private String details;

    private ArrayList<Medication> medications = new ArrayList<>();

    /**
     * Constructor without a parameter
     */

    Treatment() {

    }

    /**
     * Constructor with 3 parameters
     * @param dateOfTreatment: LocalDate
     * @param details: String
     */
    Treatment(LocalDate dateOfTreatment, String details) {
        this.dateOfTreatment = dateOfTreatment;
        this.details = details;
    }

    /**
     * getter for dateOfTreatment
     * @return LocalDate
     */

    public LocalDate getDateOfTreatment() {
        return dateOfTreatment;
    }

    /**
     * getter for details
     * @return String details
     */

    public String getDetails() {
        return details;
    }

    /**
     * getter for ArrayList medications
     * @return medications
     */

    public ArrayList<Medication> getMedications() {
        return medications;
    }

    /**
     * setter for dateOfTreatment
     * @param dateOfTreatment: LocalDate
     */

    public void setDateOfTreatment(LocalDate dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }

    /**
     * setter for details
     * @param details: String
     */

    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * setter for ArrayList medications
     * @param medications: Medication
     */

    public void setMedications(ArrayList<Medication> medications) {
        this.medications = medications;
    }
}
