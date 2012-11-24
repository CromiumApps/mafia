package com.example.mafia;

public class PhaseNight {
	DataPasser dataPasser = new DataPasser();
	
	public void startPhase(Player MyPlayer) {
		switch (MyPlayer.getType()) {
			case 0:
				break; // Civilians do nothing during this phase
			case 1:
				mafiaPhase();
				break;
			case 2:
				milkmanPhase();
				break;
			case 3:
				detectivePhase();
				break;
			case 4:
				doctorPhase();
				break;
		}
		
		dataPasser.sendDataEntryCompleted();

		while(isNightDataEntryCompleted() == false) {
			// Do nothing. We may want to replace this with a timer, or at the very least add a timer to this function so so we don't have a shit-ton of calls per second.
		}

		return;
	}
	
	private boolean isNightDataEntryCompleted() {
		boolean isNightDataEntryCompleted = false;
		
		isNightDataEntryCompleted = dataPasser.getNightDataEntryCompletedStatus();
		
		return isNightDataEntryCompleted;
	}
	
	private void mafiaPhase() {
		Player playerKilledByMafia = new Player();
		
		// Based on UI, accept player input for character choice
		// PlayerKilledByMafia = your choice
		// Because there are two mafia, we need some sort of collaborative voting method...
	
		dataPasser.sendPlayerKilledByMafia(playerKilledByMafia);
	}
	
	private void milkmanPhase() {
		Player playerGivenMilk = new Player();
		int milkType;

		// Based on UI, accept player input for choice of milkType
		// if(good) milkType = 0 else milkType = 1;
		// Based on UI, accept player input for character choice of player
		// playerGivenMilk = your choice

		dataPasser.sendPlayerGivenMilk(playerGivenMilk, milkType);
	}
	
	private void detectivePhase() {
		Narrator narrator = new Narrator();
		Player playerDetected = new Player();

		// Based on UI, accept player input for character choice
		// playerDetected = your choice
		narrator.sequentialPrint("This player is ");
		if(dataPasser.getPlayerInfo(playerDetected) == 1) narrator.sequentialPrint("one of the mafia.");
		else if(dataPasser.getPlayerInfo(playerDetected) == 2) narrator.sequentialPrint("the milkman.");
		else if(dataPasser.getPlayerInfo(playerDetected) == 4) narrator.sequentialPrint("the doctor.");
		else narrator.sequentialPrint("a civilian.");
		// Obviously, the detective shouldn't be able to select himself.
	}
	
	private void doctorPhase()
	{
		Player playerSaved = new Player();

		// Based on UI, accept player input for character choice
		// playerSaved = your choice		
	
		dataPasser.sendPlayerSaved(playerSaved);
	}
}
