package name.valery1707.jcommander.validators.number;

public abstract class NotEqualTo<T extends Number> extends NumberValidator<T> {

	@Override
	protected boolean check(double actual, double test) {
		return actual != test;
	}

	@Override
	protected String checkDescriptor() {
		return "not equal to";
	}
}
