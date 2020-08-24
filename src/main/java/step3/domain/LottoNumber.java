package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
	public static final int MIN_LOTTO_VALUE = 1;
	public static final int MAX_LOTTO_VALUE = 45;
	private static final List<LottoNumber> LOTTO_VALUES = new ArrayList<>();
	private static final String LOTTO_NUMBER_PHRASES = "로또 당첨 번호는 1 이상 45 이하의 숫자여야 합니다.";

	private final int number;

	static {
		for (int i = 0; i < LottoNumber.MAX_LOTTO_VALUE; i++) {
			LOTTO_VALUES.add(new LottoNumber(i+1));
		}
	}

	public LottoNumber(int number) {
		validLottoNumber(number);
		this.number = number;
	}

	private void validLottoNumber(int number) {
		if (number < MIN_LOTTO_VALUE || number > MAX_LOTTO_VALUE) {
			throw new IllegalArgumentException(LOTTO_NUMBER_PHRASES);
		}
	}

	public static List<LottoNumber> getLottoValues() {
		return LOTTO_VALUES;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof LottoNumber) {
			LottoNumber anotherNumber = (LottoNumber) obj;
			return this.number == anotherNumber.number;
		}
		return false;
	}

	@Override
	public int compareTo(LottoNumber number) {
		return Integer.compare(this.number, number.number);
	}
}
