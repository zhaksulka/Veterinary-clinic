public class Treatment {

    // protected fields (required)
    protected int treatmentId;
    protected String petName;
    protected String vetName;
    protected double cost;

    // constructor
    public Treatment(int treatmentId, String petName, String vetName, double cost) {
        this.treatmentId = treatmentId;
        this.petName = petName;
        this.vetName = vetName;
        this.cost = cost;
    }

    // getters
    public int getTreatmentId() { return treatmentId; }
    public String getPetName() { return petName; }
    public String getVetName() { return vetName; }
    public double getCost() { return cost; }

    // setters
    public void setCost(double cost) {
        if (cost >= 0) this.cost = cost;
    }

    // methods to override
    public void performTreatment() {
        System.out.println("Treatment is being performed for pet " + petName);
    }

    public String getType() {
        return "General Treatment";
    }

    public boolean isExpensive() {
        return cost > 10000;
    }

    @Override
    public String toString() {
        return "[" + getType() + "] Pet: " + petName +
                ", Vet: " + vetName +
                ", Cost: " + cost + " KZT";
    }
}
