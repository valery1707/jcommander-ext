package name.valery1707.jcommander.validators.number;

import name.valery1707.jcommander.validators.ValidatorTest;
import name.valery1707.jcommander.validators.number.NotEqualToOneTest.NotEqualToOne;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

public class NotEqualToOneTest extends ValidatorTest<Number, NotEqualToOne<Number>> {

	public NotEqualToOneTest(Number value, boolean isValid) {
		super(value, isValid);
	}

	protected NotEqualToOne<Number> createValidator() {
		return new NotEqualToOne<Number>();
	}

	@Parameterized.Parameters
	@SuppressWarnings("RedundantCast")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{(byte) -1, true},
				{(byte) 0, true},
				{(byte) 1, false},

				{(short) -1, true},
				{(short) 0, true},
				{(short) 1, false},

				{(int) -1, true},
				{(int) 0, true},
				{(int) 1, false},

				{(long) -1, true},
				{(long) 0, true},
				{(long) 1, false},

				{(float) -1.0, true},
				{(float) 0, true},
				{(float) 1.0, false},

				{(double) -1.0, true},
				{(double) 0, true},
				{(double) 1.0, false},

				{new BigInteger("-1"), true},
				{new BigInteger("0"), true},
				{new BigInteger("1"), false},

				{new BigDecimal("-1.0"), true},
				{new BigDecimal("0"), true},
				{new BigDecimal("1.0"), false},
		});
	}

	public static class NotEqualToOne<T extends Number> extends NotEqualTo<T> {
		@Override
		protected Number other() {
			return 1;
		}
	}
}
