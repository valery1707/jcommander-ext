package name.valery1707.jcommander.validators.number;

public class NotEqualToZero<T extends Number> extends NotEqualTo<T> {
	protected Number other() {
		return 0;
	}

	@Override
	protected String otherDescriptor() {
		return "zero";
	}
}
