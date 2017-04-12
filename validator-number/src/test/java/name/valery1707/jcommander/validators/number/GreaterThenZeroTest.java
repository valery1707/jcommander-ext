package name.valery1707.jcommander.validators.number;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

public class GreaterThenZeroTest extends ValidatorTest<Number, GreaterThenZero<Number>> {

	public GreaterThenZeroTest(Number value, boolean isValid) {
		super(value, isValid);
	}

	protected GreaterThenZero<Number> createValidator() {
		return new GreaterThenZero<Number>();
	}

	@Parameterized.Parameters
	@SuppressWarnings("RedundantCast")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{(byte) -1, false},
				{(byte) 0, false},
				{(byte) 1, true},

				{(short) -1, false},
				{(short) 0, false},
				{(short) 1, true},

				{(int) -1, false},
				{(int) 0, false},
				{(int) 1, true},

				{(long) -1, false},
				{(long) 0, false},
				{(long) 1, true},

				{(float) -0.1, false},
				{(float) 0, false},
				{(float) 0.1, true},

				{(double) -0.1, false},
				{(double) 0, false},
				{(double) 0.1, true},

				{new BigInteger("-1"), false},
				{new BigInteger("0"), false},
				{new BigInteger("1"), true},

				{new BigDecimal("-0.1"), false},
				{new BigDecimal("0"), false},
				{new BigDecimal("0.1"), true},
		});
	}
}
