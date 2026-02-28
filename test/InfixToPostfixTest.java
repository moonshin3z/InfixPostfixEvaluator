import org.junit.jupiter.api.Test;
import motor.InfixToPostfix;
import pila.ArrayListStack;

import static org.junit.jupiter.api.Assertions.*;

public class InfixToPostfixTest {

    // helper para no repetir la creacion del conversor en cada test
    private String conv(String expresion) {
        return new InfixToPostfix(new ArrayListStack<>()).convertir(expresion);
    }

    @Test
    public void testEjemploPrincipal() {
        // el ejemplo del enunciado del proyecto
        assertEquals("10 20 + 9 *", conv("(10+20)*9"));
    }

    @Test
    public void testSuma() {
        assertEquals("3 4 +", conv("3+4"));
    }

    @Test
    public void testPrecedencia() {
        // * tiene mas precedencia que +, entonces el + sale despues
        assertEquals("3 4 2 * +", conv("3+4*2"));
    }

    @Test
    public void testParentesisCambianPrecedencia() {
        assertEquals("2 3 + 4 *", conv("(2+3)*4"));
    }

    @Test
    public void testResta() {
        assertEquals("10 3 -", conv("10-3"));
    }

    @Test
    public void testExpresionLarga() {
        // 5 + (1+2)*4 - 3
        assertEquals("5 1 2 + 4 * + 3 -", conv("5+(1+2)*4-3"));
    }
}
