package com.example.mafia;

public class PhaseNight {
	DataPasser DataPasser = new DataPasser();
	
	
	public void startPhase(Player p)
	{
		switch (p.getType())
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
		// shows stuff, but you don't do anything
	}
	
	private void mafiaPhase()
	{
		// Do mafia stuff
		DataPasser.passMafia(Player killed);
	}
	
	private void milkmanPhase()
	{
		// Milkman stuff
		DataPasser.passMilkman(Player given, int milkType)
	}
	
	private void detectivePhase()
	{
		// Detective choices
		DataPasser.passDetective(Player choice);
	}
	
	private void doctorPhase()
	{
		// Doctor choices
		DataPasser.passDoctor(Player saved);
	}
}
