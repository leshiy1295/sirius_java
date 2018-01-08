package forTests;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RegistrationTest {
    final private static AuthService authService = mock(AuthService.class);

    @Test
    public void testRegisterNewUser() {
        final TestAuthService authService = new TestAuthService();
        new SimpleAuthForm(authService).register(new User());
        Assert.assertTrue(authService.wasExecute());
    }

    @Test
    public void testRegisterNewUserWithSpy() {
        final AuthService authService = new SimpleAuthService();
        final AuthService spyAuthService = spy(authService); // привязка spy

        // замена метода реального объекта через объект spy
        doNothing().when(spyAuthService).init();

        new SimpleAuthForm(spyAuthService).register(new User());

        // проверка количества вызовов тестируемого метода
        verify(spyAuthService, times(1)).init();
    }

    @Test
    public void testFailedRegisterNewUser() {
        when(authService.registerNewUser(new User())).thenReturn(false);

        Assert.assertFalse(new SimpleAuthForm(authService).register(new User()));
    }
}
