package dice;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Dice {
	private final Integer maxValue;
	private final Integer minValue;
	private Integer value;

	protected Dice(Integer maxValue, Integer minValue) {
		this.maxValue = maxValue;
		this.minValue = minValue;
		roll();
	}

	void roll(){
		value = ThreadLocalRandom.current().nextInt(minValue, maxValue+1);
	}

	public Integer getValue(){
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Dice)) {
			return false;
		}

		var dice = (Dice) obj;

		return getValue().equals(dice.getValue());
	}

}
