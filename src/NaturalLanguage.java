public class NaturalLanguage implements Visitor {

	@Override
	public void visit(RootExpression expression) {
		for (Expression child : expression.children()) {
			child.accept(this);
		}
	}

	@Override
	public void visit(ParenthesisExpresion expression) {
		System.out.print("( ");
		expression.children().get(0).accept(this);
		System.out.print(" )");
	}

	@Override
	public void visit(ComparisonExpression expression) {
		expression.children().get(0).accept(this);
		System.out.print(" " + expression.comparison() + " ");
		expression.children().get(1).accept(this);
	}

	@Override
	public void visit(LogicalExpression expression) {
		expression.children().get(0).accept(this);
		System.out.print(" " + expression.logicial() + " ");
		expression.children().get(1).accept(this);
	}

	@Override
	public void visit(FieldExpression expression) {
		System.out.print(expression.field());
	}

	@Override
	public void visit(ValueExpression expression) {
		System.out.print("'" + expression.value() + "'");
	}
}
