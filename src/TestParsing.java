public class TestParsing {
	public static void main(String[] args) {
		PQLExpression expression = PQLParser.parse("departement = 'DAF' ou departement = 'SIE'");
	}
}
