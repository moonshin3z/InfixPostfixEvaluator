package pila;

// clase abstracta con lo comun para todas las implementaciones de pila
public abstract class AbstractStack<T> implements IStack<T> {

    // en vez de repetir este chequeo en cada clase, lo ponemos aqui
    protected void verificarNoVacia() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[size=" + size() + "]";
    }
}
