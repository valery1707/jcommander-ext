package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValueChecker;

import java.nio.file.Path;

import static java.nio.file.Files.notExists;

public class NotExists extends ValueChecker<Path> {
	@Override
	protected boolean check(Path value) {
		return notExists(value);
	}

	@Override
	protected String error() {
		return "not exists";
	}
}
