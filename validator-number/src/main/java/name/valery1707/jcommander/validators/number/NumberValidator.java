package name.valery1707.jcommander.validators.number;

import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;

import static name.valery1707.jcommander.validators.ParameterExceptions.invalidParameter;

public abstract class NumberValidator<T extends Number> implements IValueValidator<T> {

	public void validate(String name, T value) throws ParameterException {
		if (!check(value.doubleValue(), other().doubleValue())) {
			throw invalidParameter(name, "must be " + checkDescriptor() + " " + otherDescriptor());
		}
	}

	protected abstract boolean check(double actual, double test);

	protected abstract String checkDescriptor();

	protected abstract Number other();

	protected String otherDescriptor() {
		return other().toString();
	}
}
