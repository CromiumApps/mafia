package com.example.mafia;

public class PhaseMorning {
	// This is when the player who received milk decides to drink it or not

	DataPasser dataPasser = new DataPasser();
	
	public void startPhase(Player myPlayer) {
		DataPasser dataPasser = new DataPasser();
		
		if(myPlayer == dataPasser.getMilkmanChoice()) {
			// Based on UI, accept player choice of yes/no
			boolean drankMilk = true; // false if the choice was no... obviously
			
			dataPasser.sendMilkConsumedStatus(drankMilk);
		}
		else {
			while(!isMilkDrinkingChosen()) {
				// Do nothing until player has chosen to drink the milk or not. Check on a timer so there aren't billions of function calls?
			}
		}

		return;
	}
	
	private boolean isMilkDrinkingChosen() {
		boolean isMilkDrinkingChosen = false;
		
		isMilkDrinkingChosen = dataPasser.getDrinkingCompletedStatus();
		
		return isMilkDrinkingChosen;
	}
}
