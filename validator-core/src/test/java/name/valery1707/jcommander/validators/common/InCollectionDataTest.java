package name.valery1707.jcommander.validators.common;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;

public class InCollectionDataTest extends ValidatorTest<Integer, InCollection<Integer>> {
	private final InCollection<Integer> validator;

	public InCollectionDataTest(InCollection<Integer> validator, Integer value, boolean isValid) {
		super(value, isValid);
		this.validator = validator;
	}

	@Override
	protected InCollection<Integer> createValidator() {
		return validator;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return asList(new Object[][]{
				//[]
				{new InCollection<Integer>(list()), 0, false},
				//[1]
				{new InCollection<Integer>(list(1)), 0, false},
				{new InCollection<Integer>(list(1)), 1, true},
				//[1, 3]
				{new InCollection<Integer>(list(1, 3)), 0, false},
				{new InCollection<Integer>(list(1, 3)), 1, true},
				{new InCollection<Integer>(list(1, 3)), 2, false},
				{new InCollection<Integer>(list(1, 3)), 3, true},
		});
	}

	private static Collection<Integer> list(Integer... values) {
		return asList(values);
	}
}
