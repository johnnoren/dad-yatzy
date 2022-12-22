package combinations;

import dice.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FourOfAKindHandler extends CombinationHandlerDecorator {

	@Override
	public List<Combination> handle(List<Dice> diceList) {

		var originalDiceList = new ArrayList<>(diceList);

		var fourOfAKindList = getFrequencyGroups(diceList, 4);

		var combinationList = fourOfAKindList.stream()
				.map(fourOfAKind -> new Combination("Four Of A Kind", getSum(fourOfAKind), fourOfAKind))
				.collect(Collectors.toList());

		combinationList.addAll(nextHandler.handle(originalDiceList));

		return combinationList;
	}
	
}
