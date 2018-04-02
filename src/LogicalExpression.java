public class LogicalExpression extends Expression {

	public LogicalExpression(String logical) {
		this.logical = logical;
	}

	public String logicial() {
		return logical;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	private String logical;
}
