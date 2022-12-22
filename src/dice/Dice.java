package dice;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Dice {
	private final Integer maxValue;
	private final Integer minValue;
	private Integer value;

	protected Dice(Integer minValue, Integer maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		roll();
	}

	public void roll(){
		value = ThreadLocalRandom.current().nextInt(minValue, maxValue+1);
	}

	public Integer getValue(){
		return value;
	}

	@Override
	public String toString() {
		return "Dice{" + "value=" + value + '}';
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
