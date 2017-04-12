package name.valery1707.jcommander.validators;

import com.beust.jcommander.ParameterException;

public final class ParameterExceptions {
	ParameterExceptions() {
		throw new IllegalStateException("Must not be created directly");
	}

	public static ParameterException invalidParameter(String parameterName, String errorDescription) {
		return new ParameterException(
				String.format("Value for parameter '%s' %s."
						, parameterName, errorDescription
				));
	}
}
