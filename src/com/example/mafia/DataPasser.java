package com.example.mafia;

public class DataPasser {
//Fill this class with dummy data
	
	public void sendPlayerKilledByMafia(Player killed)
	{
		
	}
	
	public void sendPlayerGivenMilk(Player given, int milkType)
	{
		
	}
	
	public void sendPlayerDetected(Player choice)
	{
		
	}
	
	public void passDoctor(Player saved)
	{
		
	}
	
	//gets the user's player from the database
	public Player getMyPlayer()
	{
		Player MyPlayer =new Player();
		//fake data here
		MyPlayer.setType(1);
		MyPlayer.setName("Habeeb Ahmed");

		return MyPlayer;
	}
	
	public RoundData getNarrationData()
	{
		RoundData data=null;
		// Get data from database
		return data;
	}
	
}
