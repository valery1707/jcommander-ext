package name.valery1707.jcommander.validators.io;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import static name.valery1707.jcommander.validators.io.FileMock.fileMock;

public class ExistsFileTest extends ValidatorTest<File, ExistsFile> {
	public ExistsFileTest(FileMock value, boolean isValid) {
		super(value.getMock(), isValid);
	}

	@Override
	protected ExistsFile createValidator() {
		return new ExistsFile();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{fileMock(), false},
				{fileMock().exists(), false},
				{fileMock().exists().file(), true},
				{fileMock().exists().dir(), false},
		});
	}
}