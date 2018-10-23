package name.valery1707.jcommander.validators.string;

import java.util.regex.Pattern;

@SuppressWarnings("WeakerAccess")
public abstract class PatternContains extends PatternChecker {

	@SuppressWarnings("WeakerAccess")
	protected PatternContains(Pattern pattern) {
		super(pattern, false, false);
	}
}
