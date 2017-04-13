package name.valery1707.jcommander.validators.common;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;

public class NotInCollectionDataTest extends ValidatorTest<Integer, NotInCollection<Integer>> {
	private final NotInCollection<Integer> validator;

	public NotInCollectionDataTest(NotInCollection<Integer> validator, Integer value, boolean isValid) {
		super(value, isValid);
		this.validator = validator;
	}

	@Override
	protected NotInCollection<Integer> createValidator() {
		return validator;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return asList(new Object[][]{
				//[]
				{new NotInCollection<Integer>(list()), 0, true},
				//[1]
				{new NotInCollection<Integer>(list(1)), 0, true},
				{new NotInCollection<Integer>(list(1)), 1, false},
				//[1, 3]
				{new NotInCollection<Integer>(list(1, 3)), 0, true},
				{new NotInCollection<Integer>(list(1, 3)), 1, false},
				{new NotInCollection<Integer>(list(1, 3)), 2, true},
				{new NotInCollection<Integer>(list(1, 3)), 3, false},
		});
	}

	private static Collection<Integer> list(Integer... values) {
		return asList(values);
	}
}
