package name.valery1707.jcommander.validators.io;

import name.valery1707.jcommander.validators.ValueChecker;

import java.io.File;

public class ExistsDirectoryWritable extends ValueChecker<File> {
	@Override
	protected boolean check(File value) {
		return value.exists() && value.isDirectory() && value.canWrite();
	}

	@Override
	protected String error() {
		return "be exists and writable directory";
	}
}
