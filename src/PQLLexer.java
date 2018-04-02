import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PQLLexer {

	private final static LinkedList<TypeRule> TYPE_RULES = new LinkedList<TypeRule>();
	static {
		TYPE_RULES.addLast(new TypeRule(Type.Comparator, "^(=)"));
		TYPE_RULES.addLast(new TypeRule(Type.LogicalOperator, "^(et|ou)\\s"));
		TYPE_RULES.addLast(new TypeRule(Type.Value, "^'(\\w+)'"));
		TYPE_RULES.addLast(new TypeRule(Type.Identifier, "^(\\w+)"));
	}

	public static List<Token> lex(String pql) {
		LinkedList<Token> tokens = new LinkedList<Token>();
		pql = pql.trim();
		while (!pql.isEmpty()) {
			Matcher matcher = PQLLexer.getMatcher(pql);
			if (matcher != null) {
				tokens.addLast(new Token(getRule(matcher.pattern()).type(), matcher.group(1)));
				pql = pql.replaceFirst(matcher.pattern().pattern(), "").trim();
			} else {
				throw new RuntimeException("Impossible de traiter l'expression : \"" + pql + "\"");
			}
		}
		return tokens;
	}

	private static Matcher getMatcher(String pql) {
		for (TypeRule rules : TYPE_RULES) {
			Matcher matcher = rules.pattern().matcher(pql);
			if (matcher.find()) {
				return matcher;
			}
		}
		return null;
	}
	
	private static TypeRule getRule(Pattern pattern) {
		for (TypeRule rules : TYPE_RULES) {
			if (rules.pattern().equals(pattern)) {
				return rules;
			}
		}
		return null;
	}
}

class Token {

	private Type type;
	private String value;

	public Token(Type type, String value) {
		this.type = type;
		this.value = value;
	}

	public String value() {
		return value;
	}

	public Type Type() {
		return type;
	}
}

class TypeRule {

	private Type type;
	private Pattern pattern;

	public TypeRule(Type type, String regexp) {
		this.type = type;
		this.pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
	}

	public Type type() { return type; }
	public Pattern pattern() { return pattern; }
}

enum Type {
	Comparator,
	LogicalOperator,
	Value,
	Identifier
}
