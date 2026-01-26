package org.example.model;

public abstract class Treatment {

    protected int treatmentId;
    protected String petName;
    protected String vetName;
    protected double cost;

    public Treatment(int treatmentId, String petName, String vetName, double cost) {
        setTreatmentId(treatmentId);
        setPetName(petName);
        setVetName(vetName);
        setCost(cost);
    }

    public void setTreatmentId(int treatmentId) {
        if (treatmentId <= 0) throw new IllegalArgumentException("ID must be positive");
        this.treatmentId = treatmentId;
    }

    public void setPetName(String petName) {
        if (petName == null || petName.trim().isEmpty())
            throw new IllegalArgumentException("Pet name cannot be empty");
        this.petName = petName;
    }

    public void setVetName(String vetName) {
        if (vetName == null || vetName.trim().isEmpty())
            throw new IllegalArgumentException("Vet name cannot be empty");
        this.vetName = vetName;
    }

    public void setCost(double cost) {
        if (cost < 0) throw new IllegalArgumentException("Cost cannot be negative");
        this.cost = cost;
    }

    public abstract void performTreatment();
    public abstract String getType();

    @Override
    public String toString() {
        return "[" + getType() + "] Pet: " + petName + ", Vet: " + vetName + ", Cost: " + cost + " KZT";
    }
}
