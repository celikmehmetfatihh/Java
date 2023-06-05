import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Cow class
 * @author Mehmet Fatih Çelik
 * @version JDK 1.7
 */
public class Cow {
    private int tagNo;
    private String gender;
    private LocalDate dateOfBirth;
    private boolean purchased;
    private ArrayList<Treatment> treatment = new ArrayList<>();

    /**
     * constructor without parameter
     */
    Cow() {
    }

    /**
     * constructor with parameters
     * @param tagNo:int
     * @param gender:String
     * @param dateOfBirth:LocalDate
     * @param purchased:boolean
     */
    Cow(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased) {
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.purchased = purchased;
    }

    /**
     * getter for TagNo
     * @return int tagNo
     */
    public int getTagNo() { //GETTERS;
        return this.tagNo;
    }

    /**
     * getter for DateOfBirth
     * @return LocalDate dateOfBirth
     */
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * getter for Gender
     * @return String gender
     */

    public String getGender() {
        return this.gender;
    }

    /**
     * getter for Purchased
     * @return boolean purchased
     */

    public boolean getPurchased() {
        return this.purchased;
    }

    /**
     * getter for Age
     * @return int age
     */

    public int getAge() {
        return (LocalDate.now().getYear()  - this.dateOfBirth.getYear());
    }

    /**
     * getter for Treatment
     * @return treatment
     */

    public ArrayList<Treatment> getTreatment() {
        return treatment;
    }

    /**
     * setter for TagNo
     * @param tagNo:int
     */

    public void setTagNo(int tagNo) {
        this.tagNo = tagNo;
    }

    /**
     * setter for Gender
     * @param gender:String
     */

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * setter for dateOfBirth
     * @param dateOfBirth:LocalDate
     */

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * setter for TagNo
     * @param purchased:int
     */

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    /**
     * setter for TagNo
     * @param treatment:int
     */

    public void setTreatment(ArrayList<Treatment> treatment) {
        this.treatment = treatment;
    }
}
