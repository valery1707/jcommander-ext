package name.valery1707.jcommander.validators.common;

import name.valery1707.jcommander.validators.NotChecker;

@SuppressWarnings("WeakerAccess")
public class NotInRange<T extends Comparable<T>> extends NotChecker<T> {

	public NotInRange(T min, boolean minInclusive, T max, boolean maxInclusive) {
		super(new InRange<T>(min, minInclusive, max, maxInclusive));
	}
}
