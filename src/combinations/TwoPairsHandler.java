package combinations;

import dice.Dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TwoPairsHandler extends BaseCombinationHandler {

	@Override
	public List<Combination> handle(List<Dice> diceList) {
		var pairsList = getFrequencyGroups(diceList,2);

		var combinationList = getPossiblePairCombinations(pairsList);

		combinationList.addAll(nextHandler.handle(diceList));

		return combinationList;
	}

	private List<Combination> getPossiblePairCombinations(List<List<Dice>> pairsList) {
		var twoPairsList = new ArrayList<Combination>();
		while (pairsList.size() > 1) {
			var pair = pairsList.remove(0);
			pairsList.forEach(secondPair -> {
				pair.addAll(secondPair);
				twoPairsList.add(new Combination("Two Pairs", getSum(pair), pair));
			});
		}
		return twoPairsList;
	}

}
