package com.example.mafia;

public class DataPasser {

	// Send to database
	public void sendPlayerKilledByMafia(Player killed) {
		
	}
	
	public void sendPlayerGivenMilk(Player given, int milkType) {
		
	}
	
	// FIX THIS BY REMOVING
	public void sendPlayerDetected(Player choice) {
		
	}
	
	public void sendPlayerSaved(Player saved) {
		
	}
	
	public void sendMilkConsumedStatus(boolean drankMilk) {
		
	}
	
	public void sendVote(int ID) {
		// Sends vote to database, which will count them and return (via getVoteResult()) the winner.... er, loser.
	}

	public void sendDataEntryCompleted() {
		// Send "I'm done" to database. May want to also send ID
	}

	public void sendRoundNarrationCompleted() {
		// Send "I've read this" to database
	}

	public int getNumberOfPlayersByID(int id) {
		int num;

		// return the number of players with a given ID
			num = 3;

		return num;
	}


	// Get from database
	public Player getMyPlayer() {
		Player myPlayer = new Player();
		
		// Get int ID and String name from database
		myPlayer.setID(int ID);
		myPlayer.setName(String name);

		return myPlayer;
	}

	public int getPlayerInfo(Player detected) {
		int ID;

		// This line needs to access the database
		ID = detected.ID;

		return ID;
	}

	public Player getMilkmanChoice() {
		Player milkmanChoice = new Player();

		// Get Player milkmanChoice from database
		
		return milkmanChoice;
	}

	public Player getDoctor() {
		Player doctor = new Player();

		// Get Player doctor from database

		return doctor;
	}

	public RoundData getRoundNarrationData() {
		RoundData data = null;
		
		// Get info required to create new RoundData class. Ie, playerKilled, playerSaved, milkDrank....

		return data;
	}
	
	public int getVoteResult() {
		int resultID;

		// Get int ID from database
		resultID = 0001; // Obviously, 0001 is a dummy number
		
		return resultID;
	}
	
	public boolean getVoteCompletedStatus() {
		boolean isVoteCompleted = false;

		// Check if vote is completed. Related: sendVote()

		// If every player has submitted their vote
			isVoteCompleted = true;
		
		return isVoteCompleted;
	}

	public boolean getNightDataEntryCompletedStatus() {
		boolean nightDataEntryCompleted = false;

		// Check if data entry is completed. Related: sendDataEntryCompleted()

		// If every player has entered their data (if required)
			nightDataEntryCompleted = true;
		
		return nightDataEntryCompleted;
	}

	public boolean getDrinkingCompletedStatus() {
		boolean drinkingCompleted = false;
		
		// If playerReceivedMilk said said yes or no... Related: sendMilkConsumedStatus()
			drinkingCompleted = true;
		
		return drinkingCompleted;
	}

	public boolean getRoundNarrationCompleted() {
		boolean isRoundComplete = false;

		// If everyone has read the narration... Related: sendRoundNarrationCompleted()
			isRoundComplete = true;

		return isRoundComplete;
	}


	// Game state
	public int isGameOver() {
		if(getNumberOfPlayersByID(1) == 0) return 1; // Civilians win
		if(getNumberOfPlayersByID(0) == 0 && getNumberOfPlayersByID(2) == 0 && getNumberOfPlayersByID(3) == 0 && getNumberOfPlayersByID(4) == 0) return 2; // Mafia wins
		else return 0; // No one won... yet
	}
}