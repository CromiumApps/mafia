package com.example.mafia;
import java.util.Random;

public class Narrator {
	public void narrateRound(RoundData data) {
		Random random = new Random();
		int n, m;

		if(data.drankMilk) {
			if(data.milkGood) {
				if(data.givenMilk == data.killed) {
					n = 1;
					savedByTheMilk = new String[n]; // Add more later

					savedByTheMilk[0] = " opened his front foor this morning and found a tall glass of fresh milk sitting on his doorstep. He took a deep sip of the refreshing liquid and noticed a car with tinted windows race past him. As it passed him, shots rang out: weapon fire from at least three different submachine guns. As if protected by magic, each and every bullet missed him, and crashed into the ground beneath his feet. He quickly finished his milk and went inside.";

					random.nextInt(n);

					sequentialPrint(data.killed.getName() + savedByTheMilk[random]);

					if(isGameOver()) narrateEnding(isGameOver());
					else return;
				}
			}
			else {
				if(data.givenMilk != data.saved) {
					n = 1;
					badMilk = new String[n]; // Add more later

					badMilk[0] = " was delivered a fresh cup of milk by the friendly neighbourhood milkman this morning. His mouth watering, he quickly drained the glass. After only a moment, though, his throat began to constrict, and he fell to the ground, unable to breath.";

					random.nextInt(n);

					sequentialPrint(data.givenMilk + badMilk[random]);

					break;
				}
				else {
					n = 1;
					badMilkGoodDoctor = new String[n]; // Add more later

					badMilkGoodDoctor[0] = " opened his fridge this morning to find a jug of milk he didn't remember buying. Normally he'd be suspicious, but he was really thirsty this morning. He took a long drink before he realised the milk was bad. And not just bad: it was poisoned, and he was dying. He had fallen to the floor, hardly able to breath, when suddenly, out of nowhere, a doctor appeared and saved his life. They had never met, but somehow, for some reason no one will ever know, the doctor appeared at just the right moment, with just the right antidote.";

					m = 1;
					badMilkOwnDoctor = new String[m]; // Add more later

					badMilkOwnDoctor[0] = " drank some terrible milk this morning. Fortunately, he already had the antidote in his system, thanks to a prescient doctor. He'll be OK.";

					if(dataPasser.getDoctor() == data.saved) random.nextInt(m);
					else random.nextInt(n);

					sequentialPrint(data.givenMilk + badMilkGoodDoctor[random]);

					break;
				}
			}
		}

		if(data.killed == data.saved) {
			n = 1;
			luckyDoctor = new String[n]; // Add more later

			luckyDoctor[0] = " was walking to his mailbox this morning when he noticed that the sky was rapidly darkening. He looked up in confusion, only to find a piano falling towards him. He hardly had time to scream before the piano crushed him to death, but scream he did. Fortunately for him, a local passerby heard his scream, sprinted over to him, and pushed him out of the way of the piano.";

			m = 1;
			saveYourself = new String[m];

			saveYourself[0] = " was hit by a car this morning. Fortunately, there was a doctor nearby who managed to re-attach his head before he could lose too much blood. He'll be fully recovered shortly."

			if(dataPasser.getDoctor() == data.saved) random.nextInt(m);
			else { random.nextInt(n);

			sequentialPrint(data.killed + luckyDoctor[random]);

			if(isGameOver()) narrateEnding(isGameOver());
			else return;
		}
		else {
			n = 1;
			unluckyVictim = new String[n]; // Add more later

			unluckyVictim[0] = " took the bus to work this morning. Just as he had gotten off the bus and was walking toward his office, he fell into a large hole in the sidewalk. Sadly, it was filled with spikes, and he died instantly.";

			random.nextInt(n);

			sequentialPrint(data.killed + unluckyVictim[random]);

			if(isGameOver()) narrateEnding(isGameOver());
			else return;
		}
	}

	public void narrateVote(int votedOut) {
		// Uses sequentialPrint to print a vote status message
		mostHated = new String[n];


		if(isGameOver()) narrateEnding(isGameOver());
		else return;
	}

	public void narrateEnding(int whoWon) {
		if(whoWon == 1) {
			int n = 1;
			weKillTheKillers = new String[n];

			weKillTheKillers[0] = "The sun rose over a new day. The streets were clean, the sky bright, and people had stopped dying for no apparent reason. Throughout the city, people rejoiced, for the mafia were dead. Congratulations, civilian!";

			random.nextInt(n);

			sequentialPrint(weKillTheKillers[random]);
		}

		if(whoWon == 2) {
			int n = 1;
			idiotPlebeians = new String[n];

			idiotPlebeians[0] = "The city is yours, cleansed of all the civilians you could find. Of course, now there are no doctors, firemen, public service workers... other people... But, anyway, you accomplished what you set out to do, so congratulations!";

			random.nextInt(n);

			sequentialPrint(idiotPlebeians[random]);
		}

		return;
	}
	
	private void sequentialPrint(String print) {
		// Based on UI, prints in a scrolling fashion to the text box
	}
}
