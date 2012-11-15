package com.example.mafia;

public class PhaseAfternoon {
	//this class is used to narrate the data collected during the night and morning
	
	DataPasser dataPasser=new DataPasser();
	Narrator narrator = new Narrator();
	
	public void startPhase()
	{
		narrator.NarrateRound(dataPasser.getRoundNarrationData());
	}
}
