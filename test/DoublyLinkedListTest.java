import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import lista.DoublyLinkedList;

public class DoublyLinkedListTest {

    @Test
    public void testAddAndGet() {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(5);
        list.add(15);

        assertEquals(5, list.get(0));
        assertEquals(15, list.get(1));
    }

    @Test
    public void testRemove() {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(5);
        list.add(15);

        list.remove(0);

        assertEquals(15, list.get(0));
    }
}