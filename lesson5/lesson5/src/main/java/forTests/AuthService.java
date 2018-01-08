package forTests;

public interface AuthService {
    void init();

    boolean registerNewUser(User user);

    int getRegisteredUsersCount();
}
