import java.util.LinkedList;
import java.util.List;

public abstract class Expression {

	protected Expression() {
		expressions = new LinkedList<Expression>();
	}

	public Expression add(Expression expression) {
		expressions.addLast(expression);
		return this;
	}

	public List<Expression> children() {
		return expressions;
	}

	abstract void accept(Visitor visitor);
	
	private LinkedList<Expression> expressions;
}
