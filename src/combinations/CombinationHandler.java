package combinations;

import dice.Dice;

import java.util.List;

public interface CombinationHandler {
List<Combination> handle(List<Dice> diceList);
}
