package name.valery1707.jcommander.validators.string;

import name.valery1707.jcommander.validators.ValueChecker;

public class NotEmpty extends ValueChecker<CharSequence> {
	@Override
	protected boolean check(CharSequence value) {
		return value.length() > 0;
	}

	@Override
	protected String error() {
		return "be not empty string";
	}
}
