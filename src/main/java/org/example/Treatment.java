package model;

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

    // Concrete method
    public boolean isExpensive() {
        return cost > 10000;
    }

    // Abstract methods (REQUIRED)
    public abstract void performTreatment();
    public abstract String getType();

    // Setters with exceptions
    public void setTreatmentId(int treatmentId) {
        if (treatmentId <= 0) {
            throw new IllegalArgumentException("Treatment ID must be positive");
        }
        this.treatmentId = treatmentId;
    }

    public void setPetName(String petName) {
        if (petName == null || petName.trim().isEmpty()) {
            throw new IllegalArgumentException("Pet name cannot be empty");
        }
        this.petName = petName;
    }

    public void setVetName(String vetName) {
        if (vetName == null || vetName.trim().isEmpty()) {
            throw new IllegalArgumentException("Vet name cannot be empty");
        }
        this.vetName = vetName;
    }

    public void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "[" + getType() + "] Pet: " + petName +
                ", Vet: " + vetName +
                ", Cost: " + cost + " KZT";
    }
}
