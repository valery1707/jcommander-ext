package name.valery1707.jcommander.validators;

import name.valery1707.jcommander.validators.ValueCheckerTest.BooleanChecker;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class ValueCheckerTest extends ValidatorTest<Boolean, BooleanChecker> {
	public ValueCheckerTest(Boolean value, boolean isValid) {
		super(value, isValid);
	}

	@Override
	protected BooleanChecker createValidator() {
		return new BooleanChecker();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{false, false},
				{true, true},
		});
	}

	public static class BooleanChecker extends ValueChecker<Boolean> {
		@Override
		protected boolean check(Boolean value) {
			return value;
		}

		@Override
		protected String error() {
			return "boolean";
		}
	}
}
