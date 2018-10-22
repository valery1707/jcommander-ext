package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValueChecker;

import java.nio.file.Path;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.isRegularFile;

public class ExistsFile extends ValueChecker<Path> {
	@Override
	protected boolean check(Path value) {
		return exists(value) && isRegularFile(value);
	}

	@Override
	protected String error() {
		return "be exists file";
	}
}
