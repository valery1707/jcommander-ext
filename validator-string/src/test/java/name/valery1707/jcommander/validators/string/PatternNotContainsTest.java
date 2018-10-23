package name.valery1707.jcommander.validators.string;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

public class PatternNotContainsTest extends ValidatorTest<CharSequence, PatternNotContains> {
	private final String pattern;

	public PatternNotContainsTest(String pattern, CharSequence value, boolean isValid) {
		super(value, isValid);
		this.pattern = pattern;
	}

	@Override
	protected PatternNotContains createValidator() {
		return new PatternNotContainsSimple(Pattern.compile(pattern));
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		//pattern, value, isValid
		return Arrays.asList(new Object[][]{
			{"\\d+", "", true},
			{"\\d+", "1", false},
			{"\\d+", "1.1", false},
			{"\\d+", " 1", false},
			{"\\d+", " 1 ", false},
			{"\\d+", " 1.1 ", false},
		});
	}

	public static class PatternNotContainsSimple extends PatternNotContains {
		PatternNotContainsSimple(Pattern pattern) {
			super(pattern);
		}
	}
}
