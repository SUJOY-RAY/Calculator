# Java Expression Calculator

A modular expression calculator built with **Java 21**. It supports a graphical user interface using Java Swing and evaluates mathematical expressions through separate parsing and calculation components.

## Features

- **Graphical User Interface:** Enter expressions and view results in a Swing-based interface.
- **Arithmetic Operations:** Supports addition (`+`), subtraction (`-`), multiplication (`*`), and division (`/`).
- **Parentheses Support:** Evaluates expressions containing nested parentheses.
- **Whitespace Handling:** Ignores spaces between numbers and operators.
- **Input Validation:** Checks parentheses and identifies invalid expressions.
- **Modular Architecture:** Separates parsing, validation, evaluation, and calculation logic.
- **Operator Validation:** Reports unsupported operators.
- **Division-by-Zero Handling:** Detects division by zero.

## Project Structure

```text
Calculator/
├── src/
│   ├── App.java
│   ├── CalculatorUI.java
│   ├── Calculator.java
│   ├── Evaluator.java
│   ├── ParseNumber.java
│   ├── ParseOperator.java
│   ├── SkipSpaces.java
│   └── CheckParenthesis.java
├── bin/
└── README.md
```

> The structure above assumes your Java source files are stored in `src/`. Adjust it if your project uses a different layout.

## Technologies Used

- Java 21
- Java Swing
- Object-oriented programming
- Recursive expression parsing

## Getting Started

### Prerequisites

Install the Java Development Kit (JDK) 21 or a compatible version and ensure `java` and `javac` are available in your terminal.

Check your installation:

```bash
java -version
javac -version
```

### Compilation

From the project root, compile all Java files:

```powershell
javac -d bin src\*.java
```

### Running the Application

```powershell
java -cp bin App
```

The calculator GUI should open.

If your Java files are directly in the project root instead of `src/`, use:

```powershell
javac -d bin *.java
java -cp bin App
```

## Example Expressions

| Expression | Result |
|---|---:|
| `3 + 2` | `5` |
| `8 - 3` | `5` |
| `4 * 5` | `20` |
| `12 / 3` | `4` |
| `(2 + 3) * 4` | `20` |

**Note:** The current evaluator processes operators from left to right unless parentheses explicitly group an expression. Standard operator precedence is not applied automatically. For example, `2 + 3 * 4` evaluates as `(2 + 3) * 4`, producing `20`.

## Architecture

| Component | Responsibility |
|---|---|
| `App` | Starts the application |
| `CalculatorUI` | Provides the graphical interface |
| `Calculator` | Performs arithmetic operations |
| `Evaluator` | Coordinates expression evaluation |
| `ParseNumber` | Parses integers and parenthesized expressions |
| `ParseOperator` | Reads operators from expressions |
| `SkipSpaces` | Skips whitespace |
| `CheckParenthesis` | Validates matching parentheses |

## Current Limitations

- Supports integer operands only.
- Does not yet support decimal numbers or unary negative numbers.
- Uses left-to-right evaluation rather than conventional operator precedence.
- Supports only the arithmetic operators implemented in `Calculator`.

## Future Improvements

- Implement standard arithmetic precedence.
- Support decimal numbers and negative operands.
- Add exponentiation and modulo operations.
- Improve error messages for malformed expressions.
- Add keyboard shortcuts and a more polished interface.
- Create automated unit tests for parsing and evaluation.