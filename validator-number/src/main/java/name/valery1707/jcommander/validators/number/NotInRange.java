package name.valery1707.jcommander.validators.number;

import name.valery1707.jcommander.validators.NotChecker;

@SuppressWarnings("WeakerAccess")
public class NotInRange<T extends Number> extends NotChecker<T> {

	public NotInRange(T min, boolean minInclusive, T max, boolean maxInclusive) {
		super(new InRange<T>(min, minInclusive, max, maxInclusive));
	}
}
