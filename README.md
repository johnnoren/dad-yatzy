# dad-yatzy
Individuell uppgift i kursen Designmönster, analys och design. Paket som underlättar vid skapandet av Yatzy-baserade spel.

## Funktionalitet

- Få ut en lista med möjliga kombinationer (triss, fyrtal, kåk etc.) för ett tärningskast.
- Möjlighet att själv välja vilka kombinationer som ska utvärderas.
- Lägg till / ta bort / ändra kombinationer på ett lätt sätt.
- Möjlighet att använda andra typer av tärningar eller annat antal tärningar.
  
## Snabbstart
  
  ```java
		// Välj vilka kombinationer som ska utvärderas genom att göra append på en BaseCombinationHandler.
		var combinationHandler = new BaseCombinationHandler()
				.append(new OnePairHandler())
				.append(new TwoPairsHandler())
				.append(new ThreeOfAKindHandler())
				.append(new FourOfAKindHandler())
				.append(new SmallStraightHandler())
				.append(new LargeStraightHandler());

    // Skapa ett tärningskast med 5 vanliga tärningar (1-6).
		List<Dice> diceList = Stream.generate(CubeDice::new)
				.limit(5)
				.collect(Collectors.toList());

		// Skriv ut tärningskastet
		diceList.forEach(System.out::println);

		// Få ut en lista med vilka kombinationer tärningskastet innehåller
		var combinationList = combinationHandler.handle(diceList);
    
    // Skriv ut kombinationerna
    combinationList.forEach(System.out::println);
    ```
    
