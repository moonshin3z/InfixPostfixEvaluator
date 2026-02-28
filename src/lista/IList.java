package lista;

// interfaz de la lista, solo los metodos que la pila necesita
public interface IList<T> {
    void add(T elemento);
    T get(int indice);
    T remove(int indice);
    int size();
    boolean isEmpty();
}
