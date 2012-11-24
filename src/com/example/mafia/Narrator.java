package com.example.mafia;

public class Narrator {
	public narrateRound(RoundData data) {
		//data.killed
		//data.saved
		//data.givenMilk
		//data.milkGood
		//data.drankMilk

		// Creates narration based on round events, calls sequentialPrint with a string output
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
