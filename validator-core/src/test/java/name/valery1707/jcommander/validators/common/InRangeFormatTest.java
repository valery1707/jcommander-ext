package name.valery1707.jcommander.validators.common;

import name.valery1707.jcommander.validators.common.InRangeDataTest.InRangeSimple;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InRangeFormatTest {
	@Test
	public void rangeClosedClosed() {
		assertThat(new InRangeSimple(1, true, 5, true).error()).endsWith("range [1, 5]");
	}

	@Test
	public void rangeClosedOpen() {
		assertThat(new InRangeSimple(1, true, 5, false).error()).endsWith("range [1, 5)");
	}

	@Test
	public void rangeOpenClosed() {
		assertThat(new InRangeSimple(1, false, 5, true).error()).endsWith("range (1, 5]");
	}

	@Test
	public void rangeOpenOpen() {
		assertThat(new InRangeSimple(1, false, 5, false).error()).endsWith("range (1, 5)");
	}

	@Test
	public void rangeFromInfinity() {
		assertThat(new InRangeSimple(null, false, 5, false).error()).endsWith("range (..., 5)");
		assertThat(new InRangeSimple(null, true, 5, true).error()).endsWith("range (..., 5]");
	}

	@Test
	public void rangeToInfinity() {
		assertThat(new InRangeSimple(1, false, null, false).error()).endsWith("range (1, ...)");
		assertThat(new InRangeSimple(1, true, null, true).error()).endsWith("range [1, ...)");
	}

	@Test(expected = IllegalArgumentException.class)
	public void rangeReversed() {
		new InRangeSimple(5, true, 1, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void rangeUnBordered() {
		new InRangeSimple(null, true, null, true);
	}
}
