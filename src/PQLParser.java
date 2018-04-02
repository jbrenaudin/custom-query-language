import java.util.Iterator;
import java.util.Stack;

public class PQLParser {

	public static Expression parse(String pql) {
		return new PQLParser(pql).createExpression();
	}
	
	private Expression createExpression() {
		return createExpression(PQLLexer.lex(pql).iterator());
	}

	private Expression createExpression(Iterator<Token> tokens) {
		Stack<Expression> expressions = new Stack<Expression>();
		while (tokens.hasNext()) {
			Token token = tokens.next();
			if (Type.Identifier == token.Type()) {
				expressions.push(new Column(token.value()));
			}
			if (Type.Comparator == token.Type()) {
				expressions.push(new Equals((Column) expressions.pop(), (Value) this.createExpression(tokens)));
			}
			if (Type.LogicalOperator == token.Type()) {
				expressions.push(new And(expressions.pop(), this.createExpression(tokens)));
			}
			if (Type.Value == token.Type()) {
				return new Value(token.value());
			}
		}
		return expressions.pop();
	}

	private PQLParser(String pql) {
		this.pql = pql;
	}

	private String pql;
}

class Column extends Expression {
	public Column(String name) {
		this.name = name;
	}

	private String name;
}

class Value extends Expression {
	public Value(String value) {
		this.value = value;
	}

	private String value;
}

class Equals extends Expression {
	public Equals(Column column, Value value) {
		this.column = column;
		this.value = value;
	}

	private Column column;
	private Value value;
}

class And extends Expression {
	public And(Expression expression1, Expression expression2) {
		this.expression1 = expression1;
		this.expression2 = expression2;
	}

	private Expression expression1;
	private Expression expression2;
}

class Or extends Expression {
	public Or(Expression expression1, Expression expression2) {
		this.expression1 = expression1;
		this.expression2 = expression2;
	}

	private Expression expression1;
	private Expression expression2;
}

abstract class Expression {
	protected PQLLexer lexer;
}