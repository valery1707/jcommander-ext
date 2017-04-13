package name.valery1707.jcommander.validators.io;

import name.valery1707.jcommander.validators.NotChecker;

import java.io.File;

@SuppressWarnings("WeakerAccess")
public class NotExists extends NotChecker<File> {

	public NotExists() {
		super(new Exists());
	}
}
