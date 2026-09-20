import java.util.ArrayList;
import java.util.Scanner;

class Biodata {
    private String firstName;
    private String middleName;
    private String lastName;
    private String age;
    private String gender;
    private String birthDate;
    private String address;
    private String contactNumber;
    private String university;

    public Biodata(String firstName, String middleName, String lastName, String age,
                    String gender, String birthDate, String address, String contactNumber,
                    String university) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.contactNumber = contactNumber;
        this.university = university;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void showInfo() {
        System.out.println("\n========== Biodata Profile ==========");
        System.out.println("First Name:     " + firstName);
        System.out.println("Middle Name:    " + middleName);
        System.out.println("Last Name:      " + lastName);
        System.out.println("Age:            " + age);
        System.out.println("Gender:         " + gender);
        System.out.println("Birth Date:     " + birthDate);
        System.out.println("Address:        " + address);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("University:     " + university);
        System.out.println("======================================");
    }
}

public class BiodataSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Biodata> biodataList = new ArrayList<>();

    // ADD BIODATA
    public static void addBiodata() {
        System.out.println("\n========== Add Biodata ==========");

        System.out.print("First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Middle Name: ");
        String middleName = sc.nextLine();

        System.out.print("Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Age: ");
        String age = sc.nextLine();

        System.out.print("Gender: ");
        String gender = sc.nextLine();

        System.out.print("Birth Date: ");
        String birthDate = sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        System.out.print("Contact Number: ");
        String contactNumber = sc.nextLine();

        System.out.print("University: ");
        String university = sc.nextLine();

        Biodata biodata = new Biodata(
            firstName,
            middleName,
            lastName,
            age,
            gender,
            birthDate,
            address,
            contactNumber,
            university
        );

        biodataList.add(biodata);

        System.out.println("\nBiodata successfully added!");
    }

    // SHOW ALL BIODATA
    public static void showBiodata() {

        if (biodataList.isEmpty()) {
            System.out.println("\nNo biodata records found.");
            return;
        }

        System.out.println("\n========== Biodata Records ==========");

        for (int i = 0; i < biodataList.size(); i++) {
            System.out.println("\nRecord #" + (i + 1));
            biodataList.get(i).showInfo();
        }
    }

    // EDIT BIODATA
    public static void editBiodata() {

        if (biodataList.isEmpty()) {
            System.out.println("\nNo biodata records found.");
            return;
        }

        showBiodata();

        System.out.print("\nEnter record number to edit: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index < 1 || index > biodataList.size()) {
            System.out.println("Invalid record number.");
            return;
        }

        Biodata biodata = biodataList.get(index - 1);

        System.out.println("\n========== Edit Biodata ==========");

        System.out.print("New First Name: ");
        biodata.setFirstName(sc.nextLine());

        System.out.print("New Middle Name: ");
        biodata.setMiddleName(sc.nextLine());

        System.out.print("New Last Name: ");
        biodata.setLastName(sc.nextLine());

        System.out.print("New Age: ");
        biodata.setAge(sc.nextLine());

        System.out.print("New Gender: ");
        biodata.setGender(sc.nextLine());

        System.out.print("New Birth Date: ");
        biodata.setBirthDate(sc.nextLine());

        System.out.print("New Address: ");
        biodata.setAddress(sc.nextLine());

        System.out.print("New Contact Number: ");
        biodata.setContactNumber(sc.nextLine());

        System.out.println("\nBiodata successfully updated!");
    }

    // DELETE BIODATA
    public static void deleteBiodata() {

        if (biodataList.isEmpty()) {
            System.out.println("\nNo biodata records found.");
            return;
        }

        showBiodata();

        System.out.print("\nEnter record number to delete: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index < 1 || index > biodataList.size()) {
            System.out.println("Invalid record number.");
            return;
        }

        biodataList.remove(index - 1);

        System.out.println("\nBiodata successfully deleted!");
    }

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.println("\n========== Biodata System ==========");
            System.out.println("1. Add Biodata");
            System.out.println("2. Show Biodata");
            System.out.println("3. Edit Biodata");
            System.out.println("4. Delete Biodata");
            System.out.println("5. Exit");
            System.out.println("=====================================");

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBiodata();
                    break;

                case 2:
                    showBiodata();
                    break;

                case 3:
                    editBiodata();
                    break;

                case 4:
                    deleteBiodata();
                    break;

                case 5:
                    running = false;
                    System.out.println("\nExiting Biodata System. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid option. Please try again.");
                    break;
            }
        }

        sc.close();
    }
}