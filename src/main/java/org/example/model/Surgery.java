package org.example.model;

public class Surgery extends Treatment implements Billable {

    private int durationMinutes;

    public Surgery(int id, String pet, String vet, double cost, int durationMinutes) {
        super(id, pet, vet, cost);
        setDurationMinutes(durationMinutes);
    }

    @Override
    public void performTreatment() {
        System.out.println("Performing surgery on " + petName +
                " (" + durationMinutes + " minutes)");
    }

    @Override
    public String getType() {
        return "Surgery";
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        this.durationMinutes = durationMinutes;
    }

    // Interface method
    @Override
    public double calculateBill() {
        return cost + durationMinutes * 100;
    }

    @Override
    public String toString() {
        return super.toString() + " | Duration: " + durationMinutes + " min";
    }
}
