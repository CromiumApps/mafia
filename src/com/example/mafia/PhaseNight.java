package com.example.mafia;

public class PhaseNight {
	//this class is used for the night activities
	
	DataPasser dataPasser = new DataPasser();
	
	
	public void startPhase(Player MyPlayer)
	{
		switch (MyPlayer.getType())
		{
			case 0:
				civilianPhase();
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

		while(isNightDataEntryCompleted()==false)
		{
			//loop and wait for everyone else to be done with the night actions
		}
		
	}
	
	private boolean isNightDataEntryCompleted()
	{
		boolean isNightDataEntryCompleted=false;
		
		isNightDataEntryCompleted = dataPasser.getNightDataEntrygCompletedStatus();
		
		return isNightDataEntryCompleted;
	}
	
	private void civilianPhase()
	{
		// Narrates stuff, but you don't do anything
	}
	
	private void mafiaPhase()
	{
		Player PlayerKilledByMafia=new Player();
		//program voting stuff
		
		dataPasser.sendPlayerKilledByMafia(PlayerKilledByMafia);
	}
	
	private void milkmanPhase()
	{
		Player playerGivenMilk= new Player();
		int milktype=0;
		//program milk giving stuff here
		
		dataPasser.sendPlayerGivenMilk(playerGivenMilk, milktype);
	}
	
	private void detectivePhase()
	{
		Player playerDetected=new Player();
		// program Detective choices
		
		dataPasser.sendPlayerDetected(playerDetected);
	}
	
	private void doctorPhase()
	{
		Player playerSaved=new Player();
		// program Doctor choices
		
		dataPasser.sendPlayerSaved(playerSaved);
	}
}
