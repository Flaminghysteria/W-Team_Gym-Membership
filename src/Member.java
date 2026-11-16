public class Member extends User{
    private int membershipNo;
    private Trainer trainer;

    public Member(int userId, String name, String email, String phone, String username, String password, int membershipNo){
        super(userId, name, email, phone, username, password);
        this.membershipNo = membershipNo;
        this.trainer = null;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return trainer;
    }
}
