package name.valery1707.jcommander.validators.number;

public class GreaterThenZero<T extends Number> extends GreaterThen<T> {
	protected Number other() {
		return 0;
	}

	@Override
	protected String otherDescriptor() {
		return "zero";
	}
}
