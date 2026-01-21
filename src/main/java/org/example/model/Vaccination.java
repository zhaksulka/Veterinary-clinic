package org.example.model;

public class Vaccination extends Treatment {

    private String vaccineName;

    public Vaccination(int treatmentId, String petName, String vetName, double cost, String vaccineName) {
        super(treatmentId, petName, vetName, cost);
        setVaccineName(vaccineName);
    }

    public void setVaccineName(String vaccineName) {
        if (vaccineName == null || vaccineName.trim().isEmpty())
            throw new IllegalArgumentException("Vaccine name cannot be empty");
        this.vaccineName = vaccineName;
    }

    @Override
    public void performTreatment() {
        System.out.println("Vaccinating " + petName + " with " + vaccineName);
    }

    @Override
    public String getType() {
        return "Vaccination";
    }

    @Override
    public String toString() {
        return super.toString() + " | Vaccine: " + vaccineName;
    }
}





























































/*
package org.example.model;

public class Vaccination extends Treatment {

    private String vaccineName;

    public Vaccination(int treatmentId, String petName, String vetName, double cost, String vaccineName) {
        super(treatmentId, petName, vetName, cost);
        setVaccineName(vaccineName);
    }

    public void setVaccineName(String vaccineName) {
        if (vaccineName == null || vaccineName.trim().isEmpty())
            throw new IllegalArgumentException("Vaccine name cannot be empty");
        this.vaccineName = vaccineName;
    }

    @Override
    public void performTreatment() {
        System.out.println("Vaccinating " + petName + " with " + vaccineName);
    }

    @Override
    public String getType() {
        return "Vaccination";
    }

    @Override
    public String toString() {
        return super.toString() + " | Vaccine: " + vaccineName;
    }
}
*/