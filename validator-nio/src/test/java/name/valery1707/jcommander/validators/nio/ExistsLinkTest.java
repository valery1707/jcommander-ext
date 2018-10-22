package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.ClassRule;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;

public class ExistsLinkTest extends ValidatorTest<Path, ExistsLink> {
	private static final ExistsLink VALIDATOR = new ExistsLink();

	@ClassRule
	public static VirtualFolder TEMP = new VirtualFolder();

	public ExistsLinkTest(Path value, boolean isValid) {
		super(value, isValid);
	}

	@Override
	protected ExistsLink createValidator() {
		return VALIDATOR;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() throws IOException {
		return Arrays.asList(new Object[][]{
			{TEMP.create().build(), false},
			{TEMP.create().exists().build(), false},
			{TEMP.create().exists().dir().build(), false},
			{TEMP.create().exists().link().build(), true},
		});
	}
}
