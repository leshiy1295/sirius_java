package forTests;

public class SimpleAuthService implements AuthService {
    private int registeredCount = 0;

    public void init() {

    }

    public boolean registerNewUser(User user) {
        init();
        registeredCount++;
        return true;
    }

    public int getRegisteredUsersCount() {
        return registeredCount;
    }
}
