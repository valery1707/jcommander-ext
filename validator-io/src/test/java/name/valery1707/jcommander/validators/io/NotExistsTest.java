package name.valery1707.jcommander.validators.io;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import static name.valery1707.jcommander.validators.io.FileMock.fileMock;

public class NotExistsTest extends ValidatorTest<File, NotExists> {
	public NotExistsTest(FileMock value, boolean isValid) {
		super(value.getMock(), isValid);
	}

	@Override
	protected NotExists createValidator() {
		return new NotExists();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{fileMock(), true},
				{fileMock().exists(), false},
		});
	}
}