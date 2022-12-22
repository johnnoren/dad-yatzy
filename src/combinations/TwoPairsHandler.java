package combinations;

import dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class TwoPairsHandler extends CombinationHandlerDecorator {

	@Override
	public List<Combination> handle(List<Dice> diceList) {

		var originalDiceList = new ArrayList<>(diceList);

		var pairsList = getFrequencyGroups(diceList,2);

		var combinationList = getPossiblePairCombinations(pairsList);

		combinationList.addAll(nextHandler.handle(originalDiceList));

		return combinationList;
	}

	private List<Combination> getPossiblePairCombinations(List<List<Dice>> pairsList) {
		var twoPairsList = new ArrayList<Combination>();
		while (pairsList.size() > 1) {
			var pair = pairsList.remove(0);
			pairsList.forEach(secondPair -> {
				var bothPairs = new ArrayList<Dice>();
				bothPairs.addAll(pair);
				bothPairs.addAll(secondPair);
				twoPairsList.add(new Combination("Two Pairs", getSum(bothPairs), bothPairs));
			});
		}
		return twoPairsList;
	}

}
