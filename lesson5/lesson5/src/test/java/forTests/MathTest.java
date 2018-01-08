package forTests;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathTest {
    @Test
    public void testTwoAndThree() {
        // Установка
        Math math = new Math(2, 2);

        // Действие
        int res = math.getSum();

        // Проверка
        assertEquals(5, res);
    }
}