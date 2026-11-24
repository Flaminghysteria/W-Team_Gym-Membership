public class Member extends User{
    boolean hasTrainer;

    public Member(String name, String email, String phone, String username, String password, boolean hasTrainer){
        super(name, email, phone, username, password);
        this.hasTrainer = hasTrainer;
    }

    public boolean getHasTrainer() {
        return hasTrainer;
    }

}
