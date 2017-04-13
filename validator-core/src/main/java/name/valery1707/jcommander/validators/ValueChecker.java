package name.valery1707.jcommander.validators;

import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;

import static name.valery1707.jcommander.validators.ParameterExceptions.invalidParameter;

public abstract class ValueChecker<T> implements IValueValidator<T> {
	@Override
	public void validate(String name, T value) throws ParameterException {
		if (!check(name, value)) {
			throw invalidParameter(name, "must " + error(name, value));
		}
	}

	@SuppressWarnings("unused")
	protected boolean check(String name, T value) {
		return check(value);
	}

	protected abstract boolean check(T value);

	@SuppressWarnings("unused")
	protected String error(String name, T value) {
		return error(value);
	}

	@SuppressWarnings("unused")
	protected String error(T value) {
		return error();
	}

	protected abstract String error();
}
