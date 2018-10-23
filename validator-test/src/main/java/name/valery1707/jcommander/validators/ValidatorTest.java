package name.valery1707.jcommander.validators;

import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;
import org.assertj.core.description.Description;
import org.assertj.core.description.TextDescription;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public abstract class ValidatorTest<T, V extends IValueValidator<T>> {
	private V validator;

	protected ValidatorTest(T value, boolean isValid) {
		this.value = value;
		this.isValid = isValid;
	}

	@Before
	public void setUp() throws Exception {
		validator = createValidator();
	}

	protected abstract V createValidator();

	private final T value;
	private final boolean isValid;

	@Test
	public void checkData() throws Exception {
		Description description = new TextDescription("Validator must %s value '%s'", (isValid ? "accept" : "decline"), String.valueOf(value));
		try {
			validator.validate("-check", value);
			assertThat(isValid)
					.describedAs(description)
					.isTrue();
		} catch (Throwable t) {
			if (isValid) {
				assertThat(t)
						.describedAs(description)
						.isNull();
			} else {
				assertThat(t)
						.describedAs(description)
						.isInstanceOf(ParameterException.class);
			}
		}
	}
}
