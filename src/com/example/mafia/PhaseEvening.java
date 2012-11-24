// Please include a check to dataPasser.isGameOver(). 0 -> no, 1 -> civilians win, 2 -> mafia wins. Pass this to narrator

package com.example.mafia;

public class PhaseEvening {
	DataPasser dataPasser = new DataPasser();
	Narrator narrator = new Narrator();
	
	public void startPhase() {
		dataPasser.sendVote(getVote());
		
		while(!isVoteCompleted()) {
			// Do nothing until everyone has voted. A timer would be a good idea here
		}

		narrator.narrateVote(dataPasser.getVoteResult());

		return;
	}
	
	private boolean isVoteCompleted() {
		boolean isVoteCompleted = false;
		
		isVoteCompleted = dataPasser.getVoteCompletedStatus();
		
		return isVoteCompleted;
	}

	private int getVote() {
		// Based on UI, chose someone to vote off the island
		Player playerVotedOn = new Player();
		
		return playerVotedOn.getID();
	}
}
