package name.valery1707.jcommander.validators;

import com.beust.jcommander.ParameterException;

@SuppressWarnings("WeakerAccess")
public final class ParameterExceptions {
	ParameterExceptions() {
		throw new UnsupportedOperationException("Must not be created directly");
	}

	public static ParameterException invalidParameter(String parameterName, String errorDescription) {
		return new ParameterException(
				String.format("Value for parameter '%s' %s."
						, parameterName, errorDescription
				));
	}
}
