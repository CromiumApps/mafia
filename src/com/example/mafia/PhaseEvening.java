package com.example.mafia;

public class PhaseEvening {
	DataPasser dataPasser=new DataPasser();
	
	public void startPhase(Player p)
	{
		// get the votes
		dataPasser.sendVote(getVote());
		
		//wait until all players have voted
		while(isVotesCompleted()==false)
		{
			//loop and wait...
		}
		//display the results
		displayResult();
	}
	
	private boolean isVotesCompleted()
	{
		boolean isVoteCompleted=false;
		
		isVoteCompleted = dataPasser.getVotesCompletedStatus();
		
		return isVoteCompleted;
	}

	private int getVote()
	{
		// Get's your vote and returns it as the ID of the player you chose
		Player playerVotedOn=new Player();
		
		return playerVotedOn.getID();
	}
	
	private void displayResult()
	{
		int resultID = dataPasser.getVoteResult();
		
	}
	
}
