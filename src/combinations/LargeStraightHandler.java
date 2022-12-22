package combinations;

import dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class LargeStraightHandler extends CombinationHandlerDecorator {

	@Override
	public List<Combination> handle(List<Dice> diceList) {

		var originalDiceList = new ArrayList<>(diceList);

		var straightDiceList = getStraight(diceList, 2, 6);

		var combinationList = new ArrayList<Combination>();
		if (!straightDiceList.isEmpty()) {
			combinationList.add(new Combination("Large Straight", getSum(straightDiceList), straightDiceList));
		}

		combinationList.addAll(nextHandler.handle(originalDiceList));

		return combinationList;
	}

}
