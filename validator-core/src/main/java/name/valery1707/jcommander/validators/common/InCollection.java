package name.valery1707.jcommander.validators.common;

import java.util.Arrays;
import java.util.Collection;

@SuppressWarnings("WeakerAccess")
public abstract class InCollection<T> extends CollectionChecker<T> {

	@SuppressWarnings("WeakerAccess")
	protected InCollection(Collection<? extends T> collection) {
		super(collection, false);
	}

	@SuppressWarnings("WeakerAccess")
	protected InCollection(T... collection) {
		this(Arrays.asList(collection));
	}
}
