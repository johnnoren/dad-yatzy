package combinations;

import dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class BaseCombinationHandler extends CombinationHandler {

	@Override
	public List<Combination> handle(List<Dice> diceList) {
		return new ArrayList<>();
	}

	@Override
	public CombinationHandler append(CombinationHandler o) {
		return o;
	}

}
