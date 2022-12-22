package combinations;

import dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class EmptyCombinationHandler implements CombinationHandler {

	@Override
	public CombinationHandler append(CombinationHandler combinationHandler) {
		return combinationHandler;
	}

	@Override
	public List<Combination> handle(List<Dice> diceList) {
		return new ArrayList<>();
	}

}
