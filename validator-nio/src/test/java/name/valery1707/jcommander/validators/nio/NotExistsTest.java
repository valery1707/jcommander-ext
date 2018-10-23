package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.ClassRule;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;

public class NotExistsTest extends ValidatorTest<Path, NotExists> {
	private static final NotExists VALIDATOR = new NotExists();

	@ClassRule
	public static VirtualFolder TEMP = new VirtualFolder();

	public NotExistsTest(Path value, boolean isValid) {
		super(value, isValid);
	}

	@Override
	protected NotExists createValidator() {
		return VALIDATOR;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() throws IOException {
		return Arrays.asList(new Object[][]{
			{TEMP.create().build(), true},
			{TEMP.create().exists().build(), false},
		});
	}
}
