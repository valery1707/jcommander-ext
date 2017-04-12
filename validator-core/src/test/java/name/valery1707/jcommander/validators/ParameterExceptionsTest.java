package name.valery1707.jcommander.validators;

import com.beust.jcommander.ParameterException;
import org.junit.Test;

public class ParameterExceptionsTest {
	@Test(expected = IllegalStateException.class)
	public void createDirectly() throws Exception {
		new ParameterExceptions();
	}

	@Test(expected = ParameterException.class)
	public void shouldThrow() throws Exception {
		ParameterExceptions.invalidParameter("name", "desc");
	}
}
