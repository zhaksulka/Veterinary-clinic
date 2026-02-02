package org.example.model;

public class Owner {

    private int ownerId;
    private String name;
    private String phone;
    private int numberOfPets;
    private boolean frequentClient;

    public Owner(int ownerId, String name, String phone, int numberOfPets, boolean frequentClient) {
        setOwnerId(ownerId);
        setName(name);
        setPhone(phone);
        setNumberOfPets(numberOfPets);
        setFrequentClient(frequentClient);
    }

    public void setOwnerId(int ownerId) {
        if (ownerId <= 0) throw new IllegalArgumentException("Owner ID must be positive");
        this.ownerId = ownerId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty())
            throw new IllegalArgumentException("Phone cannot be empty");
        this.phone = phone;
    }

    public void setNumberOfPets(int numberOfPets) {
        if (numberOfPets < 0) throw new IllegalArgumentException("Number of pets cannot be negative");
        this.numberOfPets = numberOfPets;
        if (numberOfPets >= 3) this.frequentClient = true;
    }

    public void setFrequentClient(boolean frequentClient) {
        this.frequentClient = frequentClient;
    }

    public void addPet() {
        setNumberOfPets(numberOfPets + 1);
    }

    public boolean isVIP() {
        return frequentClient;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", numberOfPets=" + numberOfPets +
                ", frequentClient=" + frequentClient +
                '}';
    }
}
