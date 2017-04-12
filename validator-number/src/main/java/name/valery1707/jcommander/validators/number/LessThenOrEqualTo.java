package name.valery1707.jcommander.validators.number;

public abstract class LessThenOrEqualTo<T extends Number> extends NumberValidator<T> {

	@Override
	protected boolean check(double actual, double test) {
		return actual <= test;
	}

	@Override
	protected String checkDescriptor() {
		return "less than or equal to";
	}
}
