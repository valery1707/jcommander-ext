package name.valery1707.jcommander.validators.number;

public class LessThenZero<T extends Number> extends LessThen<T> {
	protected Number other() {
		return 0;
	}

	@Override
	protected String otherDescriptor() {
		return "zero";
	}
}
