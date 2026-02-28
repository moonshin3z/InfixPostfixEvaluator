import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import lista.SinglyLinkedList;

public class SinglyLinkedListTest {

    @Test
    public void testAddAndGet() {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.add(10);
        list.add(20);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    public void testRemove() {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.add(10);
        list.add(20);

        list.remove(0);

        assertEquals(20, list.get(0));
    }
}