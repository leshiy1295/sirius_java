package forTests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RuleTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void ensureExceptionWithRule() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Oops");
        throw new NullPointerException("Oops");
    }
}
