package combinations;

import dice.Dice;

import java.util.List;

public class Combination {

	private final String name;
	private final Integer points;
	private final List<Dice> dice;

	public String getName() {
		return name;
	}

	public Integer getPoints() {
		return points;
	}

	Combination(String name, Integer points, List<Dice> dice) {
		this.name = name;
		this.points = points;
		this.dice = dice;
	}

	public List<Dice> getDice() {
		return dice;
	}

	@Override
	public String toString() {
		return "Combination{" + "name='" + name + '\'' + ", points=" + points + ", dice=" + dice + '}';
	}

}
