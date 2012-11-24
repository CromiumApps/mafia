package com.example.mafia;

public class Narrator {
	public void narrateRound(RoundData data) {
		//data.killed
		//data.saved
		//data.givenMilk
		//data.milkGood
		//data.drankMilk

		// What if doctor saves himself?
		// He/she

		if(data.drankMilk) {
			if(data.milkGood) {
				if(data.givenMilk == data.killed) {
					savedByTheMilk = new String[1]; // Add more later

					savedByTheMilk[0] = " opened his front foor this morning and found a tall glass of fresh milk sitting on his doorstep. He took a deep sip of the refreshing liquid and noticed a car with tinted windows race past him. As it passed him, shots rang out: weapon fire from at least three different submachine guns. As if protected by magic, each and every bullet missed him, and crashed into the ground beneath his feet. He quickly finished his milk and went inside.";

					sequentialPrint(data.killed.getName() + savedByTheMilk[0]);

					return;
				}
			}
			else {
				if(data.givenMilk != data.saved) {
					badMilk = new String[1]; // Add more later

					badMilk[0] = " was delivered a fresh cup of milk by the friendly neighbourhood milkman this morning. His mouth watering, he quickly drained the glass. After only a moment, though, his throat began to constrict, and he fell to the ground, unable to breath.";

					sequentialPrint(data.givenMilk + badMilk[0]);

					break;
				}
				else {
					badMilkGoodDoctor = new String[1]; // Add more later

					badMilkGoodDoctor[0] = " opened his fridge this morning to find a jug of milk he didn't remember buying. Normally he'd be suspicious, but he was really thirsty this morning. He took a long drink before he realised the milk was bad. And not just bad: it was poisoned, and he was dying. He had fallen to the floor, hardly able to breath, when suddenly, out of nowhere, a doctor appeared and saved his life. They had never met, but somehow, for some reason no one will ever know, the doctor appeared at just the right moment, with just the right antidote.";

					sequentialPrint(data.givenMilk + badMilkGoodDoctor[0]);

					break;
				}
			}
		}

		if(data.killed == data.saved) {
			luckyDoctor = new String[1]; // Add more later

			luckyDoctor[0] = " was walking to his mailbox this morning when he noticed that the sky was rapidly darkening. He looked up in confusion, only to find a piano falling towards him. He hardly had time to scream before the piano crushed him to death, but scream he did. Fortunately for him, a local passerby heard his scream, sprinted over to him, and pushed him out of the way of the piano.";

			sequentialPrint(data.killed + luckyDoctor[0]);

			return;
		}
		else {
			unluckyVictim = new String[1]; // Add more later

			unluckyVictim[0] = " took the bus to work this morning. Just as he had gotten off the bus and was walking toward his office, he fell into a large hole in the sidewalk. Sadly, it was filled with spikes, and he died instantly.";

			sequentialPrint(data.killed + unluckyVictim[0]);

			return;
		}
	}

	public void narrateVote(int votedOut) {
		// Uses sequentialPrint to print a vote status message
		// Should include a check to see whether isGameOver() != 0, or this could be done during PhaseEvening
	}

	public void narrateEnding(int whoWon) {
		if(whoWon == 1) {
			// Civilians won, use sequentialPrint to print a random civilian endgame
		}

		if(whoWon == 2) {
			// Mafia won, use sequentialPrint to print a random mafia endgame
		}

		// Show stats? Return to main menu. Check GameActivity as to where this code should be
	}
	
	private void sequentialPrint(String print) {
		// Prints in a scrolling fashion
	}
}
