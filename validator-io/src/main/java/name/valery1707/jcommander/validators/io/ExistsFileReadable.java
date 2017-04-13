package name.valery1707.jcommander.validators.io;

import name.valery1707.jcommander.validators.ValueChecker;

import java.io.File;

public class ExistsFileReadable extends ValueChecker<File> {
	@Override
	protected boolean check(File value) {
		return value.exists() && value.isFile() && value.canRead();
	}

	@Override
	protected String error() {
		return "be exists and readable file";
	}
}
