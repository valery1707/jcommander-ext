package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValueChecker;

import java.nio.file.Path;

import static java.nio.file.Files.*;

public class ExistsLinkReadable extends ValueChecker<Path> {
	@Override
	protected boolean check(Path value) {
		return exists(value) && isSymbolicLink(value) && isReadable(value);
	}

	@Override
	protected String error() {
		return "be exists and readable link";
	}
}
