package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.ClassRule;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;

public class ExistsLinkWritableTest extends ValidatorTest<Path, ExistsLinkWritable> {
	private static final ExistsLinkWritable VALIDATOR = new ExistsLinkWritable();

	@ClassRule
	public static VirtualFolder TEMP = new VirtualFolder();

	public ExistsLinkWritableTest(Path value, boolean isValid) {
		super(value, isValid);
	}

	@Override
	protected ExistsLinkWritable createValidator() {
		return VALIDATOR;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() throws IOException {
		return Arrays.asList(new Object[][]{
			{TEMP.create().build(), false},
			{TEMP.create().exists().build(), false},
			{TEMP.create().exists().dir().build(), false},
			{TEMP.create().exists().dir().writable().build(), false},
//			{TEMP.create().exists().link().build(), false},//todo https://github.com/marschall/memoryfilesystem/issues/112
			{TEMP.create().exists().link().writable().build(), true},
		});
	}
}
