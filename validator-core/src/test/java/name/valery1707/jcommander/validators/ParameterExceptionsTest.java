package name.valery1707.jcommander.validators;

import com.beust.jcommander.ParameterException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParameterExceptionsTest {
	@Test(expected = IllegalStateException.class)
	public void createDirectly() throws Exception {
		new ParameterExceptions();
	}

	@Test
	public void shouldThrow() throws Exception {
		assertThat(ParameterExceptions.invalidParameter("name", "desc"))
				.isInstanceOf(ParameterException.class)
				.hasMessageContaining("'name'")
				.hasMessageEndingWith("desc" + ".")
		;
	}
}