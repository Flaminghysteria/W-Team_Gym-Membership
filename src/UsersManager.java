import java.util.ArrayList;

public class UsersManager {
    private final ArrayList<User> users;

    public UsersManager() {
        users = FileHandler.loadUsers();
    }

    public boolean signup(String name, String email, String phone, String username, String password) {
        boolean success = FileHandler.saveUser(name, email, phone, username, password);
        if (!success) return false;
        User user = new User(name, email, phone, username, password);
        users.add(user);
        return true;
    }

    public boolean login(String userInput, String password) {
        Admin admin = new Admin();
        if (userInput.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            return true;
        }

        for (User user : FileHandler.loadUsers()) {
            boolean matchesIdentifier =
                    user.getName().equals(userInput) ||
                            user.getEmail().equals(userInput) ||
                            user.getPhone().equals(userInput) ||
                            user.getUsername().equals(userInput);

            if (matchesIdentifier && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}