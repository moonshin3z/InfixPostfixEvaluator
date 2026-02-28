# Evaluador de Expresiones Infix/Postfix

Programa en Java que lee una expresión matemática en notación infix desde un archivo, la convierte a notación postfix y la evalúa.


## Estructura del proyecto

```
InfixPostfixEvaluator/
├── datos.txt              ← expresión de entrada
├── src/
│   ├── pila/
│   │   ├── IStack.java          ← interfaz
│   │   ├── AbstractStack.java   ← clase abstracta
│   │   ├── ArrayListStack.java  ← implementación con ArrayList
│   │   ├── VectorStack.java     ← implementación con Vector
│   │   └── ListStack.java       ← implementación con lista personalizada
│   ├── lista/
│   │   └── IList.java           ← interfaz para las listas
│   ├── motor/
│   │   ├── InfixToPostfix.java  ← algoritmo Shunting-Yard
│   │   └── PostfixEvaluator.java
│   └── Main.java
└── test/
    ├── ArrayListStackTest.java
    ├── VectorStackTest.java
    ├── InfixToPostfixTest.java
    └── PostfixEvaluatorTest.java
```

---

## Cómo correrlo en IntelliJ IDEA

1. Abrir IntelliJ → **File > Open** → seleccionar la carpeta del proyecto
2. Clic derecho en `src/` → **Mark Directory as > Sources Root**
3. Clic derecho en `test/` → **Mark Directory as > Test Sources Root**
4. Para los tests: **File > Project Structure > Libraries > + > From Maven** → buscar `org.junit.jupiter:junit-jupiter:5.10.0`
5. Editar `datos.txt` con la expresión que quieras evaluar
6. Correr `Main.java`

---

## División del trabajo

| Parte | Descripción |
|-------|-------------|
| Iván Roblero | ADT Pila (interfaz, clase abstracta, ArrayList, Vector), motor de conversión y evaluación, Main, tests de pila |
| Daniel Hernández | ADT Lista (lista simple y doble enlazada), tests de lista, documentación de diseño |

---

## Operadores soportados

| Operador | Descripción |
|----------|-------------|
| `+` | Suma |
| `-` | Resta |
| `*` | Multiplicación |
| `/` | División |
| `^` | Potencia |
