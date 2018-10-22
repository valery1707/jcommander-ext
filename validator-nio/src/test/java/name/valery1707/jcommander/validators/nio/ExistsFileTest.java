package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.ClassRule;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;

public class ExistsFileTest extends ValidatorTest<Path, ExistsFile> {
	private static final ExistsFile VALIDATOR = new ExistsFile();

	@ClassRule
	public static VirtualFolder TEMP = new VirtualFolder();

	public ExistsFileTest(Path value, boolean isValid) {
		super(value, isValid);
	}

	@Override
	protected ExistsFile createValidator() {
		return VALIDATOR;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() throws IOException {
		return Arrays.asList(new Object[][]{
			{TEMP.create().build(), false},
//			{TEMP.create().exists().build(), false},//todo https://github.com/marschall/memoryfilesystem/issues/112
			{TEMP.create().exists().dir().build(), false},
			{TEMP.create().exists().file().build(), true},
		});
	}
}
