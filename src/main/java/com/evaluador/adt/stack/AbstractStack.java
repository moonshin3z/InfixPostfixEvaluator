package com.evaluador.adt.stack;

// clase abstracta que implementa comportamiento comun para todas las pilas
// las subclases solo se preocupan por su estructura interna
public abstract class AbstractStack<T> implements IStack<T> {

    // metodo compartido para validar que la pila no este vacia antes de hacer pop/peek
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
