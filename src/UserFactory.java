public class UserFactory {

    public static User createUser(
            String role,
            String name,
            String email,
            String phone,
            String username,
            String password
    ) {
        return createUser(role, name, email, phone, username, password, false, 0);
    }

    public static User createUser(
            String role,
            String name,
            String email,
            String phone,
            String username,
            String password,
            boolean hasTrainer,
            int adminId
    ) {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }

        switch (role.trim().toUpperCase()) {
            case "ADMIN":
                return new Admin(name, email, phone, username, password);
            case "MEMBER":
                return new Member(name, email, phone, username, password, hasTrainer);
            case "TRAINER":
                return new Trainer(name, email, phone, username, password);
            case "USER":
                return new User(name, email, phone, username, password);
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }
}
