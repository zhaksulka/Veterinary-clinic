package org.example.model;

public abstract class Treatment {

    protected int id;
    protected String petName;
    protected double cost;

    public Treatment(int id, String petName, double cost) {
        this.id = id;
        this.petName = petName;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getPetName() { return petName; }
    public double getCost() { return cost; }

    public abstract String getType();

    @Override
    public String toString() {
        return "ID: " + id +
                ", Pet: " + petName +
                ", Type: " + getType() +
                ", Cost: " + cost;
    }
}
