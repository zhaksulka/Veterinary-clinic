public class Main {

    public static void main(String[] args) {

        System.out.println("=== Veterinary Clinic Management System ===\n");

        // CREATE OBJECTS
        Pet pet1 = new Pet(101, "Buddy", "Dog", 1, "Alice");
        Pet pet2 = new Pet(102, "Milo", "Cat", 5, "Bob");
        Pet pet3 = new Pet();

        Owner owner1 = new Owner(201, "Alice", "+77011111111", 2, false);
        Owner owner2 = new Owner();

        Veterinarian vet1 = new Veterinarian(301, "Dr. Smith", "Dog", 6, true);
        Veterinarian vet2 = new Veterinarian();

        // DISPLAY OBJECTS
        System.out.println("--- PETS ---");
        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);

        System.out.println("\n--- OWNERS ---");
        System.out.println(owner1);
        System.out.println(owner2);

        System.out.println("\n--- VETERINARIANS ---");
        System.out.println(vet1);
        System.out.println(vet2);

        // TEST GETTERS
        System.out.println("\n--- TESTING GETTERS ---");
        System.out.println("Pet1 name: " + pet1.getName());
        System.out.println("Owner1 phone: " + owner1.getPhone());
        System.out.println("Vet1 experience: " + vet1.getExperienceYears());

        // TEST SETTERS
        System.out.println("\n--- TESTING SETTERS ---");
        pet3.setName("Rocky");
        pet3.setSpecies("Dog");
        pet3.setAge(8);
        pet3.setOwnerName("Charlie");
        System.out.println("Updated pet3: " + pet3);

        // TEST METHODS
        System.out.println("\n--- TESTING PET METHODS ---");
        System.out.println(pet1.getName() + " is young: " + pet1.isYoung());
        System.out.println(pet2.getName() + " life stage: " + pet2.getLifeStage());

        System.out.println("\n--- TESTING OWNER METHODS ---");
        owner1.addPet();
        owner1.addPet();
        System.out.println(owner1.getName() + " VIP: " + owner1.isVIP());

        System.out.println("\n--- TESTING VET METHODS ---");
        System.out.println(vet1.getName() + " experienced: " + vet1.isExperienced());
        System.out.println(vet1.getName() + " can treat Dog: " + vet1.canTreat("Dog"));

        System.out.println("\n=== Program Complete ===");
    }
}
