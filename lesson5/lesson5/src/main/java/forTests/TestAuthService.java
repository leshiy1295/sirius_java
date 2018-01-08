package forTests;

public class TestAuthService implements AuthService {
    private boolean wasExecute;

    public boolean registerNewUser(User user) {
        init();
        return true;
    }

    public void init() {
        wasExecute = true;
    }

    public int getRegisteredUsersCount() {
        return 1;
    }

    public boolean wasExecute() {
        return wasExecute;
    }
}
