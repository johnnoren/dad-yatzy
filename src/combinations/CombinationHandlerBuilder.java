package combinations;

public abstract class CombinationHandlerBuilder implements CombinationHandler {

	private CombinationHandler nextHandler = new EmptyCombinationHandler();

	public CombinationHandlerBuilder append(CombinationHandler combinationHandler) {
		nextHandler = nextHandler.append(combinationHandler);
		return this;
	}
}
