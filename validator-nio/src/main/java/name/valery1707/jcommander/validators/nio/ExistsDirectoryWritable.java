package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValueChecker;

import java.nio.file.Path;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.isDirectory;
import static java.nio.file.Files.isWritable;

public class ExistsDirectoryWritable extends ValueChecker<Path> {
	@Override
	protected boolean check(Path value) {
		return exists(value) && isDirectory(value) && isWritable(value);
	}

	@Override
	protected String error() {
		return "be exists and writable directory";
	}
}
