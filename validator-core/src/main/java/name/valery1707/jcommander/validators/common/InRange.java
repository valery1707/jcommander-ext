package name.valery1707.jcommander.validators.common;

@SuppressWarnings("WeakerAccess")
public abstract class InRange<T extends Comparable<T>> extends RangeChecker<T> {

	@SuppressWarnings("WeakerAccess")
	protected InRange(T min, boolean minInclusive, T max, boolean maxInclusive) {
		super(min, minInclusive, max, maxInclusive, false);
	}
}
