package com.evaluador.adt.stack;

// interfaz que define las operaciones basicas de una pila generica
public interface IStack<T> {
    void push(T elemento);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
