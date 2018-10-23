package name.valery1707.jcommander.validators.string;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class NotBlankTest extends ValidatorTest<CharSequence, NotBlank> {
	private static final NotBlank VALIDATOR = new NotBlank();

	public NotBlankTest(CharSequence value, boolean isValid) {
		super(value, isValid);
	}

	@Override
	protected NotBlank createValidator() {
		return VALIDATOR;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
			{"", false},
			{" ", false},
			{"  ", false},
			{"1", true},
			{" 1", true},
			{" 1 ", true},
		});
	}
}
