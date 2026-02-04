package menu;

import org.example.database.PetDAO;
import model.Pet;
import org.example.menu.Menu;

import java.util.List;
import java.util.Scanner;

public class ClinicMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private PetDAO petDAO = new PetDAO();

    @Override
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n--- VET CLINIC MENU ---");
            System.out.println("1. Add Pet");
            System.out.println("2. View All Pets");
            System.out.println("3. Update Pet");
            System.out.println("4. Delete Pet");
            System.out.println("5. Search Pet by Name");
            System.out.println("6. Search Pet by Species");
            System.out.println("7. Search Pet by Age Range");
            System.out.println("8. Search Pet by Min Age");
            System.out.println("9. Search Pet by Owner Name");
            System.out.println("10. Polymorphism Demo");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPet();
                case 2 -> petDAO.getAllPets();
                case 3 -> updatePet();
                case 4 -> deletePet();
                case 5 -> searchByName();
                case 6 -> searchBySpecies();
                case 7 -> searchByAgeRange();
                case 8 -> searchByMinAge();
                case 9 -> searchByOwnerName();
                case 10 -> polymorphismDemo();
                case 11 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 11);
    }

    private void addPet() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Species: ");
        String species = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Owner Name: ");
        String owner = scanner.nextLine();

        Pet pet = new Pet(0, name, species, age, owner);
        petDAO.insertPet(pet);
    }

    private void updatePet() {
        System.out.print("Enter Pet ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Pet pet = petDAO.getPetById(id);
        if (pet == null) {
            System.out.println("Pet not found!");
            return;
        }
        System.out.print("New Name [" + pet.getName() + "]: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) pet.setName(name);

        System.out.print("New Species [" + pet.getSpecies() + "]: ");
        String species = scanner.nextLine();
        if (!species.isEmpty()) pet.setSpecies(species);

        System.out.print("New Age [" + pet.getAge() + "]: ");
        String ageStr = scanner.nextLine();
        if (!ageStr.isEmpty()) pet.setAge(Integer.parseInt(ageStr));

        System.out.print("New Owner [" + pet.getOwnerName() + "]: ");
        String owner = scanner.nextLine();
        if (!owner.isEmpty()) pet.setOwnerName(owner);

        petDAO.updatePet(pet);
    }

    private void deletePet() {
        System.out.print("Enter Pet ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Pet pet = petDAO.getPetById(id);
        if (pet == null) {
            System.out.println("Pet not found!");
            return;
        }
        System.out.println("Pet to delete: " + pet);
        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) petDAO.deletePet(id);
        else System.out.println("Deletion cancelled.");
    }

    private void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        List<Pet> pets = petDAO.searchByName(name);
        pets.forEach(System.out::println);
    }

    private void searchBySpecies() {
        System.out.print("Enter species to search: ");
        String species = scanner.nextLine();
        List<Pet> pets = petDAO.searchBySpecies(species);
        pets.forEach(System.out::println);
    }

    private void searchByAgeRange() {
        System.out.print("Enter min age: ");
        int min = scanner.nextInt();
        System.out.print("Enter max age: ");
        int max = scanner.nextInt();
        scanner.nextLine();
        List<Pet> pets = petDAO.searchByAgeRange(min, max);
        pets.forEach(System.out::println);
    }

    private void searchByMinAge() {
        System.out.print("Enter min age: ");
        int min = scanner.nextInt();
        scanner.nextLine();
        List<Pet> pets = petDAO.searchByMinAge(min);
        pets.forEach(System.out::println);
    }

    private void searchByOwnerName() {
        System.out.print("Enter owner name: ");
        String owner = scanner.nextLine();
        List<Pet> pets = petDAO.searchByOwnerName(owner);
        pets.forEach(System.out::println);
    }

    private void polymorphismDemo() {
        System.out.println("Polymorphism Demo:");
        Pet pet = new Pet(0, "Max", "Dog", 5, "John");
        System.out.println(pet);
    }
}
