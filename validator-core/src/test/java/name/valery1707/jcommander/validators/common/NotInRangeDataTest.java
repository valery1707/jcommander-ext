package name.valery1707.jcommander.validators.common;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class NotInRangeDataTest extends ValidatorTest<Integer, NotInRange<Integer>> {
	private final NotInRange<Integer> validator;

	public NotInRangeDataTest(NotInRange<Integer> validator, Integer value, boolean isValid) {
		super(value, isValid);
		this.validator = validator;
	}

	@Override
	protected NotInRange<Integer> createValidator() {
		return validator;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				//[1, 3]
				{new NotInRangeSimple(1, true, 3, true), 0, true},
				{new NotInRangeSimple(1, true, 3, true), 1, false},
				{new NotInRangeSimple(1, true, 3, true), 2, false},
				{new NotInRangeSimple(1, true, 3, true), 3, false},
				{new NotInRangeSimple(1, true, 3, true), 4, true},
				//(1, 3]
				{new NotInRangeSimple(1, false, 3, true), 0, true},
				{new NotInRangeSimple(1, false, 3, true), 1, true},
				{new NotInRangeSimple(1, false, 3, true), 2, false},
				{new NotInRangeSimple(1, false, 3, true), 3, false},
				{new NotInRangeSimple(1, false, 3, true), 4, true},
				//[1, 3)
				{new NotInRangeSimple(1, true, 3, false), 0, true},
				{new NotInRangeSimple(1, true, 3, false), 1, false},
				{new NotInRangeSimple(1, true, 3, false), 2, false},
				{new NotInRangeSimple(1, true, 3, false), 3, true},
				{new NotInRangeSimple(1, true, 3, false), 4, true},
				//(1, 3)
				{new NotInRangeSimple(1, false, 3, false), 0, true},
				{new NotInRangeSimple(1, false, 3, false), 1, true},
				{new NotInRangeSimple(1, false, 3, false), 2, false},
				{new NotInRangeSimple(1, false, 3, false), 3, true},
				{new NotInRangeSimple(1, false, 3, false), 4, true},
				//(..., 3]
				{new NotInRangeSimple(null, true, 3, true), 0, false},
				{new NotInRangeSimple(null, true, 3, true), 1, false},
				{new NotInRangeSimple(null, true, 3, true), 2, false},
				{new NotInRangeSimple(null, true, 3, true), 3, false},
				{new NotInRangeSimple(null, true, 3, true), 4, true},
				//(..., 3)
				{new NotInRangeSimple(null, false, 3, false), 0, false},
				{new NotInRangeSimple(null, false, 3, false), 1, false},
				{new NotInRangeSimple(null, false, 3, false), 2, false},
				{new NotInRangeSimple(null, false, 3, false), 3, true},
				{new NotInRangeSimple(null, false, 3, false), 4, true},
				//[1, ...)
				{new NotInRangeSimple(1, true, null, true), 0, true},
				{new NotInRangeSimple(1, true, null, true), 1, false},
				{new NotInRangeSimple(1, true, null, true), 2, false},
				{new NotInRangeSimple(1, true, null, true), 3, false},
				{new NotInRangeSimple(1, true, null, true), 4, false},
				//(1, ...)
				{new NotInRangeSimple(1, false, null, false), 0, true},
				{new NotInRangeSimple(1, false, null, false), 1, true},
				{new NotInRangeSimple(1, false, null, false), 2, false},
				{new NotInRangeSimple(1, false, null, false), 3, false},
				{new NotInRangeSimple(1, false, null, false), 4, false},
				//(1, 1)
				{new NotInRangeSimple(1, false, 1, false), 1, true},
				//(1, 1]
				{new NotInRangeSimple(1, false, 1, true), 1, true},
				//[1, 1)
				{new NotInRangeSimple(1, true, 1, false), 1, true},
				//[1, 1]
				{new NotInRangeSimple(1, true, 1, true), 1, false},
		});
	}

	public static class NotInRangeSimple extends NotInRange<Integer> {
		NotInRangeSimple(Integer min, boolean minInclusive, Integer max, boolean maxInclusive) {
			super(min, minInclusive, max, maxInclusive);
		}
	}
}
