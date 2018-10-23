package name.valery1707.jcommander.validators.common;

import name.valery1707.jcommander.validators.ValueChecker;

abstract class RangeChecker<T extends Comparable<T>> extends ValueChecker<T> {
	//Nullable
	private final T min;
	private final boolean minInclusive;
	//Nullable
	private final T max;
	private final boolean maxInclusive;

	private final boolean reverse;

	RangeChecker(
		T min, boolean minInclusive,
		T max, boolean maxInclusive,
		boolean reverse
	) {
		this.min = min;
		this.minInclusive = minInclusive;
		this.max = max;
		this.maxInclusive = maxInclusive;
		this.reverse = reverse;
		if (min == null && max == null) {
			throw new IllegalArgumentException("At least one border must be not null");
		}
		if (min != null && max != null && min.compareTo(max) > 0) {
			throw new IllegalArgumentException("Left border must be less ot equal to right border");
		}
	}

	@Override
	protected boolean check(T value) {
		boolean check = checkMin(value) && checkMax(value);
		return reverse != check;//reverse ? !check : check
	}

	private boolean checkMin(T value) {
		return min == null || (minInclusive
			? min.compareTo(value) <= 0
			: min.compareTo(value) < 0
		);
	}

	private boolean checkMax(T value) {
		return max == null || (maxInclusive
			? max.compareTo(value) >= 0
			: max.compareTo(value) > 0
		);
	}

	@Override
	protected String error() {
		String message = reverse
			? "be not in range "
			: "be in range ";
		return message
			+ (min != null && minInclusive ? "[" : "(")
			+ (min != null ? min : "...")
			+ ", "
			+ (max != null ? max : "...")
			+ (max != null && maxInclusive ? "]" : ")")
			;
	}
}
