package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValueChecker;

import java.nio.file.Path;

import static java.nio.file.Files.*;

public class ExistsFileWritable extends ValueChecker<Path> {
	@Override
	protected boolean check(Path value) {
		return exists(value) && isRegularFile(value) && isWritable(value);
	}

	@Override
	protected String error() {
		return "be exists and writable file";
	}
}
