
public class ParenthesisExpresion extends Expression {
	
	@Override
	void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
