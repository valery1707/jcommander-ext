package name.valery1707.jcommander.validators.string;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

public class PatternNotMatchedTest extends ValidatorTest<CharSequence, PatternNotMatched> {
	private final String pattern;

	public PatternNotMatchedTest(String pattern, CharSequence value, boolean isValid) {
		super(value, isValid);
		this.pattern = pattern;
	}

	@Override
	protected PatternNotMatched createValidator() {
		return new PatternNotMatchedSimple(Pattern.compile(pattern));
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		//pattern, value, isValid
		return Arrays.asList(new Object[][]{
			{"\\d+", "", true},
			{"\\d+", "1", false},
			{"\\d+", "1.1", true},
			{"\\d+", " 1", true},
			{"\\d+", " 1 ", true},
			{"\\d+", " 1.1 ", true},
		});
	}

	public static class PatternNotMatchedSimple extends PatternNotMatched {
		PatternNotMatchedSimple(Pattern pattern) {
			super(pattern);
		}
	}
}
