package combinations;

import dice.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OnePairHandler extends BaseCombinationHandler {

	@Override
	public List<Combination> handle(List<Dice> diceList) {

		var pairsList = getFrequencyGroups(diceList, 2);

		var combinationList = pairsList.stream()
				.map(list -> new Combination("One Pair", getSum(list), list))
				.collect(Collectors.toList());

		combinationList.addAll(nextHandler.handle(diceList));

		return combinationList;
	}

}
