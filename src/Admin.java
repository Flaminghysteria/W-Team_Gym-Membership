public class Admin extends User{
    private int adminId;

    public Admin(){
        super("Admin,", "admin@wteamgym.com", "N/A", "admin", "k7#Rp9$vM2@x");
    }

    public Admin(String name, String email, String phone, String username, String password) {
        super(name, email, phone, username, password);
    }

    public int getAdminId() {
        return adminId;
    }

    public void manageMemebers() {

    }

    public void ManagePlans() {

    }

    public void manageSessions() {

    }

    public void viewPayments() {

    }
}
