package name.valery1707.jcommander.validators.common;

import name.valery1707.jcommander.validators.ValueChecker;

public class InRange<T extends Comparable<T>> extends ValueChecker<T> {
	//Nullable
	private final T min;
	private final boolean minInclusive;
	//Nullable
	private final T max;
	private final boolean maxInclusive;

	@SuppressWarnings("WeakerAccess")
	protected InRange(T min, boolean minInclusive, T max, boolean maxInclusive) {
		this.min = min;
		this.minInclusive = minInclusive;
		this.max = max;
		this.maxInclusive = maxInclusive;
		if (min == null && max == null) {
			throw new IllegalArgumentException("At least one border must be not null");
		}
		if (min != null && max != null && min.compareTo(max) > 0) {
			throw new IllegalArgumentException("Left border must be less ot equal to right border");
		}
	}

	@Override
	protected boolean check(T raw) {
		boolean valid = true;
		if (min != null) {
			int compare = min.compareTo(raw);
			valid = minInclusive ? compare <= 0 : compare < 0;
		}
		if (max != null) {
			int compare = max.compareTo(raw);
			valid = valid && (maxInclusive ? compare >= 0 : compare > 0);
		}
		return valid;
	}

	@Override
	protected String error() {
		return "be in range "
			   + (min != null && minInclusive ? "[" : "(")
			   + (min != null ? min : "...")
			   + ", "
			   + (max != null ? max : "...")
			   + (max != null && maxInclusive ? "]" : ")")
				;
	}
}
