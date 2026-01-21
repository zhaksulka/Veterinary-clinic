package org.example.menu;

import org.example.model.Treatment;
import org.example.model.Vaccination;
import org.example.model.Surgery;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Treatment> treatments = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n=== VETERINARY CLINIC MENU ===");
        System.out.println("1. Add General Treatment");
        System.out.println("2. Add Vaccination");
        System.out.println("3. Add Surgery");
        System.out.println("4. View All Treatments");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> addTreatment();
                    case 2 -> addVaccination();
                    case 3 -> addSurgery();
                    case 4 -> viewAll();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void addTreatment() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Pet name: ");
            String pet = scanner.nextLine();
            System.out.print("Vet name: ");
            String vet = scanner.nextLine();
            System.out.print("Cost: ");
            double cost = scanner.nextDouble();
            treatments.add(new Treatment(id, pet, vet, cost) { // анонимный класс для абстрактного
                @Override
                public void performTreatment() {
                    System.out.println("General treatment for " + pet);
                }
                @Override
                public String getType() { return "General Treatment"; }
            });
            System.out.println("Treatment added!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addVaccination() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Pet name: ");
            String pet = scanner.nextLine();
            System.out.print("Vet name: ");
            String vet = scanner.nextLine();
            System.out.print("Cost: ");
            double cost = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Vaccine name: ");
            String vaccine = scanner.nextLine();
            treatments.add(new Vaccination(id, pet, vet, cost, vaccine));
            System.out.println("Vaccination added!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addSurgery() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Pet name: ");
            String pet = scanner.nextLine();
            System.out.print("Vet name: ");
            String vet = scanner.nextLine();
            System.out.print("Cost: ");
            double cost = scanner.nextDouble();
            System.out.print("Duration (minutes): ");
            int duration = scanner.nextInt();
            treatments.add(new Surgery(id, pet, vet, cost, duration));
            System.out.println("Surgery added!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewAll() {
        System.out.println("\n--- ALL TREATMENTS ---");
        for (Treatment t : treatments) {
            System.out.println(t);
        }
    }
}



















































/*
package org.example.menu;

import org.example.model.Treatment;
import org.example.model.Vaccination;
import org.example.model.Surgery;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Treatment> treatments = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n=== VETERINARY CLINIC MENU ===");
        System.out.println("1. Add General Treatment");
        System.out.println("2. Add Vaccination");
        System.out.println("3. Add Surgery");
        System.out.println("4. View All Treatments");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> addTreatment();
                    case 2 -> addVaccination();
                    case 3 -> addSurgery();
                    case 4 -> viewAll();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void addTreatment() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Pet name: ");
            String pet = scanner.nextLine();
            System.out.print("Vet name: ");
            String vet = scanner.nextLine();
            System.out.print("Cost: ");
            double cost = scanner.nextDouble();
            treatments.add(new Treatment(id, pet, vet, cost) { // анонимный класс для абстрактного
                @Override
                public void performTreatment() {
                    System.out.println("General treatment for " + pet);
                }
                @Override
                public String getType() { return "General Treatment"; }
            });
            System.out.println("Treatment added!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addVaccination() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Pet name: ");
            String pet = scanner.nextLine();
            System.out.print("Vet name: ");
            String vet = scanner.nextLine();
            System.out.print("Cost: ");
            double cost = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Vaccine name: ");
            String vaccine = scanner.nextLine();
            treatments.add(new Vaccination(id, pet, vet, cost, vaccine));
            System.out.println("Vaccination added!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addSurgery() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Pet name: ");
            String pet = scanner.nextLine();
            System.out.print("Vet name: ");
            String vet = scanner.nextLine();
            System.out.print("Cost: ");
            double cost = scanner.nextDouble();
            System.out.print("Duration (minutes): ");
            int duration = scanner.nextInt();
            treatments.add(new Surgery(id, pet, vet, cost, duration));
            System.out.println("Surgery added!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewAll() {
        System.out.println("\n--- ALL TREATMENTS ---");
        for (Treatment t : treatments) {
            System.out.println(t);
        }
    }
}
*/