public class Vaccination extends Treatment {

    private String vaccineName;

    public Vaccination(int treatmentId, String petName, String vetName,
                       double cost, String vaccineName) {
        super(treatmentId, petName, vetName, cost); // FIRST LINE
        this.vaccineName = vaccineName;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    // override 1
    @Override
    public void performTreatment() {
        System.out.println("Vaccinating " + petName +
                " with vaccine: " + vaccineName);
    }

    // override 2
    @Override
    public String getType() {
        return "Vaccination";
    }

    // unique methods
    public boolean isAnnualVaccine() {
        return vaccineName.equalsIgnoreCase("Rabies");
    }

    public void printCertificate() {
        System.out.println("Vaccination certificate issued for " + petName);
    }

    @Override
    public String toString() {
        return super.toString() + " | Vaccine: " + vaccineName;
    }
}
