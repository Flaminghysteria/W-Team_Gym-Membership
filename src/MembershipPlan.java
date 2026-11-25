public class MembershipPlan {
        private String planName;       //Monthly, Quarterly, Yearly
        private double fee;  

        public MembershipPlan() {
            this.planName = "";
            this.fee = 0.0;
        }

        public MembershipPlan(String planName, double fee) {
            this.planName = planName;
            this.fee = fee;
        }

        public void renewPlan(double newFee, int extraMonths) {

        }

        public void cancelPlan() {

        }

        public String getPlanName() {
            return planName;
        }

        public double getFee() {
            return fee;
        }
}