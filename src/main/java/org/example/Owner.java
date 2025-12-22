public class Owner {

    // 1. PRIVATE FIELDS
    private int ownerId;
    private String name;
    private String phone;
    private int numberOfPets;
    private boolean frequentClient;

    // 2. CONSTRUCTOR WITH PARAMETERS
    public Owner(int ownerId, String name, String phone, int numberOfPets, boolean frequentClient) {
        this.ownerId = ownerId;
        this.name = name;
        this.phone = phone;
        this.numberOfPets = numberOfPets;
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

    // 5. SETTERS
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNumberOfPets(int numberOfPets) {
        this.numberOfPets = numberOfPets;
    }

    public void setFrequentClient(boolean frequentClient) {
        this.frequentClient = frequentClient;
    }

    // 6. ADDITIONAL METHODS
    public void addPet() {
        numberOfPets++;
        if (numberOfPets >= 3) {
            frequentClient = true;
        }
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
