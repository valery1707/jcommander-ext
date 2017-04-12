package name.valery1707.jcommander.validators.number;

public class GreaterThenOrEqualToZero<T extends Number> extends GreaterThenOrEqualTo<T> {
	protected Number other() {
		return 0;
	}

	@Override
	protected String otherDescriptor() {
		return "zero";
	}
}
