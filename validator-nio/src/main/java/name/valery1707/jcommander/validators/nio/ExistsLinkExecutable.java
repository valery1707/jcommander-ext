package name.valery1707.jcommander.validators.nio;

import name.valery1707.jcommander.validators.ValueChecker;

import java.nio.file.Path;

import static java.nio.file.Files.*;

public class ExistsLinkExecutable extends ValueChecker<Path> {
	@Override
	protected boolean check(Path value) {
		return exists(value) && isSymbolicLink(value) && isExecutable(value);
	}

	@Override
	protected String error() {
		return "be exists and executable link";
	}
}
