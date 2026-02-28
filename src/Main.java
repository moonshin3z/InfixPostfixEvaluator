import pila.ArrayListStack;
import pila.IStack;
import pila.VectorStack;
import motor.InfixToPostfix;
import motor.PostfixEvaluator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/*
 * Diagrama UML simplificado:
 *
 *   IStack<T>  <-- (interfaz)
 *       ^
 *   AbstractStack<T>  <-- (clase abstracta)
 *       ^         ^         ^
 * ArrayListStack  VectorStack  ListStack --> IList<T>
 *
 *   InfixToPostfix  usa  IStack<String>
 *   PostfixEvaluator usa IStack<Double>
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Evaluador de Expresiones Infix/Postfix ===\n");

        // leer la expresion del archivo datos.txt (debe estar en la raiz del proyecto)
        String expresion;
        try (BufferedReader reader = new BufferedReader(new FileReader("datos.txt"))) {
            expresion = reader.readLine();
            if (expresion == null || expresion.trim().isEmpty()) {
                System.out.println("El archivo datos.txt esta vacio.");
                return;
            }
            expresion = expresion.trim();
            System.out.println("Expresion leida: " + expresion);
        } catch (Exception e) {
            System.out.println("No se pudo leer datos.txt: " + e.getMessage());
            return;
        }

        // menu para elegir implementacion de pila
        System.out.println("\nElige la implementacion de pila:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista personalizada (requiere el trabajo de la Persona 2)");
        System.out.print("Opcion: ");

        int opcion;
        try {
            opcion = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida, usando ArrayList por defecto.");
            opcion = 1;
        }

        IStack<String> pilaConversion;
        IStack<Double> pilaEvaluacion;

        switch (opcion) {
            case 2:
                pilaConversion = new VectorStack<>();
                pilaEvaluacion = new VectorStack<>();
                System.out.println("Usando: VectorStack");
                break;
            case 3:
               
                System.out.println("Esta opcion no esta disponible todavia.");
                System.out.println("Usando ArrayList como reemplazo por ahora.");
                pilaConversion = new ArrayListStack<>();
                pilaEvaluacion = new ArrayListStack<>();
                break;
            default:
                pilaConversion = new ArrayListStack<>();
                pilaEvaluacion = new ArrayListStack<>();
                System.out.println("Usando: ArrayListStack");
        }

        // hacer la conversion infix -> postfix
        InfixToPostfix conversor = new InfixToPostfix(pilaConversion);
        String postfix = conversor.convertir(expresion);
        System.out.println("\nNotacion Postfix: " + postfix);

        // evaluar la expresion postfix
        PostfixEvaluator evaluador = new PostfixEvaluator(pilaEvaluacion);
        double resultado = evaluador.evaluar(postfix);

        // mostrar sin decimales si el resultado es numero entero
        if (resultado == Math.floor(resultado) && !Double.isInfinite(resultado)) {
            System.out.println("Resultado: " + (long) resultado);
        } else {
            System.out.println("Resultado: " + resultado);
        }

        scanner.close();
    }
}
