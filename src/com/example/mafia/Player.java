package com.example.mafia;

public class Player {
	private int id;
	private String name;
	private int type; // 0 -> civilian, 1 -> mafia, 2 -> milkman, 3 -> detective, 4 -> doctor
	
	public void setID(int i) {
		id = i;
	}

	public void setName(String n) {
		name = n;
	}
	
	public void setType(int t) {
		type = t;
	}

	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getType() {	
		return type;
	}
}
