package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.ClassRule;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;

public class ExistsDirectoryReadableTest extends ValidatorTest<Path, ExistsDirectoryReadable> {
	private static final ExistsDirectoryReadable VALIDATOR = new ExistsDirectoryReadable();

	@ClassRule
	public static VirtualFolder TEMP = new VirtualFolder();

	public ExistsDirectoryReadableTest(Path value, boolean isValid) {
		super(value, isValid);
	}

	@Override
	protected ExistsDirectoryReadable createValidator() {
		return VALIDATOR;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() throws IOException {
		return Arrays.asList(new Object[][]{
			{TEMP.create().build(), false},
			{TEMP.create().exists().build(), false},
			{TEMP.create().exists().file().build(), false},
			{TEMP.create().exists().file().readable().build(), false},
//			{TEMP.create().exists().dir().build(), false},//todo https://github.com/marschall/memoryfilesystem/issues/112
			{TEMP.create().exists().dir().readable().build(), true},
		});
	}
}
