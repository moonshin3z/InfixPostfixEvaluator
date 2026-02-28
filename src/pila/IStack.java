package pila;

// interfaz generica que define lo que debe tener cualquier pila
public interface IStack<T> {
    void push(T elemento);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
