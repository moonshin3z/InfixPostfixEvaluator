package motor;

import pila.IStack;
import java.util.ArrayList;
import java.util.List;

// convierte una expresion infix a postfix
// usa el algoritmo Shunting-Yard que vimos en clase de estructuras
public class InfixToPostfix {

    private IStack<String> pila;

    public InfixToPostfix(IStack<String> pila) {
        this.pila = pila;
    }

    // regresa un numero segun la prioridad del operador
    private int precedencia(String op) {
        switch (op) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
            case "^":           return 3;
            default:            return -1;
        }
    }

    private boolean esOperador(String token) {
        return "+-*/^".contains(token) && token.length() == 1;
    }

    // separa la expresion en tokens: numeros y simbolos por separado
    private List<String> tokenizar(String expresion) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        while (i < expresion.length()) {
            char c = expresion.charAt(i);
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }
            if (Character.isDigit(c)) {
                // leer el numero completo (puede tener varios digitos como 123)
                StringBuilder num = new StringBuilder();
                while (i < expresion.length() && Character.isDigit(expresion.charAt(i))) {
                    num.append(expresion.charAt(i));
                    i++;
                }
                tokens.add(num.toString());
            } else {
                tokens.add(String.valueOf(c));
                i++;
            }
        }
        return tokens;
    }

    public String convertir(String expresionInfix) {
        List<String> tokens = tokenizar(expresionInfix);
        StringBuilder salida = new StringBuilder();

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                // numero: va directo a la salida
                salida.append(token).append(" ");

            } else if (esOperador(token)) {
                // sacar de la pila los operadores de mayor o igual precedencia
                while (!pila.isEmpty() && esOperador(pila.peek())
                        && precedencia(pila.peek()) >= precedencia(token)) {
                    salida.append(pila.pop()).append(" ");
                }
                pila.push(token);

            } else if (token.equals("(")) {
                pila.push(token);

            } else if (token.equals(")")) {
                // sacar hasta encontrar el parentesis de apertura
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    salida.append(pila.pop()).append(" ");
                }
                if (!pila.isEmpty()) {
                    pila.pop(); // quitamos el "(" que quedo
                }
            }
        }

        // sacar lo que quede en la pila al terminar
        while (!pila.isEmpty()) {
            salida.append(pila.pop()).append(" ");
        }

        return salida.toString().trim();
    }
}
