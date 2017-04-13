package name.valery1707.jcommander.validators.io;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import static name.valery1707.jcommander.validators.io.FileMock.fileMock;

public class ExistsDirectoryTest extends ValidatorTest<File, ExistsDirectory> {
	public ExistsDirectoryTest(FileMock value, boolean isValid) {
		super(value.getMock(), isValid);
	}

	@Override
	protected ExistsDirectory createValidator() {
		return new ExistsDirectory();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{fileMock(), false},
				{fileMock().exists(), false},
				{fileMock().exists().file(), false},
				{fileMock().exists().dir(), true},
		});
	}
}