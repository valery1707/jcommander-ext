package name.valery1707.jcommander.validators.number;

public class EqualToZero<T extends Number> extends EqualTo<T> {
	protected Number other() {
		return 0;
	}

	@Override
	protected String otherDescriptor() {
		return "zero";
	}
}
