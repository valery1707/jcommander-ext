package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.ClassRule;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;

public class ExistsTest extends ValidatorTest<Path, Exists> {
	private static final Exists VALIDATOR = new Exists();

	@ClassRule
	public static VirtualFolder TEMP = new VirtualFolder();

	public ExistsTest(Path value, boolean isValid) {
		super(value, isValid);
	}

	@Override
	protected Exists createValidator() {
		return VALIDATOR;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() throws IOException {
		return Arrays.asList(new Object[][]{
			{TEMP.create().build(), false},
			{TEMP.create().exists().build(), true},
		});
	}
}
