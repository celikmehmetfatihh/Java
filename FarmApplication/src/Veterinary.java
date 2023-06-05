import java.time.LocalDate;

/**
 * Veterinary class
 * @author Mehmet Fatih Çelik
 * @version JDK 1.7
 */
public class Veterinary {

    private int vetID;
    private String gender;
    private LocalDate dateOfBirth;
    private double salary;

    private Treatment treatment;

    /**
     * constructor without a parameter
     */
    Veterinary(){

    }

    /**
     * constructor with 4 parameters
     * @param vetID: int
     * @param gender: String
     * @param dateOfBirth: LocalDate
     * @param salary: double
     */
    Veterinary(int vetID, String gender, LocalDate dateOfBirth, double salary ) {
        this.vetID = vetID;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    /**
     * getter for vetId
     * @return int vetId
     */
    public int getVetID() {
        return vetID;
    }

    /**
     * getter for gender
     * @return String gender
     */

    public String getGender() {
        return gender;
    }

    /**
     * getter for dateOfBirth
     * @return LocalDate dateOfBirth
     */

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * getter for salary
     * @return double salary
     */

    public double getSalary() {
        return salary;
    }

    /**
     * getter for treatment
      * @return Treatment Object treatment
     */

    public Treatment getTreatment() {
        return treatment;
    }

    /**
     * setter for vetId
     * @param vetID: int
     */

    public void setVetID(int vetID) {
        this.vetID = vetID;
    }

    /**
     * setter for gender
     * @param gender: String
     */

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * setter for dateOfBirth
     * @param dateOfBirth: LocalDate
     */

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * setter for salary
     * @param salary: double
     */

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * setter for Treatment Object
     * @param treatment: Treatment
     */

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
}
