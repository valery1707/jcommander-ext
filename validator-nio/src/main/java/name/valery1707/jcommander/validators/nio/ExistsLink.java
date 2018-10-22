package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValueChecker;

import java.nio.file.Path;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.isRegularFile;
import static java.nio.file.Files.isSymbolicLink;

public class ExistsLink extends ValueChecker<Path> {
	@Override
	protected boolean check(Path value) {
		return exists(value) && isSymbolicLink(value);
	}

	@Override
	protected String error() {
		return "be exists link";
	}
}
