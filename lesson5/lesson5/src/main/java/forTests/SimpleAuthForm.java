package forTests;

public class SimpleAuthForm implements AuthForm {
    private AuthService authService;

    SimpleAuthForm(AuthService authService) {
        this.authService = authService;
    }

    public boolean register(User user) {
        return authService.registerNewUser(user);
    }
}
