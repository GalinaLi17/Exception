package ExceptionPassword;

public class User {
    protected String login;
    protected String password;

    Role role;

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }


}
