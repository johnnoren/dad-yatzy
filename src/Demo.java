import combinations.*;
import dice.CubeDice;
import dice.Dice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

	public static void main(String[] args) {
		new Demo().run();
	}

	private void run() {

		// Create the combination handler.
		var combinationHandler = new BaseCombinationHandler()
				.append(new OnePairHandler())
				.append(new TwoPairsHandler())
				.append(new ThreeOfAKindHandler())
				.append(new FourOfAKindHandler())
				.append(new SmallStraightHandler())
				.append(new LargeStraightHandler());

		// Create a list of five dice simulating a throw with all dice.
		List<Dice> diceList = Stream.generate(CubeDice::new)
				.limit(5)
				.collect(Collectors.toList());

		// Print the list
		diceList.forEach(System.out::println);

		// Let the handler process the list of dice
		var combinationList = combinationHandler.handle(diceList);

		// Print out the returned combinations.
		combinationList.forEach(System.out::println);





	}

}