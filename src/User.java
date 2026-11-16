public abstract class User {
    private int userId;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;

    public User(int userId, String name, String email, String phone, String username, String password){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public boolean login(){
        return false;
    }

    public void logout(){

    }

    public void updateProfile(){

    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }
}
