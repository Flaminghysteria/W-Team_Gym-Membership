public class MembershipPlan {
        private int planId;
        private String planName;       //"Zumba", "Yoga", "Pilates"
        private double fee;
        private int durationMonths;    // e.g., 1 month, 3 months, 12 months
        private String description;    // Optional summary of perks or schedule
        private boolean isActive;      // To toggle active/archived plans easily

        public MembershipPlan() {
            this.planId = 0;
            this.planName = "";
            this.fee = 0.0;
            this.durationMonths = 1;
            this.description = "";
            this.isActive = true;
        }

        // Parameterized Constructor
        public MembershipPlan(int planId, String planName, double fee, int durationMonths, String description) {
            this.planId = planId;
            this.planName = planName;
            this.fee = fee;
            this.durationMonths = durationMonths;
            this.description = description;
            this.isActive = true;
        }

        public double calculateTotalFee(int multiplier) {
            return this.fee * multiplier;
        }

        // Updates plan details safely
        public void renewPlan(double newFee, int extraMonths) {
            this.fee = newFee;
            this.durationMonths += extraMonths;
        }

        // Deactivates the plan without deleting the object record
        public void cancelPlan() {
            this.isActive = false;
        }

        public int getPlanId() {
            return planId;
        }

        public void setPlanId(int planId) {
            this.planId = planId;
        }

        public String getPlanName() {
            return planName;
        }

        public void setPlanName(String planName) {
            this.planName = planName;
        }

        public double getFee() {
            return fee;
        }

        public void setFee(double fee) {
            this.fee = fee;
        }

        public int getDurationMonths() {
            return durationMonths;
        }

        public void setDurationMonths(int durationMonths) {
            this.durationMonths = durationMonths;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        // Extremely useful for Swing JComboBox/JList dropdowns to show clean text
        @Override
        public String toString() {
            return planName + " - ₱" + String.format("%.2f", fee);
        }
}