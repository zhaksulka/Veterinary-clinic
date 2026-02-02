package org.example.model;

public class Surgery extends Treatment {

    private int durationMinutes;

    public Surgery(int id, String petName,
                   double cost, int durationMinutes) {
        super(id, petName, cost);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() { return durationMinutes; }

    @Override
    public String getType() {
        return "SURGERY";
    }
}
