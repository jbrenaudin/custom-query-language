public class TestPrint {
	public static void main(String[] args) {
		Context.language = Language.FRENCH;
		
		Expression root = new RootExpression()
							.add(new LogicalExpression("and")
								.add(new ParenthesisExpresion()
									.add(new LogicalExpression("or")
										.add(new ComparisonExpression("=")
											.add(new FieldExpression("departement"))
											.add(new ValueExpression("DAF"))
										)
										.add(new ComparisonExpression("=")
											.add(new FieldExpression("departement"))
											.add(new ValueExpression("SIE"))
										)
									)
								)
								.add(new ComparisonExpression(">")
									.add(new FieldExpression("depense"))
									.add(new ValueExpression("10"))
								)
							);
		
		root.accept(new NaturalLanguage());
	}
}
