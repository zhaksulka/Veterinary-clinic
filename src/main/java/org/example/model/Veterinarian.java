package org.example.model;

public class Veterinarian {

    private int vetId;
    private String name;
    private String specialization;
    private int experienceYears;
    private boolean available;

    public Veterinarian(int vetId, String name, String specialization, int experienceYears, boolean available) {
        setVetId(vetId);
        setName(name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
        setAvailable(available);
    }

    public void setVetId(int vetId) {
        if (vetId <= 0) throw new IllegalArgumentException("Vet ID must be positive");
        this.vetId = vetId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty())
            throw new IllegalArgumentException("Specialization cannot be empty");
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) throw new IllegalArgumentException("Experience cannot be negative");
        this.experienceYears = experienceYears;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    public boolean canTreat(String species) {
        return specialization.equalsIgnoreCase("General") || specialization.equalsIgnoreCase(species);
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "vetId=" + vetId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                ", available=" + available +
                '}';
    }
}
