package combinations;

import dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class LargeStraightHandler extends BaseCombinationHandler {

	@Override
	public List<Combination> handle(List<Dice> diceList) {

		var straightDiceList = getStraight(diceList, 2, diceList.size());

		var combinationList = new ArrayList<Combination>();
		if (!straightDiceList.isEmpty()) {
			combinationList.add(new Combination("Large Straight", getSum(straightDiceList), straightDiceList));
		}

		combinationList.addAll(nextHandler.handle(diceList));

		return combinationList;
	}

}
