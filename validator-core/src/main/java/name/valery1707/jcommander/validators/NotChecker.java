package name.valery1707.jcommander.validators;

@SuppressWarnings("WeakerAccess")
public abstract class NotChecker<T> extends ValueChecker<T> {
	private final ValueChecker<T> checker;

	@SuppressWarnings("WeakerAccess")
	protected NotChecker(ValueChecker<T> checker) {
		this.checker = checker;
	}

	@Override
	protected boolean check(T value) {
		return !checker.check(value);
	}

	@Override
	protected String error() {
		return "not " + checker.error();
	}
}
