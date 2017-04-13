package name.valery1707.jcommander.validators.io;

import name.valery1707.jcommander.validators.ValueChecker;

import java.io.File;

public class ExistsDirectory extends ValueChecker<File> {
	@Override
	protected boolean check(File value) {
		return value.exists() && value.isDirectory();
	}

	@Override
	protected String error() {
		return "be exists directory";
	}
}
