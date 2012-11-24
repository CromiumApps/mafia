package com.example.mafia;

public class Player {
	private String name;
	private int ID;
	
	public void setID(int id) {
		// 0 -> civilian, 1 -> mafia, 2 -> milkman, 3 -> detective, 4 -> doctor
		ID = id;
	}
	
	public int getID() {	
		return ID;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
}
