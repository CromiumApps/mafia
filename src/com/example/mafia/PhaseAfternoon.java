package com.example.mafia;

public class PhaseAfternoon {
	// This is when everyone finds out what happened last night (ie, the Narrator uses RoundData to explain everything)
	
	DataPasser dataPasser = new DataPasser();
	Narrator narrator = new Narrator();
	
	public void startPhase() {
		narrator.narrateRound(dataPasser.getRoundNarrationData());
		
		while(!isNarrationCompleted()) {
			// Do nothing until everyone has read the narration. A timer to avoid infinite function calls would be a good idea.
		}

		return;
	}
	
	private boolean isNarrationCompleted()
	{
		boolean isNarrationCompleted=false;
		
		isNarrationCompleted = dataPasser.getNarrationCompletedStatus();
		
		return isNarrationCompleted;
	}
	
}
