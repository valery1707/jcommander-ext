package name.valery1707.jcommander.validators.number;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

public class LessThenZeroTest extends ValidatorTest<Number, LessThenZero<Number>> {

	public LessThenZeroTest(Number value, boolean isValid) {
		super(value, isValid);
	}

	protected LessThenZero<Number> createValidator() {
		return new LessThenZero<Number>();
	}

	@Parameterized.Parameters
	@SuppressWarnings("RedundantCast")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{(byte) -1, true},
				{(byte) 0, false},
				{(byte) 1, false},

				{(short) -1, true},
				{(short) 0, false},
				{(short) 1, false},

				{(int) -1, true},
				{(int) 0, false},
				{(int) 1, false},

				{(long) -1, true},
				{(long) 0, false},
				{(long) 1, false},

				{(float) -0.1, true},
				{(float) 0, false},
				{(float) 0.1, false},

				{(double) -0.1, true},
				{(double) 0, false},
				{(double) 0.1, false},

				{new BigInteger("-1"), true},
				{new BigInteger("0"), false},
				{new BigInteger("1"), false},

				{new BigDecimal("-0.1"), true},
				{new BigDecimal("0"), false},
				{new BigDecimal("0.1"), false},
		});
	}
}
