package interpreter;

// We are going to Interpret the Simple Language but Language needs the own parser to parse we are not going to do that

import java.util.HashMap;
import java.util.Map;

// Context Memory of Variables
class Context {
    private final Map<String, Integer> variables = new HashMap<String, Integer>();

    public void set(String name, int value) {
        this.variables.put(name, value);
    }

    public int get(String name) {
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Variable not Defined" + name);
        }
        return variables.get(name);
    }
}

// Expression Interface
interface Expression {
    // Context Added to Share the Variables Among the Expression
    int interpret(Context context);
}

// Terminal Expression

// Number Expression
class NumberExpression implements Expression {
    private final int value;

    public NumberExpression(int value) {
        this.value = value;
    }

    @Override
    public int interpret(Context context) {
        return value;
    }
}

// Variable Expression
class VariableExpression implements Expression {
    private final String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        return context.get(name);
    }
}

// Non-Terminal Expression (Operators) Expression

// AddExpression
class AddExpression implements Expression {
    private final Expression left, right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}

// Statement Interface
interface Statement {
    void execute(Context context);
}

// Assignment Statement
class AssignmentStatement implements Statement {
    private final String variable;
    private final Expression expression;

    public AssignmentStatement(String variable, Expression expression) {
        this.variable = variable;
        this.expression = expression;
    }

    @Override
    public void execute(Context context) {
        int value = expression.interpret(context);
        context.set(variable, value);
    }
}

// Print Statement
class PrintStatement implements Statement {
    private final Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void execute(Context context) {
        System.out.println(expression.interpret(context));
    }
}


public class InterpreterPattern {
    public static void main(String[] args) {
        // Declare the Context
        Context context = new Context();

        // Building our own language Expression
        Statement[] statements = {
                // X=2
                new AssignmentStatement("X", new NumberExpression(2)),
                // Y=3
                new AssignmentStatement("Y", new NumberExpression(3)),
                // Z=X+Y
                new AssignmentStatement("Z", new AddExpression(
                        new VariableExpression("X"),
                        new VariableExpression("Y")
                )),
                // PRINT Z
                new PrintStatement(new VariableExpression("Z"))
        };

        // Execute all the Statement
        for (Statement st : statements) {
            st.execute(context);
        }
    }
}
