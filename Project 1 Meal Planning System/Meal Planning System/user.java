public class User {
    private String username;
    private UserType type;

    public User(String username, UserType type) {
        this.username = username;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public UserType getType() {
        return type;
    }
}

enum UserType {
    DIETITIAN, CUSTOMER
}
