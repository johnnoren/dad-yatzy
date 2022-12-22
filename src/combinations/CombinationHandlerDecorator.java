package combinations;

public abstract class CombinationHandlerDecorator extends CombinationHandler {

	protected CombinationHandler nextHandler = new BaseCombinationHandler();

	public CombinationHandler append(CombinationHandler combinationHandler) {
		nextHandler = nextHandler.append(combinationHandler);
		return this;
	}
}
