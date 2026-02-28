package pila;

import java.util.Vector;

// implementacion de la pila usando Vector
// Vector es parecido a ArrayList pero esta sincronizado (thread-safe)
public class VectorStack<T> extends AbstractStack<T> {

    private Vector<T> vector;

    public VectorStack() {
        vector = new Vector<>();
    }

    @Override
    public void push(T elemento) {
        vector.add(elemento);
    }

    @Override
    public T pop() {
        verificarNoVacia();
        return vector.remove(vector.size() - 1);
    }

    @Override
    public T peek() {
        verificarNoVacia();
        return vector.get(vector.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    @Override
    public int size() {
        return vector.size();
    }
}
