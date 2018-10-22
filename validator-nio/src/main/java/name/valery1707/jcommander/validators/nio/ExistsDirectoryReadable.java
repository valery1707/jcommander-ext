package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValueChecker;

import java.nio.file.Path;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.isDirectory;
import static java.nio.file.Files.isReadable;

public class ExistsDirectoryReadable extends ValueChecker<Path> {
	@Override
	protected boolean check(Path value) {
		return exists(value) && isDirectory(value) && isReadable(value);
	}

	@Override
	protected String error() {
		return "be exists and readable directory";
	}
}
