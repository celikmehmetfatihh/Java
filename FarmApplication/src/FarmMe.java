
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * This class has main method, cow ArrayList, veterinaries ArrayList
 * @author Mehmet Fatih Çelik
 * @version JDK 1.7
 */
public class FarmMe {
    /**
     * cows is the ArrayList of Cow class, we can access in the main
     */
    public static ArrayList<Cow> cows;
    /**
     * veterinaries is the ArrayList of Veterinary class, we can access in the main
     */
    public static ArrayList<Veterinary> veterinaries;

    /**
     * Main method
     * @param args : String[]
     */
    public static void main(String[] args) {

        PopulateData p = new PopulateData();
        cows = p.getCows();
        veterinaries = p.getVeterinaries();

        Scanner input = new Scanner(System.in);
        System.out.println("\n---Welcome to FarmApp!---\n");

        int choice;
        int idCow = 4;
        int idVet = 4;
        do {
            menu();
            System.out.print("Enter a choice: ");
            choice = input.nextInt();

            if (choice == 1)
                idCow = addcow(idCow);

            else if (choice == 2) {
                System.out.print("Enter the cow id you want to delete: ");
                int tagNo = input.nextInt();

                deleteCow(tagNo);
            }

            else if (choice == 3) {
                System.out.print("Enter the cow id you want to get details: ");
                int tagNo = input.nextInt();
                getCowDetails(tagNo);
            }

            else if (choice == 4)
                idVet = addVet(idVet);

            else if (choice == 5) {
                System.out.print("Enter the vet id you want to delete: ");
                int vetId = input.nextInt();
                deleteVet(vetId);
            }

            else if (choice == 6) {
                System.out.print("Enter the vet id you want to get details: ");
                int vetId = input.nextInt();
                getVetDetails(vetId);
            }

            else if (choice == 7) {
                System.out.print("Enter the vet id you want to get treated by: ");
                int vetId = input.nextInt();
                System.out.print("Enter the cow id you want to treat: ");
                int tagNo = input.nextInt();

                addTreatment(vetId, tagNo);
            }

            else if (choice == 8) {
                input.nextLine();
                System.out.print("Enter the cow id you want to get treatment details: ");
                int tagNo = input.nextInt();
                getCowTreatment(tagNo);
            }

            else if (choice == 9) {
                System.out.print("Enter the cow id you want to get treatment details: ");
                int tagNo = input.nextInt();

                input.nextLine();
                System.out.print("Enter treatment date (dd/mm/yyyy): ");
                String myDate = input.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(myDate, formatter);
                getCowTreatment(tagNo, date);
            }

            else if (choice == 10)
                listCow();

            else if (choice == 11)
                listVet();
            else if (choice != 12)
                System.out.println("Enter valid number!\n");

        }while (choice != 12);
        System.out.println("BYE!");
    }

    /**
     * Just menu method that prints the menu list.
     */
    public static void menu() {
        System.out.println("""

                1-addCow
                2-deleteCow
                3-getCowDetails
                4-addVet
                5-deleteVet
                6-getVetDetails
                7-addTreatment
                8-getCowTreatment
                9-getCowTreatmentByDate
                10-listCow
                11-listVet
                12-exit
                """);
    }

    /**
     * Returns the id of the next cow. Basically, we hardcoded 3 ids for cow and vets. I am sending
     * 4 as an id. Then, I add my cow. Make my TagNo:4, then increment id and return it as 5. It will
     * continue like that. Any consecutive cow's tagId will be consecutive. TagNo should be our unique
     * identifier. User could make mistakes about it, and program could crash. I did this implementation
     * to avoid this problem.
     *

     * @param  id:int is the id that is going to be the that cow's tagNo
     * @return     the incremented id as int, which will be the next cow's tagNo.
     */


    public static int addcow(int id) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the gender: ");
        String gender = input.nextLine();
        System.out.print("Enter dateOfBirth (dd/mm/yyyy): ");
        String myDate = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(myDate, formatter);

        System.out.print("Enter true if the cow is purchased or enter false if the cow is farm-raising: ");
        boolean purchased = input.nextBoolean();

        Cow c = new Cow(id, gender, date, purchased);

        c.setTagNo(id);
        System.out.println("\nCow Tag No " + id + " has been added!");
        id++;

