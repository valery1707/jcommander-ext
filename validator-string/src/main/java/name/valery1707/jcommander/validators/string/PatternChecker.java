package name.valery1707.jcommander.validators.string;

import name.valery1707.jcommander.validators.ValueChecker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class PatternChecker extends ValueChecker<CharSequence> {
	private final Pattern pattern;
	private final boolean needFullMatches;
	private final boolean reverse;

	PatternChecker(Pattern pattern, boolean needFullMatches, boolean reverse) {
		this.pattern = pattern;
		this.needFullMatches = needFullMatches;
		this.reverse = reverse;
	}

	@Override
	protected boolean check(CharSequence value) {
		Matcher matcher = pattern.matcher(value);
		boolean check = needFullMatches ? matcher.matches() : matcher.find();
		return reverse != check;//reverse ? !check : check
	}

	@Override
	protected String error() {
		String mode = reverse ? "not " : "";
		String type = needFullMatches ? "matches with" : "contains";
		return mode + type + " pattern '" + pattern.pattern() + "'";
	}
}
