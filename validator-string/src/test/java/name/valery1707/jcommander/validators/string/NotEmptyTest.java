package name.valery1707.jcommander.validators.string;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class NotEmptyTest extends ValidatorTest<CharSequence, NotEmpty> {
	private static final NotEmpty VALIDATOR = new NotEmpty();

	public NotEmptyTest(CharSequence value, boolean isValid) {
		super(value, isValid);
	}

	@Override
	protected NotEmpty createValidator() {
		return VALIDATOR;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
			{"", false},
			{" ", true},
			{"1", true},
			{" 1", true},
			{" 1 ", true},
		});
	}
}
