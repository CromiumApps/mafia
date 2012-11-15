package com.example.mafia;

public class PhaseAfternoon {
	//this class is used to narrate the data collected during the night and morning
	
	DataPasser dataPasser=new DataPasser();
	Narrator narrator = new Narrator();
	
	public void startPhase()
	{
		narrator.NarrateRound(dataPasser.getRoundNarrationData());
		
		while(isNarrationCompleted()==false)
		{
			//loop and wait for everyone else to be done with the narration
		}
	}
	
	private boolean isNarrationCompleted()
	{
		boolean isNarrationCompleted=false;
		
		isNarrationCompleted = dataPasser.getNarrationCompletedStatus();
		
		return isNarrationCompleted;
	}
	
}
