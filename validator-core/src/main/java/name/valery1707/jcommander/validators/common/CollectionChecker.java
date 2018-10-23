package name.valery1707.jcommander.validators.common;

import name.valery1707.jcommander.validators.ValueChecker;

import java.util.Collection;
import java.util.Iterator;

abstract class CollectionChecker<T> extends ValueChecker<T> {
	private final Collection<? extends T> collection;
	private final boolean reverse;

	CollectionChecker(Collection<? extends T> collection, boolean reverse) {
		this.collection = collection;
		this.reverse = reverse;
	}

	@Override
	protected boolean check(T value) {
		boolean check = collection.contains(value);
		return reverse != check;//reverse ? !check : check
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
		String message = reverse
			? "must be not in collection "
			: "must be in collection ";
		return message + str.toString();
	}
}
