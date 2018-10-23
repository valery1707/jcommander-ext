package name.valery1707.jcommander.validators.string;

import java.util.regex.Pattern;

@SuppressWarnings("WeakerAccess")
public abstract class PatternMatched extends PatternChecker {

	@SuppressWarnings("WeakerAccess")
	protected PatternMatched(Pattern pattern) {
		super(pattern, true, false);
	}
}
