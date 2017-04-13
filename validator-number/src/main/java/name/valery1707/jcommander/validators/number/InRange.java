package name.valery1707.jcommander.validators.number;

import name.valery1707.jcommander.validators.ValueChecker;

public abstract class InRange<T extends Number> extends ValueChecker<T> {
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
		if (min != null && max != null && min.doubleValue() > max.doubleValue()) {
			throw new IllegalArgumentException("Left border must be less ot equal to right border");
		}
	}

	@Override
	protected boolean check(T raw) {
		double value = raw.doubleValue();
		boolean valid = true;
		if (min != null) {
			valid = minInclusive ? min.doubleValue() <= value : min.doubleValue() < value;
		}
		if (max != null) {
			valid = valid && (maxInclusive ? max.doubleValue() >= value : max.doubleValue() > value);
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
