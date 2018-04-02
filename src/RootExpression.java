public class RootExpression extends Expression {

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
