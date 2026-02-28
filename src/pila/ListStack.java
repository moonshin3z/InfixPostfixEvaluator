package pila;

import lista.IList;

// pila que usa cualquier implementacion de IList como almacenamiento interno
public class ListStack<T> extends AbstractStack<T> {

    private IList<T> lista;

    // acepta tanto lista simple como doble, por eso usa la interfaz
    public ListStack(IList<T> lista) {
        this.lista = lista;
    }

    @Override
    public void push(T elemento) {
        lista.add(elemento);
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
