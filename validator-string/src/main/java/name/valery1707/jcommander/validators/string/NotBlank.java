package name.valery1707.jcommander.validators.string;

import name.valery1707.jcommander.validators.ValueChecker;

public class NotBlank extends ValueChecker<CharSequence> {
	@Override
	protected boolean check(CharSequence value) {
		int len;
		if (value == null || (len = value.length()) == 0) {
			return false;
		}
		for (int i = 0; i < len; i++) {
			if (!Character.isWhitespace(value.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected String error() {
		return "be not blank string";
	}
}
