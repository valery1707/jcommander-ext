package name.valery1707.jcommander.validators.string;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

public class PatternContainsTest extends ValidatorTest<CharSequence, PatternContains> {
	private final String pattern;

	public PatternContainsTest(String pattern, CharSequence value, boolean isValid) {
		super(value, isValid);
		this.pattern = pattern;
	}

	@Override
	protected PatternContains createValidator() {
		return new PatternContainsSimple(Pattern.compile(pattern));
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		//pattern, value, isValid
		return Arrays.asList(new Object[][]{
			{"\\d+", "", false},
			{"\\d+", "1", true},
			{"\\d+", "1.1", true},
			{"\\d+", " 1", true},
			{"\\d+", " 1 ", true},
			{"\\d+", " 1.1 ", true},
		});
	}

	public static class PatternContainsSimple extends PatternContains {
		PatternContainsSimple(Pattern pattern) {
			super(pattern);
		}
	}
}
