package model;

public class Vaccination extends Treatment {

    private String vaccineName;

    public Vaccination(int id, String pet, String vet, double cost, String vaccineName) {
        super(id, pet, vet, cost);
        setVaccineName(vaccineName);
    }

    @Override
    public void performTreatment() {
        System.out.println("Vaccinating " + petName + " with " + vaccineName);
    }

    @Override
    public String getType() {
        return "Vaccination";
    }

    public void setVaccineName(String vaccineName) {
        if (vaccineName == null || vaccineName.trim().isEmpty()) {
            throw new IllegalArgumentException("Vaccine name cannot be empty");
        }
        this.vaccineName = vaccineName;
    }

    @Override
    public String toString() {
        return super.toString() + " | Vaccine: " + vaccineName;
    }
}
