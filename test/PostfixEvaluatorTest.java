import org.junit.jupiter.api.Test;
import motor.PostfixEvaluator;
import pila.ArrayListStack;

import static org.junit.jupiter.api.Assertions.*;

public class PostfixEvaluatorTest {

    private double eval(String postfix) {
        return new PostfixEvaluator(new ArrayListStack<>()).evaluar(postfix);
    }

    @Test
    public void testEjemploPrincipal() {
        // (10+20)*9 = 270
        assertEquals(270.0, eval("10 20 + 9 *"));
    }

    @Test
    public void testSuma() {
        assertEquals(7.0, eval("3 4 +"));
    }

    @Test
    public void testResta() {
        assertEquals(6.0, eval("10 4 -"));
    }

    @Test
    public void testMultiplicacion() {
        assertEquals(12.0, eval("3 4 *"));
    }

    @Test
    public void testDivision() {
        assertEquals(2.5, eval("5 2 /"));
    }

    @Test
    public void testDivisionPorCero() {
        assertThrows(ArithmeticException.class, () -> eval("5 0 /"));
    }

    @Test
    public void testExpresionCompleja() {
        // 5 + (1+2)*4 - 3 = 14
        assertEquals(14.0, eval("5 1 2 + 4 * + 3 -"));
    }
}
