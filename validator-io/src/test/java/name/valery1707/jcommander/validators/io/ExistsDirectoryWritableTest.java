package name.valery1707.jcommander.validators.io;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import static name.valery1707.jcommander.validators.io.FileMock.fileMock;

public class ExistsDirectoryWritableTest extends ValidatorTest<File, ExistsDirectoryWritable> {
	public ExistsDirectoryWritableTest(FileMock value, boolean isValid) {
		super(value.getMock(), isValid);
	}

	@Override
	protected ExistsDirectoryWritable createValidator() {
		return new ExistsDirectoryWritable();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{fileMock(), false},
				{fileMock().exists(), false},
				{fileMock().exists().file(), false},
				{fileMock().exists().file().writable(), false},
				{fileMock().exists().dir(), false},
				{fileMock().exists().dir().writable(), true},
		});
	}
}