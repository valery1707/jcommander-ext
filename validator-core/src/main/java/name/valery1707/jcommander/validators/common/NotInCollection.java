package name.valery1707.jcommander.validators.common;

import java.util.Arrays;
import java.util.Collection;

@SuppressWarnings("WeakerAccess")
public abstract class NotInCollection<T> extends CollectionChecker<T> {

	@SuppressWarnings("WeakerAccess")
	protected NotInCollection(Collection<? extends T> collection) {
		super(collection, true);
	}

	@SuppressWarnings("WeakerAccess")
	protected NotInCollection(T... collection) {
		this(Arrays.asList(collection));
	}
}
