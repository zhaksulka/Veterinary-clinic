package menu;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Treatment> treatments = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n=== VETERINARY CLINIC ===");
        System.out.println("1. Add Vaccination");
        System.out.println("2. Add Surgery");
        System.out.println("3. View All Treatments");
        System.out.println("4. Perform All Treatments");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                System.out.print("Choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addVaccination();
                    case 2 -> addSurgery();
                    case 3 -> viewAll();
                    case 4 -> performAll();
                    case 0 -> running = false;
                    default -> throw new IllegalArgumentException("Invalid menu option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void addVaccination() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Pet: ");
            String pet = scanner.nextLine();

            System.out.print("Vet: ");
            String vet = scanner.nextLine();

            System.out.print("Cost: ");
            double cost = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Vaccine: ");
            String vaccine = scanner.nextLine();

            treatments.add(new Vaccination(id, pet, vet, cost, vaccine));
            System.out.println("Vaccination added!");
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }

    private void addSurgery() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Pet: ");
            String pet = scanner.nextLine();

            System.out.print("Vet: ");
            String vet = scanner.nextLine();

            System.out.print("Cost: ");
            double cost = scanner.nextDouble();

            System.out.print("Duration: ");
            int duration = scanner.nextInt();

            treatments.add(new Surgery(id, pet, vet, cost, duration));
            System.out.println("Surgery added!");
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }

    private void viewAll() {
        treatments.forEach(System.out::println);
    }

    private void performAll() {
        treatments.forEach(Treatment::performTreatment);
    }
}
