package name.valery1707.jcommander.validators.number;

import name.valery1707.jcommander.validators.ValueChecker;

public abstract class NumberValidator<T extends Number> extends ValueChecker<T> {

	@Override
	protected boolean check(T value) {
		return check(value.doubleValue(), other().doubleValue());
	}

	@Override
	protected String error() {
		return "be " + checkDescriptor() + " " + otherDescriptor();
	}

	protected abstract boolean check(double actual, double test);

	protected abstract String checkDescriptor();

	protected abstract Number other();

	protected String otherDescriptor() {
		return other().toString();
	}
}
