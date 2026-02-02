package model;

public class Pet {
    private int petId;
    private String name;
    private String species;
    private int age;
    private String ownerName;

    public Pet(int petId, String name, String species, int age, String ownerName) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.age = age;
        this.ownerName = ownerName;
    }

    public int getPetId() { return petId; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public String getOwnerName() { return ownerName; }

    public void setName(String name) { this.name = name; }
    public void setSpecies(String species) { this.species = species; }
    public void setAge(int age) { this.age = age; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    @Override
    public String toString() {
        return "Pet{" +
                "ID=" + petId +
                ", Name='" + name + '\'' +
                ", Species='" + species + '\'' +
                ", Age=" + age +
                ", Owner='" + ownerName + '\'' +
                '}';
    }
}
