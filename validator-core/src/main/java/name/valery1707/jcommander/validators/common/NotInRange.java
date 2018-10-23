package name.valery1707.jcommander.validators.common;

@SuppressWarnings("WeakerAccess")
public abstract class NotInRange<T extends Comparable<T>> extends RangeChecker<T> {

	@SuppressWarnings("WeakerAccess")
	protected NotInRange(T min, boolean minInclusive, T max, boolean maxInclusive) {
		super(min, minInclusive, max, maxInclusive, true);
	}
}
