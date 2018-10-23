package name.valery1707.jcommander.validators.string;

import java.util.regex.Pattern;

@SuppressWarnings("WeakerAccess")
public abstract class PatternNotMatched extends PatternChecker {

	@SuppressWarnings("WeakerAccess")
	protected PatternNotMatched(Pattern pattern) {
		super(pattern, true, true);
	}
}
