package com.example.mafia;

public class DataPasser {
//Fill this class with dummy data
	
	//sending code
	//send data to database
	public void sendPlayerKilledByMafia(Player killed)
	{
		
	}
	
	public void sendPlayerGivenMilk(Player given, int milkType)
	{
		
	}
	
	public void sendPlayerDetected(Player choice)
	{
		
	}
	
	public void sendPlayerSaved(Player saved)
	{
		
	}
	
	public void sendMilkConsumedStatus (boolean drankMilk)
	{
		
	}
	
	public void sendVote(int ID)
	{
		
	}
	
	//get code
	//get data from database

	public Player getMyPlayer()
	{
		Player MyPlayer =new Player();
		//fake data here
		MyPlayer.setType(1);
		MyPlayer.setName("Habeeb Ahmed");

		return MyPlayer;
	}
	public Player getMilkmanChoice() 
	{
		Player milkmanChoice=new Player();
		//get the choice of the milkman
		
		return milkmanChoice;
	}
	public RoundData getRoundNarrationData()
	{
		RoundData data=null;
		// Get data from database and assign it to data
		return data;
	}
	
	public int getVoteResult()
	{
		int resultID;
		// get data from database 
		// fake data
		resultID=0001;
		
		return resultID;
	}
	
	public boolean getVotesCompletedStatus()
	{
		boolean isVotesCompleted=false;
		//check if votes are completed using database
		//fake data
		isVotesCompleted=true;
		
		return isVotesCompleted;
	}

	public boolean getNightDataEntrygCompletedStatus() {
		boolean NightDataEntrygCompleted=false;
		//check if night data entry is completed using database
		//fake data
		NightDataEntrygCompleted=true;
		
		return NightDataEntrygCompleted;
	}

	public boolean getDrinkingCompletedStatus() {
		boolean DrinkingCompleted=false;
		//check if drinking is completed using database
		//fake data
		DrinkingCompleted=true;
		
		return DrinkingCompleted;
	}

	public boolean getNarrationCompletedStatus() {
		boolean NarrationCompleted=false;
		//check if Narration Completed is completed using database
		//fake data
		NarrationCompleted=true;
		
		return NarrationCompleted;
	}
	
	
}
