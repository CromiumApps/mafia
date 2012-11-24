package com.example.mafia;

public class Player {
	private String name;
	private int ID; // 0 -> civilian, 1 -> mafia, 2 -> milkman, 3 -> detective, 4 -> doctor
	
	public void setID(int id) {
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
