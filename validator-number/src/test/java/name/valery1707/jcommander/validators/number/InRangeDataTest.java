package name.valery1707.jcommander.validators.number;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class InRangeDataTest extends ValidatorTest<Integer, InRange<Integer>> {

	private final InRange<Integer> validator;

	public InRangeDataTest(InRange<Integer> validator, Integer value, boolean isValid) {
		super(value, isValid);
		this.validator = validator;
	}

	@Override
	protected InRange<Integer> createValidator() {
		return validator;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				//[1, 3]
				{new InRangeSimple(1, true, 3, true), 0, false},
				{new InRangeSimple(1, true, 3, true), 1, true},
				{new InRangeSimple(1, true, 3, true), 2, true},
				{new InRangeSimple(1, true, 3, true), 3, true},
				{new InRangeSimple(1, true, 3, true), 4, false},
				//(1, 3]
				{new InRangeSimple(1, false, 3, true), 0, false},
				{new InRangeSimple(1, false, 3, true), 1, false},
				{new InRangeSimple(1, false, 3, true), 2, true},
				{new InRangeSimple(1, false, 3, true), 3, true},
				{new InRangeSimple(1, false, 3, true), 4, false},
				//[1, 3)
				{new InRangeSimple(1, true, 3, false), 0, false},
				{new InRangeSimple(1, true, 3, false), 1, true},
				{new InRangeSimple(1, true, 3, false), 2, true},
				{new InRangeSimple(1, true, 3, false), 3, false},
				{new InRangeSimple(1, true, 3, false), 4, false},
				//(1, 3)
				{new InRangeSimple(1, false, 3, false), 0, false},
				{new InRangeSimple(1, false, 3, false), 1, false},
				{new InRangeSimple(1, false, 3, false), 2, true},
				{new InRangeSimple(1, false, 3, false), 3, false},
				{new InRangeSimple(1, false, 3, false), 4, false},
				//(..., 3]
				{new InRangeSimple(null, true, 3, true), 0, true},
				{new InRangeSimple(null, true, 3, true), 1, true},
				{new InRangeSimple(null, true, 3, true), 2, true},
				{new InRangeSimple(null, true, 3, true), 3, true},
				{new InRangeSimple(null, true, 3, true), 4, false},
				//(..., 3)
				{new InRangeSimple(null, false, 3, false), 0, true},
				{new InRangeSimple(null, false, 3, false), 1, true},
				{new InRangeSimple(null, false, 3, false), 2, true},
				{new InRangeSimple(null, false, 3, false), 3, false},
				{new InRangeSimple(null, false, 3, false), 4, false},
				//[1, ...)
				{new InRangeSimple(1, true, null, true), 0, false},
				{new InRangeSimple(1, true, null, true), 1, true},
				{new InRangeSimple(1, true, null, true), 2, true},
				{new InRangeSimple(1, true, null, true), 3, true},
				{new InRangeSimple(1, true, null, true), 4, true},
				//(1, ...)
				{new InRangeSimple(1, false, null, false), 0, false},
				{new InRangeSimple(1, false, null, false), 1, false},
				{new InRangeSimple(1, false, null, false), 2, true},
				{new InRangeSimple(1, false, null, false), 3, true},
				{new InRangeSimple(1, false, null, false), 4, true},
				//(1, 1)
				{new InRangeSimple(1, false, 1, false), 1, false},
				//(1, 1]
				{new InRangeSimple(1, false, 1, true), 1, false},
				//[1, 1)
				{new InRangeSimple(1, true, 1, false), 1, false},
				//[1, 1]
				{new InRangeSimple(1, true, 1, true), 1, true},
		});
	}

	public static class InRangeSimple extends InRange<Integer> {
		InRangeSimple(Integer min, boolean minInclusive, Integer max, boolean maxInclusive) {
			super(min, minInclusive, max, maxInclusive);
		}

		@Override
		public String error() {
			return super.error();
		}
	}
}