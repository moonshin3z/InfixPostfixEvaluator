package motor;

import pila.IStack;

// evalua una expresion ya en notacion postfix y devuelve el resultado
public class PostfixEvaluator {

    private IStack<Double> pila;

    public PostfixEvaluator(IStack<Double> pila) {
        this.pila = pila;
    }

    public double evaluar(String expresionPostfix) {
        String[] tokens = expresionPostfix.trim().split("\\s+");

        for (String token : tokens) {
            if (token.matches("\\d+(\\.\\d+)?")) {
                pila.push(Double.parseDouble(token));
            } else {
                // operador: sacamos dos numeros, operamos y metemos el resultado
                if (pila.size() < 2) {
                    throw new RuntimeException("La expresion postfix no es valida");
                }
                double b = pila.pop();
                double a = pila.pop();
                pila.push(operar(a, b, token));
            }
        }

        if (pila.size() != 1) {
            throw new RuntimeException("La expresion no es valida");
        }
        return pila.pop();
    }

    private double operar(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Division por cero");
                return a / b;
            case "^": return Math.pow(a, b);
            default:  throw new IllegalArgumentException("Operador no reconocido: " + op);
        }
    }
}
