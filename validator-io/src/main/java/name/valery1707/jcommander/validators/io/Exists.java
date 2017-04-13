package name.valery1707.jcommander.validators.io;

import name.valery1707.jcommander.validators.ValueChecker;

import java.io.File;

public class Exists extends ValueChecker<File> {

	@Override
	protected boolean check(File value) {
		return value.exists();
	}

	@Override
	protected String error() {
		return "exists";
	}
}
