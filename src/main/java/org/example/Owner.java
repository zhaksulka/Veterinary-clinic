package model;

public class Owner {

    // 1. PRIVATE FIELDS
    private int ownerId;
    private String name;
    private String phone;
    private int numberOfPets;
    private boolean frequentClient;

    // 2. CONSTRUCTOR WITH PARAMETERS (USES SETTERS)
    public Owner(int ownerId, String name, String phone, int numberOfPets, boolean frequentClient) {
        setOwnerId(ownerId);
        setName(name);
        setPhone(phone);
        setNumberOfPets(numberOfPets);
        this.frequentClient = frequentClient;
    }

    // 3. DEFAULT CONSTRUCTOR
    public Owner() {
        this.ownerId = 0;
        this.name = "Unknown";
        this.phone = "N/A";
        this.numberOfPets = 0;
        this.frequentClient = false;
    }

    // 4. GETTERS
    public int getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getNumberOfPets() {
        return numberOfPets;
    }

    public boolean isFrequentClient() {
        return frequentClient;
    }

    // 5. SETTERS (THROW EXCEPTIONS – REQUIRED)
    public void setOwnerId(int ownerId) {
        if (ownerId <= 0) {
            throw new IllegalArgumentException("Owner ID must be positive");
        }
        this.ownerId = ownerId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty");
        }
        this.name = name;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.phone = phone;
    }

    public void setNumberOfPets(int numberOfPets) {
        if (numberOfPets < 0) {
            throw new IllegalArgumentException("Number of pets cannot be negative");
        }
        this.numberOfPets = numberOfPets;
        this.frequentClient = numberOfPets >= 3;
    }

    public void setFrequentClient(boolean frequentClient) {
        this.frequentClient = frequentClient;
    }

    // 6. ADDITIONAL METHODS
    public void addPet() {
        numberOfPets++;
        frequentClient = numberOfPets >= 3;
    }

    public boolean isVIP() {
        return frequentClient;
    }

    // 7. toString()
    @Override
    public String toString() {
        return "Owner{ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", numberOfPets=" + numberOfPets +
                ", frequentClient=" + frequentClient +
                '}';
    }
}
