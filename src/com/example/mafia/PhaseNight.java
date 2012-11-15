package com.example.mafia;

public class PhaseNight {
	DataPasser DataPasser = new DataPasser();
	
	
	public void startPhase(Player MyPlayer)
	{
		switch (MyPlayer.getType())
		{
			case 0:
				civilianPhase();
				break; // Civilian's do nothing during this phase
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
	}
	
	private void civilianPhase()
	{
		// Narrates stuff, but you don't do anything
	}
	
	private void mafiaPhase()
	{
		Player PlayerKilledByMafia=new Player();
		//program voting stuff
		
		DataPasser.sendPlayerKilledByMafia(PlayerKilledByMafia);
	}
	
	private void milkmanPhase()
	{
		Player playerGivenMilk= new Player();
		int milktype=0;
		//program milk giving stuff here
		
		DataPasser.sendPlayerGivenMilk(playerGivenMilk, milktype);
	}
	
	private void detectivePhase()
	{
		Player playerDetected=new Player();
		// program Detective choices
		
		DataPasser.sendPlayerDetected(playerDetected);
	}
	
	private void doctorPhase()
	{
		Player playerSaved=new Player();
		// program Doctor choices
		DataPasser.passDoctor(playerSaved);
	}
}
