import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pila.VectorStack;
import pila.IStack;

import static org.junit.jupiter.api.Assertions.*;

public class VectorStackTest {

    private IStack<String> pila;

    @BeforeEach
    public void setUp() {
        pila = new VectorStack<>();
    }

    @Test
    public void testPushYPeek() {
        pila.push("hola");
        assertEquals("hola", pila.peek());
    }

    @Test
    public void testPop() {
        pila.push("a");
        pila.push("b");
        assertEquals("b", pila.pop());
        assertEquals(1, pila.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(pila.isEmpty());
        pila.push("algo");
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testOrdenLIFO() {
        pila.push("primero");
        pila.push("segundo");
        pila.push("tercero");
        assertEquals("tercero", pila.pop());
        assertEquals("segundo", pila.pop());
    }

    @Test
    public void testPopEnPilaVacia() {
        assertThrows(RuntimeException.class, () -> pila.pop());
    }
}
