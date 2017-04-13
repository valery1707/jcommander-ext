package name.valery1707.jcommander.validators.common;

import name.valery1707.jcommander.validators.NotChecker;

import java.util.Collection;

@SuppressWarnings("WeakerAccess")
public class NotInCollection<T> extends NotChecker<T> {
	public NotInCollection(Collection<? extends T> collection) {
		super(new InCollection<T>(collection));
	}
}
