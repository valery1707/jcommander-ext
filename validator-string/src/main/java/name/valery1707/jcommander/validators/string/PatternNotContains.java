package name.valery1707.jcommander.validators.string;

import java.util.regex.Pattern;

@SuppressWarnings("WeakerAccess")
public abstract class PatternNotContains extends PatternChecker {

	@SuppressWarnings("WeakerAccess")
	protected PatternNotContains(Pattern pattern) {
		super(pattern, false, true);
	}
}
