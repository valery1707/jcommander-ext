package name.valery1707.jcommander.validators.io;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import static name.valery1707.jcommander.validators.io.FileMock.fileMock;

public class ExistsFileExecutableTest extends ValidatorTest<File, ExistsFileExecutable> {
	public ExistsFileExecutableTest(FileMock value, boolean isValid) {
		super(value.getMock(), isValid);
	}

	@Override
	protected ExistsFileExecutable createValidator() {
		return new ExistsFileExecutable();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{fileMock(), false},
				{fileMock().exists(), false},
				{fileMock().exists().file(), false},
				{fileMock().exists().file().executable(), true},
				{fileMock().exists().dir(), false},
		});
	}
}