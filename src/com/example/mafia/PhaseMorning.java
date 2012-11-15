package com.example.mafia;

public class PhaseMorning {
	//this class is used for checking wether or not the person given the milk will drink or not
	DataPasser dataPasser = new DataPasser();
	
	public void startPhase(Player MyPlayer)
	{
		DataPasser dataPasser=new DataPasser();
		if(MyPlayer==dataPasser.getMilkmanChoice())
		{
			boolean drankMilk=true;
			// Choose to open it or not
			
			dataPasser.sendMilkConsumedStatus( drankMilk);
		}
		else
		{
			// Narration of whether or not the chosen player is drinking the milk
			
			while(isMilkDrinkingCompleted()==false)
			{
				//loop and wait...for player to drink milk
			}
		}		
	}
	
	private boolean isMilkDrinkingCompleted()
	{
		boolean isMilkDrinkingCompleted=false;
		
		isMilkDrinkingCompleted = dataPasser.getDrinkingCompletedStatus();
		
		return isMilkDrinkingCompleted;
	}
}
