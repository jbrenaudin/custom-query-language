public class ComparisonExpression extends Expression {

	public ComparisonExpression(String comparison) {
		this.comparison = comparison;
	}

	public String comparison() {
		return comparison;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	private String comparison;
}
