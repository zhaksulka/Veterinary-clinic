public class Pet {

    // 1. PRIVATE FIELDS
    private int petId;
    private String name;
    private String species;
    private int age;
    private String ownerName;

    // 2. CONSTRUCTOR WITH PARAMETERS
    public Pet(int petId, String name, String species, int age, String ownerName) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.age = age;
        this.ownerName = ownerName;
    }

    // 3. DEFAULT CONSTRUCTOR
    public Pet() {
        this.petId = 0;
        this.name = "Unknown";
        this.species = "Unknown";
        this.age = 0;
        this.ownerName = "Unknown";
    }

    // 4. GETTERS
    public int getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    // 5. SETTERS
    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // 6. ADDITIONAL METHODS
    public boolean isYoung() {
        return age < 2;
    }
    //This method checks if the pet is younger than two years and returns true or false.
    public String getLifeStage() {
        if (age < 2) {
            return "Puppy/Kitten";
        } else if (age <= 7) {
            return "Adult";
        } else {
            return "Senior";
        }
    }

    // 7. toString()
    @Override
    public String toString() {
        return "Pet{petId=" + petId +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
