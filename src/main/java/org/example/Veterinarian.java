package model;

public class Veterinarian {

    private int vetId;
    private String name;
    private String specialization;
    private int experienceYears;
    private boolean available;

    public Veterinarian(int vetId, String name, String specialization,
                        int experienceYears, boolean available) {
        setVetId(vetId);
        setName(name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
        this.available = available;
    }

    public void setVetId(int vetId) {
        if (vetId <= 0) {
            throw new IllegalArgumentException("Vet ID must be positive");
        }
        this.vetId = vetId;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Vet name cannot be empty");
        }
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be empty");
        }
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Experience cannot be negative");
        }
        this.experienceYears = experienceYears;
    }
}
