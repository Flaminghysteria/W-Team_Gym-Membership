public class User {
    private String name, email, username, password;
    private long phone;

    public User(String name, String email, long phone, String username, String password){
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.username=username;
        this.password=password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }
}
