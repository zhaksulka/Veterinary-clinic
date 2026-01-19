package model;

public class Pet {

    private int petId;
    private String name;
    private String species;
    private int age;
    private String ownerName;

    public Pet(int petId, String name, String species, int age, String ownerName) {
        setPetId(petId);
        setName(name);
        setSpecies(species);
        setAge(age);
        setOwnerName(ownerName);
    }

    public void setPetId(int petId) {
        if (petId <= 0) {
            throw new IllegalArgumentException("Pet ID must be positive");
        }
        this.petId = petId;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Pet name cannot be empty");
        }
        this.name = name;
    }

    public void setSpecies(String species) {
        if (species == null || species.isEmpty()) {
            throw new IllegalArgumentException("Species cannot be empty");
        }
        this.species = species;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty");
        }
        this.ownerName = ownerName;
    }
}
