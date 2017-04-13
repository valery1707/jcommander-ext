package name.valery1707.jcommander.validators.common;

import name.valery1707.jcommander.validators.ValueChecker;

import java.util.Collection;
import java.util.Iterator;

public class InCollection<T> extends ValueChecker<T> {
	private final Collection<? extends T> collection;

	@SuppressWarnings("WeakerAccess")
	protected InCollection(Collection<? extends T> collection) {
		this.collection = collection;
	}

	@Override
	protected boolean check(T value) {
		return collection.contains(value);
	}

	@Override
	protected String error() {
		Iterator<? extends T> it = collection.iterator();
		StringBuilder str = new StringBuilder(2 + collection.size() * 5).append('[');
		while (it.hasNext()) {
			str.append(String.valueOf(it.next()));
			if (it.hasNext()) {
				str.append(',');
			}
		}
		str.append(']');
		return "must be in collection " + str.toString();
	}
}
