package name.valery1707.jcommander.validators.string;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

public class PatternMatchedTest extends ValidatorTest<CharSequence, PatternMatched> {
	private final String pattern;

	public PatternMatchedTest(String pattern, CharSequence value, boolean isValid) {
		super(value, isValid);
		this.pattern = pattern;
	}

	@Override
	protected PatternMatched createValidator() {
		return new PatternMatchedSimple(Pattern.compile(pattern));
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		//pattern, value, isValid
		return Arrays.asList(new Object[][]{
			{"\\d+", "", false},
			{"\\d+", "1", true},
			{"\\d+", "1.1", false},
			{"\\d+", " 1", false},
			{"\\d+", " 1 ", false},
			{"\\d+", " 1.1 ", false},
		});
	}

	public static class PatternMatchedSimple extends PatternMatched {
		PatternMatchedSimple(Pattern pattern) {
			super(pattern);
		}
	}
}
