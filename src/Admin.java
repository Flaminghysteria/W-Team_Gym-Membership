public class Admin extends User{
    private int adminId;

    public Admin(String name, String email, String phone, String username, String password) {
        super(name, email, phone, username, password);
    }

    public Admin(String name, String email, String phone, String username, String password, int adminId){
        super(name, email, phone, username, password);
        this.adminId = adminId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void manageMemebers() {

    }

    public void ManagePlans() {

    }

    public void managaeSessions() {

    }

    public void viewPayments() {

    }
}
