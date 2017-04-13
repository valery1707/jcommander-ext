package name.valery1707.jcommander.validators.io;

import java.io.File;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("WeakerAccess")
public final class FileMock {
	private final File mock;

	public static FileMock fileMock() {
		return new FileMock();
	}

	public FileMock() {
		mock = mock(File.class);
		//Defaults
		notExists();
		when(mock.isFile()).thenReturn(false);
		when(mock.isDirectory()).thenReturn(false);
		when(mock.canRead()).thenReturn(false);
		when(mock.canWrite()).thenReturn(false);
		when(mock.canExecute()).thenReturn(false);
	}

	public File getMock() {
		return mock;
	}

	public FileMock exists(boolean result) {
		when(mock.exists()).thenReturn(result);
		return this;
	}

	public FileMock exists() {
		return exists(true);
	}

	@SuppressWarnings("UnusedReturnValue")
	public FileMock notExists() {
		return exists(false);
	}

	public FileMock file() {
		when(mock.isFile()).thenReturn(true);
		return this;
	}

	public FileMock dir() {
		when(mock.isDirectory()).thenReturn(true);
		return this;
	}

	public FileMock readable() {
		when(mock.canRead()).thenReturn(true);
		return this;
	}

	public FileMock writable() {
		when(mock.canWrite()).thenReturn(true);
		return this;
	}

	public FileMock executable() {
		when(mock.canExecute()).thenReturn(true);
		return this;
	}
}
