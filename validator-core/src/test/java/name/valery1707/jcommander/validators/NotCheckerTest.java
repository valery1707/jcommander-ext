package name.valery1707.jcommander.validators;

import name.valery1707.jcommander.validators.ValueCheckerTest.BooleanChecker;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class NotCheckerTest extends ValidatorTest<Boolean, NotChecker<Boolean>> {
	public NotCheckerTest(Boolean value, boolean isValid) {
		super(value, isValid);
	}

	@Override
	protected NotChecker<Boolean> createValidator() {
		return new NotCheckerSimple();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{false, true},
				{true, false},
		});
	}

	public static class NotCheckerSimple extends NotChecker<Boolean> {
		public NotCheckerSimple() {
			super(new BooleanChecker());
		}
	}
}
