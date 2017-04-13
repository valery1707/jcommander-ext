package name.valery1707.jcommander.validators.io;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import static name.valery1707.jcommander.validators.io.FileMock.fileMock;

public class ExistsDirectoryExecutableTest extends ValidatorTest<File, ExistsDirectoryExecutable> {
	public ExistsDirectoryExecutableTest(FileMock value, boolean isValid) {
		super(value.getMock(), isValid);
	}

	@Override
	protected ExistsDirectoryExecutable createValidator() {
		return new ExistsDirectoryExecutable();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{fileMock(), false},
				{fileMock().exists(), false},
				{fileMock().exists().file(), false},
				{fileMock().exists().file().executable(), false},
				{fileMock().exists().dir(), false},
				{fileMock().exists().dir().executable(), true},
		});
	}
}