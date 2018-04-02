public class FieldExpression extends Expression {

	public FieldExpression(String field) {
		this.field = field;
	}

	public String field() {
		return field;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	private String field;
}
