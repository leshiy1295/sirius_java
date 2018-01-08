package forTests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.internal.matchers.Null;

public class RuleTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void ensureExceptionWithRule() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Oops");
        throw new NullPointerException("Oops");
    }

    @Test(expected = NullPointerException.class)
    public void ensureException() {
        throw new NullPointerException("Oops");
    }
}
