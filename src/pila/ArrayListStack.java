package pila;

import java.util.ArrayList;

// implementacion de la pila usando ArrayList de Java
public class ArrayListStack<T> extends AbstractStack<T> {

    private ArrayList<T> lista;

    public ArrayListStack() {
        lista = new ArrayList<>();
    }

    @Override
    public void push(T elemento) {
        lista.add(elemento); // el tope es el ultimo elemento
    }

    @Override
    public T pop() {
        verificarNoVacia();
        return lista.remove(lista.size() - 1);
    }

    @Override
    public T peek() {
        verificarNoVacia();
        return lista.get(lista.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public int size() {
        return lista.size();
    }
}
