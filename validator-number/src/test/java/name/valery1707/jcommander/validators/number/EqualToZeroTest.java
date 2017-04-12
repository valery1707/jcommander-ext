package name.valery1707.jcommander.validators.number;

import name.valery1707.jcommander.validators.ValidatorTest;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

public class EqualToZeroTest extends ValidatorTest<Number, EqualToZero<Number>> {

	public EqualToZeroTest(Number value, boolean isValid) {
		super(value, isValid);
	}

	protected EqualToZero<Number> createValidator() {
		return new EqualToZero<Number>();
	}

	@Parameterized.Parameters
	@SuppressWarnings("RedundantCast")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{(byte) -1, false},
				{(byte) 0, true},
				{(byte) 1, false},

				{(short) -1, false},
				{(short) 0, true},
				{(short) 1, false},

				{(int) -1, false},
				{(int) 0, true},
				{(int) 1, false},

				{(long) -1, false},
				{(long) 0, true},
				{(long) 1, false},

				{(float) -0.1, false},
				{(float) 0, true},
				{(float) 0.1, false},

				{(double) -0.1, false},
				{(double) 0, true},
				{(double) 0.1, false},

				{new BigInteger("-1"), false},
				{new BigInteger("0"), true},
				{new BigInteger("1"), false},

				{new BigDecimal("-0.1"), false},
				{new BigDecimal("0"), true},
				{new BigDecimal("0.1"), false},
		});
	}
}
