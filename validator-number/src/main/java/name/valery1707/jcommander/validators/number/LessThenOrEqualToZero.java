package name.valery1707.jcommander.validators.number;

public class LessThenOrEqualToZero<T extends Number> extends LessThenOrEqualTo<T> {
	protected Number other() {
		return 0;
	}

	@Override
	protected String otherDescriptor() {
		return "zero";
	}
}
