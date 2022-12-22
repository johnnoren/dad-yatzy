package combinations;

import dice.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeOfAKindHandler extends CombinationHandlerDecorator {

	@Override
	public List<Combination> handle(List<Dice> diceList) {

		var originalDiceList = new ArrayList<>(diceList);

		var threeOfAKindList = getFrequencyGroups(diceList, 3);

		var combinationList = threeOfAKindList.stream()
				.map(threeOfAKind -> new Combination("Three Of A Kind", getSum(threeOfAKind), threeOfAKind))
				.collect(Collectors.toList());

		combinationList.addAll(nextHandler.handle(originalDiceList));

		return combinationList;
	}

}
