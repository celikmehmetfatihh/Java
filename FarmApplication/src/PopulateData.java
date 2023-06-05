import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Just populating hardcoded data as mentioned in the assignment.
 * @author Mehmet Fatih Çelik
 * @version JDK 1.7
 */


public class PopulateData {

    ArrayList<Cow> cows = new ArrayList<>();
    ArrayList<Veterinary> veterinaries = new ArrayList<>();

    /**
     * This method is basically for hardcoding 3 different objects for Cow and Veterinary class, so that we can do our
     * process quickly
     */
    PopulateData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate myDate = LocalDate.parse("20/03/2000", formatter);
        Cow c = new Cow(1, "male", myDate,true);
        LocalDate myDate1 = LocalDate.parse("15/11/1999", formatter);
        Cow c1 = new Cow(2, "female", myDate1,false);
        LocalDate myDate2 = LocalDate.parse("12/07/2001", formatter);
        Cow c2 = new Cow(3, "male", myDate2,false);
        this.cows.add(c);
        this.cows.add(c1);
        this.cows.add(c2);

        LocalDate myDate6 = LocalDate.parse("18/03/1997", formatter);
        Treatment t1 = new Treatment(myDate6, "treatment code 1");
        LocalDate myDate7 = LocalDate.parse("11/06/1999", formatter);
        Treatment t2 = new Treatment(myDate7, "treatment code 2");
        LocalDate myDate8 = LocalDate.parse("06/01/1998", formatter);
        Treatment t3 = new Treatment(myDate8, "treatment code 3");
        c.getTreatment().add(t1);
        c1.getTreatment().add(t2);
        c2.getTreatment().add(t3);

        LocalDate myDate9 = LocalDate.parse("01/08/2001", formatter);
        Medication m1 = new Medication("medication 1", 2, myDate9, 3, "notes 1");
        LocalDate myDate10 = LocalDate.parse("04/03/2002", formatter);
        Medication m2 = new Medication("medication 2", 3, myDate10, 2, "notes 2");
        LocalDate myDate11 = LocalDate.parse("13/04/2002", formatter);
        Medication m3 = new Medication("medication 3", 4, myDate11, 1, "notes 3");
        t1.getMedications().add(m1);
        t2.getMedications().add(m2);
        t3.getMedications().add(m3);


        LocalDate myDate3 = LocalDate.parse("15/03/1995", formatter);
        Veterinary v = new Veterinary(1, "male", myDate3, 10000);
        LocalDate myDate4 = LocalDate.parse("12/02/1990", formatter);
        Veterinary v1 = new Veterinary(2, "female", myDate4, 12000);
        LocalDate myDate5 = LocalDate.parse("17/01/1993", formatter);
        Veterinary v2 = new Veterinary(3, "male", myDate5, 15000);
        this.veterinaries.add(v);
        this.veterinaries.add(v1);
        this.veterinaries.add(v2);
    }

    /**
     * getter for Cow ArrayList
     * @return cows
     */
    public ArrayList<Cow> getCows() {
        return cows;
    }

    /**
     * getter for Veterinary ArrayList
     * @return veterinaries
     */

    public ArrayList<Veterinary> getVeterinaries() {
        return veterinaries;
    }

    /**
     * setter for Cow ArrayList
     * @param   cows : Cow
     */

    public void setCows(ArrayList<Cow> cows) {
        this.cows = cows;
    }

    /**
     * setter for Veterinary ArrayList
     * @param veterinaries: Vet
     */

    public void setVeterinaries(ArrayList<Veterinary> veterinaries) {
        this.veterinaries = veterinaries;
    }
}
