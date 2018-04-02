public interface Visitor {
	void visit(RootExpression expression);

	void visit(ComparisonExpression expression);

	void visit(LogicalExpression expression);

	void visit(FieldExpression expression);

	void visit(ValueExpression expression);

	void visit(ParenthesisExpresion expression);
}
