package org.example.model;

public class Vaccination extends Treatment {

    private String vaccineName;

    public Vaccination(int id, String petName,
                       double cost, String vaccineName) {
        super(id, petName, cost);
        this.vaccineName = vaccineName;
    }

    public String getVaccineName() { return vaccineName; }

    @Override
    public String getType() {
        return "VACCINATION";
    }
}
