package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.ClassRule;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;

public class ExistsDirectoryTest extends ValidatorTest<Path, ExistsDirectory> {
	private static final ExistsDirectory VALIDATOR = new ExistsDirectory();

	@ClassRule
	public static VirtualFolder TEMP = new VirtualFolder();

	public ExistsDirectoryTest(Path value, boolean isValid) {
		super(value, isValid);
	}

	@Override
	protected ExistsDirectory createValidator() {
		return VALIDATOR;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() throws IOException {
		return Arrays.asList(new Object[][]{
			{TEMP.create().build(), false},
			{TEMP.create().exists().build(), false},
			{TEMP.create().exists().file().build(), false},
			{TEMP.create().exists().dir().build(), true},
		});
	}
}
