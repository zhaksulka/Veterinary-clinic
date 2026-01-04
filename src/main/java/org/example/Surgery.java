public class Surgery extends Treatment {

    private int durationMinutes;

    public Surgery(int treatmentId, String petName, String vetName,
                   double cost, int durationMinutes) {
        super(treatmentId, petName, vetName, cost);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes > 0) this.durationMinutes = durationMinutes;
    }

    // override 1
    @Override
    public void performTreatment() {
        System.out.println("Performing surgery on " + petName +
                " (Duration: " + durationMinutes + " minutes)");
    }

    // override 2
    @Override
    public String getType() {
        return "Surgery";
    }

    // unique methods
    public boolean isLongSurgery() {
        return durationMinutes > 120;
    }

    public void extendSurgery(int extraMinutes) {
        durationMinutes += extraMinutes;
    }

    @Override
    public String toString() {
        return super.toString() + " | Duration: " + durationMinutes + " min";
    }
}
