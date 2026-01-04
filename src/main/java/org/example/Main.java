import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Treatment> treatments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println(" VETERINARY CLINIC MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add General Treatment");
            System.out.println("2. Add Vaccination");
            System.out.println("3. Add Surgery");
            System.out.println("4. View All Treatments (Polymorphic)");
            System.out.println("5. Demonstrate Polymorphism");
            System.out.println("6. View Vaccinations Only");
            System.out.println("7. View Surgeries Only");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTreatment();
                case 2 -> addVaccination();
                case 3 -> addSurgery();
                case 4 -> viewAll();
                case 5 -> demonstratePolymorphism();
                case 6 -> viewVaccinations();
                case 7 -> viewSurgeries();
            }

        } while (choice != 0);

        System.out.println("Program finished.");
    }

    // ---------- MENU METHODS ----------

    private static void addTreatment() {
        System.out.println("\n--- ADD GENERAL TREATMENT ---");
        System.out.print("ID: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Pet name: ");
        String pet = scanner.nextLine();
        System.out.print("Vet name: ");
        String vet = scanner.nextLine();
        System.out.print("Cost: ");
        double cost = scanner.nextDouble();

        treatments.add(new Treatment(id, pet, vet, cost));
        System.out.println("Treatment added.");
    }

    private static void addVaccination() {
        System.out.println("\n--- ADD VACCINATION ---");
        System.out.print("ID: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Pet name: ");
        String pet = scanner.nextLine();
        System.out.print("Vet name: ");
        String vet = scanner.nextLine();
        System.out.print("Cost: ");
        double cost = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Vaccine name: ");
        String vaccine = scanner.nextLine();

        Treatment t = new Vaccination(id, pet, vet, cost, vaccine);
        treatments.add(t);
        System.out.println("Vaccination added.");
    }

    private static void addSurgery() {
        System.out.println("\n--- ADD SURGERY ---");
        System.out.print("ID: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Pet name: ");
        String pet = scanner.nextLine();
        System.out.print("Vet name: ");
        String vet = scanner.nextLine();
        System.out.print("Cost: ");
        double cost = scanner.nextDouble();
        System.out.print("Duration (minutes): ");
        int duration = scanner.nextInt();

        treatments.add(new Surgery(id, pet, vet, cost, duration));
        System.out.println("Surgery added.");
    }

    private static void viewAll() {
        System.out.println("\n--- ALL TREATMENTS ---");
        for (Treatment t : treatments) {
            System.out.println(t);
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        for (Treatment t : treatments) {
            t.performTreatment(); // SAME METHOD — DIFFERENT BEHAVIOR
        }
    }

    private static void viewVaccinations() {
        System.out.println("\n--- VACCINATIONS ONLY ---");
        for (Treatment t : treatments) {
            if (t instanceof Vaccination) {
                Vaccination v = (Vaccination) t;
                System.out.println(v);
            }
        }
    }

    private static void viewSurgeries() {
        System.out.println("\n--- SURGERIES ONLY ---");
        for (Treatment t : treatments) {
            if (t instanceof Surgery) {
                Surgery s = (Surgery) t;
                System.out.println(s);
            }
        }
    }
}
