package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValueChecker;

import java.nio.file.Path;

import static java.nio.file.Files.exists;

public class Exists extends ValueChecker<Path> {
	@Override
	protected boolean check(Path value) {
		return exists(value);
	}

	@Override
	protected String error() {
		return "exists";
	}
}
