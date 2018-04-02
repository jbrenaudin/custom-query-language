public class TestPrint {
	public static void main(String[] args) {
		Context.language = Language.FRENCH;
		
		Expression root = new RootExpression()
							.add(new LogicalExpression("and")
								.add(new ParenthesisExpresion()
									.add(new LogicalExpression("or")
										.add(new ComparisonExpression("=")
											.add(new FieldExpression("delegation"))
											.add(new ValueExpression("DEF"))
										)
										.add(new ComparisonExpression("=")
											.add(new FieldExpression("delegation"))
											.add(new ValueExpression("DGC"))
										)
									)
								)
								.add(new ComparisonExpression(">")
									.add(new FieldExpression("casChannelAD"))
									.add(new ValueExpression("10"))
								)
							);
		
		root.accept(new NaturalLanguage());
	}
}
