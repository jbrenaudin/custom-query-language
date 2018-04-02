public class TestParsing {
	public static void main(String[] args) {
		PQLExpression expression = PQLParser.parse("delegation = 'DAF' ou delegation = 'SIE'");
	}
}
