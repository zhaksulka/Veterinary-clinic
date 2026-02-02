package org.example.model;

public class GeneralTreatment extends Treatment {

    private String description;

    public GeneralTreatment(int id, String petName,
                            double cost, String description) {
        super(id, petName, cost);
        this.description = description;
    }

    public String getDescription() { return description; }

    @Override
    public String getType() {
        return "GENERAL";
    }
}
