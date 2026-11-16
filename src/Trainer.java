public class Trainer extends User{
    private String specialization;

    public Trainer(int userId, String name, String email, String phone, String username, String password, String specialization){
        super(userId, name, email, phone, username, password);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