        cows.add(c);
        return id;
    }

    /**
     * This method basically will delete the cow object from the ArrayList. First it looks for whether the tagNo exists
     * or not.If it exists deletes the cow object with given tagNo; if does it not exist, it will print an error message.
     *
     * @param  tagNo:int  is the variable that is going to be searched for in the cowList.
     */
    public static void deleteCow (int tagNo) {
        int foundFlag = 0;
        for(Cow c: cows) {
            if (tagNo == c.getTagNo()) {
                foundFlag = 1;
                break;
            }
        }


        if (foundFlag == 0)
            System.out.println("\nCow Tag No " + tagNo + " does not exist!");
        else {
            cows.remove(cows.get(tagNo - 1));
            System.out.println("\nCow TagNo: " + tagNo + " is deleted successfully!");
        }
    }

    /**
     * This method basically gets the cow object according to given tagNo from user. First, it is going to search for the
     * given tagNo, if tagNo does not exist, it displays an error message; if tagNo exists, that cow object will be printed
     * with its attributes.
     *
     * @param  tagNo:int  is the variable that is going to be searched for in the cowList.
     */
    public static void getCowDetails(int tagNo) {
        int foundFlag = 0;
        Cow temp = new Cow();
        for(Cow c: cows) {
            if (tagNo == c.getTagNo()) {
                foundFlag = 1;
                temp = c;
                break;
            }
        }

        String tempPurchased;
        if (cows.get(tagNo).getPurchased())
            tempPurchased = "Purchased";
        else
            tempPurchased = "Farm-raising";

        if (foundFlag == 0)
            System.out.println("\nCow Tag No " + tagNo + " does not exist!");
        else {
            System.out.println("\nCow Tag No: " + temp.getTagNo() + "\nGender: " + temp.getGender() + "\nDateOfBirth: " + temp.getDateOfBirth()
                    +"\nAge: " + temp.getAge() + "\nFrom Where: " + tempPurchased);
        }
    }

    /**
     * This method basically gets the id of the Vet, and it will create a Veterinary Object, then that Veterinary Object will
     * be added to veterinaries ArrayList. VetId will be from the parameter hardcoded. As I told in the addCow method too,
     * this operation is for avoiding errors from the user's inputs.
     *
     * @param  id:int  is the parameter that is going to be the new veterinary object's vetId
     * @return int id that is going to be used for the next Vet
     */

    public static int addVet(int id) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the gender: ");
        String gender = input.nextLine();

        System.out.print("Enter dateOfBirth: (dd/mm/yyyy): ");
        String myDate = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(myDate, formatter);

        System.out.print("Enter the salary: ");
        double salary = input.nextDouble();

        Veterinary v = new Veterinary(id, gender, date, salary);

        System.out.println("\nVetId " + id + " has been added!");
        id++;

        veterinaries.add(v);
        return id;
    }

    /**
     * This method basically will delete the vet object from the ArrayList. First it looks for whether the vetId exists
     * or not. If it exists deletes the vet object with given vetId; if does it not exist, it will print an error message.
     *
     * @param  vetId:int  is the variable that is going to be searched for in the veterinary list.
     */
    public static void deleteVet(int vetId) {
        int foundFlag = 0;
        for(Veterinary v: veterinaries) {
            if (vetId == v.getVetID()) {
                foundFlag = 1;
                break;
            }
        }


        if (foundFlag == 0)
            System.out.println("\nVetId " + vetId + " does not exist!");
        else {
            veterinaries.remove(veterinaries.get(vetId - 1));
            System.out.println("\nVetId: " + vetId + " is deleted successfully!");
        }
    }

    /**
     * This method basically gets the vet object according to given vetId from the user. First, it is going to search for the
     * given vetId, if vetId does not exist, it displays an error message; if vetId exists, that vet object will be printed
     * with its attributes.
     *
     * @param  vetId:int  is the variable that is going to be searched for in the veterinary List.
     */

    public static void getVetDetails(int vetId) {
        int foundFlag = 0;
        Veterinary temp = new Veterinary();
        for(Veterinary v: veterinaries) {
            if (vetId == v.getVetID()) {
                foundFlag = 1;
                temp = v;
                break;
            }
        }

        if (foundFlag == 0)
            System.out.println("\nVetId " + vetId + " does not exist!");
        else {
            System.out.println("\nVet Id: " + temp.getVetID() + "\nGender: " + temp.getGender() + "\nDateOfBirth: " + temp.getDateOfBirth()
                    + "\nSalary: " + temp.getSalary());
        }
    }

    /**
     * This method basically adds a Treatment, according to that Treatment adds Medication, and updates the ArrayList called
     * treatment in the Cow Class, and also updates the treatment object in the Veterinary Class.

     * @param  vetId:int  is the variable that is going to be searched for in the veterinary List.
     * @param tagNo:int is the variable that is going to be searched for in the Cow List.
     */

    public static void addTreatment(int vetId, int tagNo) {
        Scanner input = new Scanner(System.in);
        int vetIdFlag = 0;
        Veterinary tempVet = new Veterinary();
        for(Veterinary v: veterinaries) {
            if (vetId == v.getVetID()) {
                vetIdFlag = 1;
                tempVet = v;
                break;
            }
        }

        int tagNoFlag = 0;
        Cow tempCow = new Cow();
        for(Cow c: cows) {
            if (tagNo == c.getTagNo()) {
                tagNoFlag = 1;
                tempCow = c;
                break;
            }
        }

        if (tagNoFlag == 0)
            System.out.println("\nCow Tag No " + tagNo + " does not exist!");
        else if (vetIdFlag == 0)
            System.out.println("\nVetId " + vetId + " does not exist!");
        else {
            System.out.print("Enter treatment date : (dd/mm/yyyy): ");
            String myDate = input.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(myDate, formatter);

            System.out.print("Enter treatment details: ");
            String details = input.nextLine();

            Treatment t = new Treatment(date, details);

            tempCow.getTreatment().add(t);
            tempVet.setTreatment(t);

            System.out.print("Enter medication details: ");
            String medDetails = input.nextLine();
            System.out.print("Enter medication duration: ");
            int medDuration = input.nextInt();
            input.nextLine();

            System.out.print("Enter medication date : (dd/mm/yyyy): ");
            String medDate = input.nextLine();
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date2 = LocalDate.parse(medDate, formatter2);

            System.out.print("Enter medication dosage: ");
            double dosage = input.nextDouble();
            input.nextLine();
            System.out.print("Enter medication notes: ");
            String notes = input.nextLine();

            Medication m = new Medication(medDetails, medDuration, date2, dosage, notes);
            t.getMedications().add(m);

            System.out.println("\nTreatment has been added for cow tagNo: " + tagNo + "!");
            System.out.println("Treatment has been added for vetId: " + vetId + "!");
        }
    }

    /**This method basically gets the CowTreatment according to tagNo parameter. First, it searches for if the given tagNo
     * Cow exists or not, if it does not exist displays error message. If it does exist it displays that cow's treatments.
     *

     * @param  tagNo:int  is the variable that is going to be searched for in the Cow List.
     */

    public static void getCowTreatment(int tagNo) {
        int tagNoFlag = 0;
        Cow tempCow = new Cow();
        for(Cow c: cows) {
            if (tagNo == c.getTagNo()) {
                tagNoFlag = 1;
                tempCow = c;
                break;
            }
        }


        if (tagNoFlag == 0)
            System.out.println("\nCow Tag No " + tagNo + " does not exist!");
        else if (tempCow.getTreatment().size() == 0)
            System.out.println("\nCow Tag No " + tagNo + " does not have any treatment!");
        else {
            for(int i=0; i<tempCow.getTreatment().size(); i++) {
                System.out.println("\nCow Tag No: " + tagNo + " Treatment-"+ (i+1) +" date: " + tempCow.getTreatment().get(i).getDateOfTreatment() +
                        "\nCow Treatment-" + (i+1) + " details: " + tempCow.getTreatment().get(i).getDetails() + "\n");
            }
        }
    }

    /**
     *This method basically is an overloading method. This particular method's difference is it takes LocalDate Object as
     * a parameter and searches for an exact date for the given cow's treatment.
     *
     * @param tagNo:int is the variable that is going to be searched for in the Cow List.
     * @param myDate:LocalDate is the variable that is going to be searched for an exact date.
     */

    public static void getCowTreatment(int tagNo, LocalDate myDate) {
        int tagNoFlag = 0;
        Cow tempCow = new Cow();
        for(Cow c: cows) {
            if (tagNo == c.getTagNo()) {
                tagNoFlag = 1;
                tempCow = c;
                break;
            }
        }

        int dateFlag = 0;
        for (int i=0; i<tempCow.getTreatment().size(); i++) {
            if (tempCow.getTreatment().get(i).getDateOfTreatment().compareTo(myDate) == 0) {
                dateFlag = 1;
                break;
            }
        }

        if (tagNoFlag == 0)
            System.out.println("\nCow Tag No " + tagNo + " does not exist!");
        else if (dateFlag == 0)
            System.out.println("\nCow Tag No " + tagNo + " does not have any treatment in " + myDate);
        else {
            int treatmentCounter = 1;
            for(int i=0; i<tempCow.getTreatment().size(); i++) {
                if(tempCow.getTreatment().get(i).getDateOfTreatment().compareTo(myDate) == 0) {
                    System.out.println("\nCow Treatment-" + treatmentCounter + " date: " + tempCow.getTreatment().get(i).getDateOfTreatment()
                            + "\nCow Treatment-" + treatmentCounter + " details: " + tempCow.getTreatment().get(i).getDetails() + "\n");
                    treatmentCounter++;
                }
            }
        }
    }

    /**
     * This method basically lists all the cows' attributes in the arraylist including the Treatment Array List.
     */

    public static void listCow() {
        System.out.println("\nCow List: ");
        String tempPurchased;

        for (Cow cow : cows) {
            if (cow.getPurchased()) // for displaying better to the user
                tempPurchased = "Purchased";
            else
                tempPurchased = "Farm-raising";

            System.out.println("\nTag No: " + cow.getTagNo() + "\nGender: " + cow.getGender() + "\nDate of birth: " + cow.getDateOfBirth()
                    + "\nAge: " + cow.getAge() + "\nFrom where: " + tempPurchased);

            for(int i=0; i<cow.getTreatment().size(); i++) {
                System.out.println("\nCow Tag No: " + cow.getTagNo() + " Treatment-"+ (i+1) +" date: " + cow.getTreatment().get(i).getDateOfTreatment() +
                        "\nCow Tag No: " + cow.getTagNo() + " Treatment-" + (i+1) + " details: " + cow.getTreatment().get(i).getDetails() + "\n");

                for(int j=0; j<cow.getTreatment().get(i).getMedications().size(); j++) {
                    System.out.println("Medication- " + (j+1) + " details: " + cow.getTreatment().get(i).getMedications().get(j).getDetails() + "\nMedication- " + (j+1) + " duration: " +
                            + cow.getTreatment().get(i).getMedications().get(j).getDuration() +
                            "\nMedication- " + (j+1) + " start date: " + cow.getTreatment().get(i).getDateOfTreatment() +
                            "\nMedication- " + (j+1) + " dosage: " + cow.getTreatment().get(i).getMedications().get(j).getDosage() +
                            "\nMedication- " + (j+1) + " notes: " + cow.getTreatment().get(i).getMedications().get(j).getNotes());
                }
            }

        }
    }

    /**
     * This method basically lists all the vet's attributes in the arrayList including the Treatment Object
     */
    public static void listVet() {
        System.out.println("\nVet List: ");

        for(Veterinary vet: veterinaries) {
            System.out.println("\nVet Id: " + vet.getVetID() + "\nGender: " + vet.getGender() + "\nDate of birth: " + vet.getDateOfBirth()
                    + "\nSalary: " + vet.getSalary());
            if (vet.getTreatment() != null) {
                System.out.println("\nTreatment date: " + vet.getTreatment().getDateOfTreatment() + "\nTreatment details: " + vet.getTreatment().getDetails());
                for(int i=0; i<vet.getTreatment().getMedications().size(); i++) {
                    System.out.println("\nMedication "+ (i+1) + "detail: " + vet.getTreatment().getMedications().get(i).getDetails() +
                            "\nMedication "+ (i+1) + "duration: " + vet.getTreatment().getMedications().get(i).getDuration() +
                            "\nMedication "+ (i+1) + "start date: " + vet.getTreatment().getMedications().get(i).getStartDate() +
                            "\nMedication "+ (i+1) + "dosage: " + vet.getTreatment().getMedications().get(i).getDosage() +
                            "\nMedication "+ (i+1) + "notes: " + vet.getTreatment().getMedications().get(i).getNotes());
                }
            }
            else
                System.out.println("No treatment has been found for vetId " + vet.getVetID());
        }
    }
}
