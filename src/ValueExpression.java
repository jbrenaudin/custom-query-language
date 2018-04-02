public class ValueExpression extends Expression {

	public ValueExpression(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	private String value;
}
