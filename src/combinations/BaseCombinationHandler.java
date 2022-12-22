package combinations;

import dice.Dice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class BaseCombinationHandler implements CombinationHandler {



	protected Integer getSum(List<Dice> diceList) {
		return diceList.stream()
				.mapToInt(Dice::getValue)
				.sum();
	}

	protected List<List<Dice>> getFrequencyGroups(List<Dice> diceList, Integer frequency) {
		var frequencyList = new ArrayList<List<Dice>>();
		while (!diceList.isEmpty()) {
			var dice = diceList.remove(0);

			if (diceList.containsAll(Collections.nCopies(frequency - 1, dice))) {

				for (int i = 1; i < frequency; i++) {
					diceList.remove(dice);
				}

				frequencyList.add(Collections.nCopies(frequency, dice));
			}
		}
		return frequencyList;
	}

	protected List<Dice> getStraight(List<Dice> diceList, Integer startValue, Integer endValue) {
		 var valuesList = IntStream.range(startValue, endValue + 1)
						 .boxed()
						 .collect(Collectors.toList());

		 if (containsValues(diceList,valuesList)) {
			 return valuesList.stream()
					 .map(value -> diceList.stream()
							 .filter(dice -> dice.getValue().equals(value))
							 .findFirst().get())
					 .collect(Collectors.toList());
		 }
		 return Collections.emptyList();

	}

	protected Boolean containsValues(List<Dice> diceList, List<Integer> values) {
		return values.stream()
				.map(value -> diceList.stream()
						.map(Dice::getValue)
						.anyMatch(diceValue -> diceValue.equals(value)))
				.allMatch(match -> match.equals(true));
	}


}