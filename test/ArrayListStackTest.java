import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pila.ArrayListStack;
import pila.IStack;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListStackTest {

    private IStack<Integer> pila;

    @BeforeEach
    public void setUp() {
        pila = new ArrayListStack<>();
    }

    @Test
    public void testPushYPeek() {
        pila.push(5);
        assertEquals(5, pila.peek());
    }

    @Test
    public void testPop() {
        pila.push(10);
        pila.push(20);
        assertEquals(20, pila.pop());
        assertEquals(1, pila.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(pila.isEmpty());
        pila.push(1);
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testSize() {
        pila.push(1);
        pila.push(2);
        pila.push(3);
        assertEquals(3, pila.size());
    }

    @Test
    public void testOrdenLIFO() {
        // el ultimo en entrar debe ser el primero en salir
        pila.push(1);
        pila.push(2);
        pila.push(3);
        assertEquals(3, pila.pop());
        assertEquals(2, pila.pop());
        assertEquals(1, pila.pop());
    }

    @Test
    public void testPopEnPilaVacia() {
        assertThrows(RuntimeException.class, () -> pila.pop());
    }

    @Test
    public void testPeekEnPilaVacia() {
        assertThrows(RuntimeException.class, () -> pila.peek());
    }
}
