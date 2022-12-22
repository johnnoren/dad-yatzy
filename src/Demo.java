import dice.CubeDice;

import java.util.stream.Stream;

public class Demo {

	public static void main(String[] args) {
		new Demo().run();
	}

	private void run() {

		Stream.generate(CubeDice::new)
				.limit(100)
				.forEach((cubeDice -> {
					cubeDice.roll();
					System.out.println(cubeDice.getValue());
				}));
	}

}