package combinations;

import dice.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SmallStraightHandler extends BaseCombinationHandler {

	@Override
	public List<Combination> handle(List<Dice> diceList) {

		var straightDiceList = getStraight(diceList, 1, diceList.size() - 1);

		var combinationList = new ArrayList<Combination>();
		if (!straightDiceList.isEmpty()) {
			combinationList.add(new Combination("Small Straight", getSum(straightDiceList), straightDiceList));
		}

		combinationList.addAll(nextHandler.handle(diceList));

		return combinationList;
	}

}
