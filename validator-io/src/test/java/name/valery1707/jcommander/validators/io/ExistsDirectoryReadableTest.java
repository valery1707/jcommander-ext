package name.valery1707.jcommander.validators.io;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import static name.valery1707.jcommander.validators.io.FileMock.fileMock;

public class ExistsDirectoryReadableTest extends ValidatorTest<File, ExistsDirectoryReadable> {
	public ExistsDirectoryReadableTest(FileMock value, boolean isValid) {
		super(value.getMock(), isValid);
	}

	@Override
	protected ExistsDirectoryReadable createValidator() {
		return new ExistsDirectoryReadable();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{fileMock(), false},
				{fileMock().exists(), false},
				{fileMock().exists().file(), false},
				{fileMock().exists().file().readable(), false},
				{fileMock().exists().dir(), false},
				{fileMock().exists().dir().readable(), true},
		});
	}
}